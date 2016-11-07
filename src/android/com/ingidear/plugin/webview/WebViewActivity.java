package com.ingidear.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        android.webkit.WebView myWebView = (android.webkit.WebView) this.findViewById(R.id.webview);
        myWebView.loadUrl("https://www.uniandinos.org.co");
    }
}
