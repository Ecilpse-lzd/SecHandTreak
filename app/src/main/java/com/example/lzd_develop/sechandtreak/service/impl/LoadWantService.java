package com.example.lzd_develop.sechandtreak.service.impl;

import android.os.Handler;

import com.example.lzd_develop.sechandtreak.service.ILodaService;

/**
 * Created by lzd-develop on 16-5-4.
 */
public class LoadWantService implements ILodaService{


    Handler handler;

    public LoadWantService(Handler handler) {
        this.handler = handler;
    }
    @Override
    public void onLoad(int count) {

    }

    @Override
    public void onReFrish() {

    }
}
