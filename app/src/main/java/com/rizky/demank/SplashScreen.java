package com.rizky.demank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.github.silvestrpredko.dotprogressbar.DotProgressBar;
import com.github.silvestrpredko.dotprogressbar.DotProgressBarBuilder;
import com.rizky.demank.Dashboard.MainDashboard;
import com.rizky.demank.Utils.SessionManager;

public class SplashScreen extends AppCompatActivity {

    int TIME_OUT = 3000;

    SessionManager sessionManager;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sessionManager = new SessionManager(this);

        mContext = this;


        new DotProgressBarBuilder(this)
                .setDotAmount(5)
                .setAnimationDirection(DotProgressBar.RIGHT_DIRECTION)
                .build();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sessionManager.getSessionLogin() == true){
                        startActivity(new Intent(SplashScreen.this, MainDashboard.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_HISTORY));
                        finish();
                } else {
                    startActivity(new Intent(SplashScreen.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                    finish();
                }
            }
        }, TIME_OUT);
    }
}
