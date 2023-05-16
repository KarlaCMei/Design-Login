package com.example.diseologin.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.diseologin.R;

public class WebViewActivity extends AppCompatActivity {
    private WebView sitioWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        sitioWeb = findViewById(R.id.webview);

        sitioWeb.setWebViewClient(new WebViewClient());
        sitioWeb.getSettings().setDomStorageEnabled(true);
        sitioWeb.getSettings().setJavaScriptEnabled(true);

        sitioWeb.loadUrl("https://app.websitepolicies.com/policies/view/RJ6yiFdV");

    }
}