package com.ingidear.webview;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    private String TAG = WebViewActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView webView = (WebView) this.findViewById(R.id.webview);

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
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {

                WebViewActivity.this.setProgress(progress * 1000);
            }
        });
        webView.loadUrl(url);

        try {
            //getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(color)));
            getSupportActionBar().setTitle(nombreApp);
        } catch (Exception ex) {
            Log.e(TAG, "" + ex);
        }
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

}
