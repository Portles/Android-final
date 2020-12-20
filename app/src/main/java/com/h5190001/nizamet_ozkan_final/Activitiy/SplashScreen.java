package com.h5190001.nizamet_ozkan_final.Activitiy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.provider.Settings;

import com.h5190001.nizamet_ozkan_final.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        InternetCheck();
    }

    private void StartDelay() {
        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timerThread.start();
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
            InternetAlertDialog();
        }
    }

    private boolean InternetConnectionCheck(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public void InternetAlertDialog()
    {
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle("INTERNET HATASI!");
        builder.setMessage("Internete bağlı değilsiniz. Lütfen internete bağlanın");
        builder.setPositiveButton("İnternet ayarları", (intf, i) -> {
            Intent InternetIntent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
            startActivity(InternetIntent);
            intf.dismiss();
            finish();
        });

        builder.setNegativeButton("ÇIKIŞ", (intf, i) -> {
            intf.dismiss();
            finish();
        });
        builder.show();
    }
}