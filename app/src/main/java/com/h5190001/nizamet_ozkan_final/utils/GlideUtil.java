package com.h5190001.nizamet_ozkan_final.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.h5190001.nizamet_ozkan_final.R;

public class GlideUtil {
    public  static  void downloadPicAndShow(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .error(R.drawable.logo)
                .centerCrop()
                .into(img);
    }
}
