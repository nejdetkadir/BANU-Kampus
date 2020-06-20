package com.nejdetkadirr.banucampus.ui.activities;

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

public class ActivitiesFragment extends Fragment {
    private WebView activities_webView;
    private ProgressBar activities_progressbar;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_activities, container, false);
        activities_webView = rootView.findViewById(R.id.activities_WebView);
        activities_progressbar = rootView.findViewById(R.id.activities_progressBar);
        activities_progressbar.setVisibility(View.VISIBLE);
        WebSettings webSettings= activities_webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        activities_webView.loadUrl("https://www.bandirma.edu.tr/tr/www/Haber/Liste?k=-1");
        activities_webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                activities_progressbar.setVisibility(View.INVISIBLE);
            }
        });
        activities_webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == MotionEvent.ACTION_UP && activities_webView.canGoBack()) {
                    activities_webView.goBack();
                    return true;
                }
                return false;
            }
        });
        return rootView;
    }
}