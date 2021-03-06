package com.example.ass2androidnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebView extends AppCompatActivity {
    android.webkit.WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new Callback());

        String link = getIntent().getExtras().getString("link");

//        Toast.makeText(this, ""+link, Toast.LENGTH_SHORT).show();

        webView.loadUrl(link);
    }
    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(android.webkit.WebView view, KeyEvent event) {
            return false;
        }
    }
}