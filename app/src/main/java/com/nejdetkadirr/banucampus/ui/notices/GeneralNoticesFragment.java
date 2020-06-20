package com.nejdetkadirr.banucampus.ui.notices;

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
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.nejdetkadirr.banucampus.R;

public class GeneralNoticesFragment extends Fragment {
    private WebView notices_webView;
    private ProgressBar notices_progressbar;

    public static GeneralNoticesFragment newInstance() {
        return new GeneralNoticesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_general_notices, container, false);
        notices_webView = rootView.findViewById(R.id.notices_webView);
        notices_progressbar = rootView.findViewById(R.id.notices_progressBar);
        notices_progressbar.setVisibility(View.VISIBLE);
        WebSettings webSettings= notices_webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        notices_webView.loadUrl("https://www.bandirma.edu.tr/tr/www/Duyuru/Liste?k=-1");
        notices_webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                notices_progressbar.setVisibility(View.INVISIBLE);
            }
        });
        notices_webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == MotionEvent.ACTION_UP && notices_webView.canGoBack()) {
                    notices_webView.goBack();
                    return true;
                }
                return false;
            }
        });
        return rootView;
    }
}
