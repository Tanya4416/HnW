package com.example.shujareshi.hnm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class news extends AppCompatActivity {

    WebView webview;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        webview= (WebView)findViewById(R.id.web_view);

        //progressBar=(ProgressBar)findViewById(R.id.progress);

        webview.setWebViewClient(new MyWebViewClient());
        webview.getSettings().getJavaScriptEnabled();
        webview.loadUrl("http://medicine.news/category/medicine-cat/herbal-medicine/");

    }

    private class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url); // load the url
            return true;
        }

    }

    public void onBackPressed() {
        if(webview.canGoBack())
        {
            webview.goBack();
        }

        else{
            super.onBackPressed();
        }
    }
}
