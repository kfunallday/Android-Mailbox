package com.kssuite.mail;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainWebViewActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        SharedPreferences prefs = getSharedPreferences("KSMAIL", MODE_PRIVATE);
        String email = prefs.getString("email", "");
        String password = prefs.getString("password", "");

        WebView web = findViewById(R.id.webview);
        web.getSettings().setJavaScriptEnabled(true);

        CookieManager.getInstance().setAcceptCookie(true);

        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false; // keep everything inside the app
            }
        });

        // Auto-login URL (Roundcube or SnappyMail)
        String loginUrl = "https://webmail.mailafiniti.io/" + email + "&_pass=" + password;

        web.loadUrl(loginUrl);
    }
}
