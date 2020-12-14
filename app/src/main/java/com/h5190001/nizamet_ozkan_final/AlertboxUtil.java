package com.h5190001.nizamet_ozkan_final;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;

import androidx.appcompat.app.AlertDialog;

import static androidx.core.content.ContextCompat.startActivity;

public class AlertboxUtil {
    public static void InternetAlertDialog(Context context)
    {
        AlertDialog.Builder builder =new AlertDialog.Builder(context);
        builder.setTitle("INTERNET HATASI!");
        builder.setMessage("Internete bağlı değilsiniz. Lütfen internete bağlanın");
        builder.setPositiveButton("SONRAKİ SORU", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface intf, int i) {
                Intent InternetIntent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                startActivity(InternetIntent);
                intf.dismiss();
            }
        });

        builder.setNegativeButton("ÇIKIŞ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface intf, int i) {
                intf.dismiss();
            }
        });
        builder.show();
    }
}