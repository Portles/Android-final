package com.h5190001.nizamet_ozkan_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.h5190001.nizamet_ozkan_final.R;
import com.h5190001.nizamet_ozkan_final.utils.AlertboxUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        InternetCheck();
    }

    @Override
    protected void onPause () {
        super.onPause();
        finish();
    }

    private void InternetCheck(){
        if(InternetConnectionCheck()){
            StartDelay();
        }else{
            AlertboxUtil.InternetAlertDialog(getApplicationContext(), SplashActivity.this);
        }
    }

    private void StartDelay() {
        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashActivity.this, ListActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timerThread.start();
    }

    private boolean InternetConnectionCheck(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

}