package com.h5190001.nizamet_ozkan_final;

import android.app.Application;

public class NizametOzkan extends Application {

    public NizametOzkan instance=null;

    public NizametOzkan getApp(){
        if (instance==null){
            instance=this;
        }
        return instance;
    }
}
