package com.example.embedyoutubeweb;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.view.KeyEvent;

public class MainActivity extends Activity {
    private WebView webView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        WebViewClientImpl webViewClient = new WebViewClientImpl(this);

        webView.setWebViewClient(webViewClient);
        //webView.loadUrl("https://www.journaldev.com");
        String playVideo= "<html><body>Youtube video .. <br> <iframe style=\"width:100%;min-height:10px;height:100%;max-height:200px\" src=\"https://www.youtube.com/embed/tgbNymZ7vqY\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
        webView.loadData(playVideo, "text/html", "UTF-8");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

//end class//
}