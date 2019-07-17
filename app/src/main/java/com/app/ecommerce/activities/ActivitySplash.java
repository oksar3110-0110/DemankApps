package com.app.ecommerce.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.app.ecommerce.Config;
import com.app.ecommerce.R;
import com.app.ecommerce.utilities.SessionManager;

public class ActivitySplash extends AppCompatActivity {

    Boolean isCancelled = false;
    private ProgressBar progressBar;
    long id = 0;
    String url = "";
    SessionManager mses;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mses = new SessionManager(this);


        if (Config.ENABLE_RTL_MODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            }
        }

        progressBar = findViewById(R.id.progressBar);

        if (getIntent().hasExtra("nid")) {
            id = getIntent().getLongExtra("nid", 0);
            url = getIntent().getStringExtra("external_link");
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                progressBar.setVisibility(View.GONE);

                if (!isCancelled) {
                    if(mses.getSessionLogin()==true){
                        startActivity(new Intent(ActivitySplash.this, MainActivity.class));
                        finish();
                    } else {
                        startActivity(new Intent(ActivitySplash.this, LoginActivity.class));
                        finish();
                    }
                }
            }
        }, Config.SPLASH_TIME);

    }

}