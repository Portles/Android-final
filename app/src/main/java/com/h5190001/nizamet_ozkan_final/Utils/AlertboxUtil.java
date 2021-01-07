package com.h5190001.nizamet_ozkan_final.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.h5190001.nizamet_ozkan_final.R;

import static androidx.core.content.ContextCompat.getColor;
import static androidx.core.content.ContextCompat.startActivity;

public class AlertboxUtil{
    public static void InternetAlertDialog(Context context, Activity activity)
    {
        AlertDialog.Builder builder =new AlertDialog.Builder(activity);
        builder.setTitle(context.getResources().getString(R.string.internet_dialog_header));
        builder.setMessage(context.getResources().getString(R.string.internet_dialog_message));
        builder.setPositiveButton(context.getResources().getString(R.string.internet_dialog_positive), (intf, i) -> {
            Intent InternetIntent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
            activity.startActivity(InternetIntent);
            intf.dismiss();
            activity.finish();
        });

        builder.setNegativeButton(context.getResources().getString(R.string.internet_dialog_negative), (intf, i) -> {
            intf.dismiss();
            activity.finish();
        });
        builder.show();
    }

    public static void QuitAlertDialog(Context context, Activity activity)
    {
        AlertDialog.Builder builder =new AlertDialog.Builder(activity);
        builder.setTitle(context.getResources().getString(R.string.quit_dialog_header));
        builder.setMessage(context.getResources().getString(R.string.quit_dialog_message));
        builder.setPositiveButton(context.getResources().getString(R.string.quit_dialog_positive), (intf, i) -> {

            intf.dismiss();
            activity.finish();
        });

        builder.setNegativeButton(context.getResources().getString(R.string.quit_dialog_negative), (intf, i) -> {
            intf.dismiss();
        });
        builder.show();
    }
}
