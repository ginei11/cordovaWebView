package com.ingidear.webview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ingidear.webview.utilidades.FakeR;


public class WebViewActivity extends Activity {

    private String TAG = WebViewActivity.class.getSimpleName();
    private ProgressBar progress;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FakeR fakeR = new FakeR(getApplication().getApplicationContext());

        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(fakeR.getId("layout", "activity_webview"));

        webView = (WebView) this.findViewById(fakeR.getId("id", "webview"));

        progress = (ProgressBar) findViewById(fakeR.getId("id", "progressBar"));
        progress.setVisibility(View.GONE);

        String url = "https://www.google.com";
        String nombreApp = "WebViewPlugin";
        String color = "#FFff0000";
        Bundle datos;
        datos = getIntent().getExtras();

        if (datos != null) {
            try {
                url = datos.getString("Url");
                nombreApp = datos.getString("NombreApp");
                color = datos.getString("colorBar");

            } catch (NullPointerException e) {
                Log.e(TAG, "Error " + e);
            }
        }
        /**
         * Se habilita javascript
         */
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        try {
            if (getActionBar()!=null)
            {
                getActionBar().setHomeButtonEnabled(true);
                getActionBar().setDisplayHomeAsUpEnabled(true);
                getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(color)));
                getActionBar().setTitle(nombreApp);
            }

        } catch (Exception ex) {
            Log.e(TAG, "" + ex);
        }

        /**
         * Se lanza el listener de la pagina web
         */
        webView.setWebViewClient(new MWebViewClient());
        //Se carga la url
        webView.loadUrl(url);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class MWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //url = url.replaceAll("https://www.redyerba.com" , myUrl);
            logToast("MWebViewClient " + url);
            view.loadUrl(url);
            return true;
        }

        /**
         * Listener cuando la pagina termina de cargar
         *
         * @param view
         * @param url
         */
        @Override
        public void onPageFinished(WebView view, String url) {
            progress.setVisibility(View.GONE);
            WebViewActivity.this.progress.setProgress(100);

            logToast("onPageFinished " + url);
            super.onPageFinished(view, url);
        }

        /**
         * Listener cuando se empieza a cargar la pagina
         *
         * @param view
         * @param url
         * @param favicon
         */
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progress.setVisibility(View.VISIBLE);
            WebViewActivity.this.progress.setProgress(0);

            logToast("onPageStarted " + url);
            super.onPageStarted(view, url, favicon);
        }
    }

    private void logToast(String mensaje) {

        CharSequence text = mensaje;
        int duration = Toast.LENGTH_SHORT;
        Log.d(TAG, mensaje);
        Toast toast = Toast.makeText(this, text, duration);
        //toast.show();
    }
}
