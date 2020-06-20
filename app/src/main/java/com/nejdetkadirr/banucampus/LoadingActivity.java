package com.nejdetkadirr.banucampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class LoadingActivity extends AppCompatActivity {
    int second = 0;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Handler handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (second > 3) {
                    handler.removeCallbacks(runnable);
                    Intent intent = new Intent(LoadingActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    second++;
                    handler.postDelayed(runnable,1000);
                }
            }
        };
        handler.post(runnable);
    }
}