package com.nejdetkadirr.banucampus.ui.news;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.nejdetkadirr.banucampus.R;

public class NewsFragment extends Fragment {
    private WebView news_webView;
    private ProgressBar news_progressbar;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
        news_webView = rootView.findViewById(R.id.news_WebView);
        news_progressbar = rootView.findViewById(R.id.news_progressBar);
        news_progressbar.setVisibility(View.VISIBLE);
        WebSettings webSettings= news_webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        news_webView.loadUrl("https://www.bandirma.edu.tr/tr/www/Haber/Liste?k=-1");
        news_webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                news_progressbar.setVisibility(View.INVISIBLE);
            }
        });
        news_webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == MotionEvent.ACTION_UP && news_webView.canGoBack()) {
                    news_webView.goBack();
                    return true;
                }
                return false;
            }
        });
        return rootView;
    }
}