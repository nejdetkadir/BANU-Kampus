package com.nejdetkadirr.banucampus.ui.obs;

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

public class OBSFragment extends Fragment {
    private WebView obs_webView;
    private ProgressBar obs_progressbar;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_obs, container, false);
        obs_webView = rootView.findViewById(R.id.obs_webviewObs);
        obs_progressbar = rootView.findViewById(R.id.obs_progressBar);
        obs_progressbar.setVisibility(View.VISIBLE);
        WebSettings webSettings= obs_webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        obs_webView.loadUrl("https://obs.bandirma.edu.tr");
        obs_webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                obs_progressbar.setVisibility(View.INVISIBLE);
            }
        });
        obs_webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == MotionEvent.ACTION_UP && obs_webView.canGoBack()) {
                    obs_webView.goBack();
                    return true;
                }
                return false;
            }
        });
        return rootView;
    }
}