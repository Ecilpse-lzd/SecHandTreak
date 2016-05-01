package com.example.lzd_develop.sechandtreak.service.impl;

import android.os.Handler;

import com.example.lzd_develop.sechandtreak.service.ILodaService;

/**
 * Created by lzd-develop on 16-5-1.
 */
public class LoadService implements ILodaService {



    Handler handler;
    public LoadService(Handler handler) {
        this.handler = handler;
    }


    @Override
    public void onLoad(int count) {

    }

    @Override
    public void onReFrish() {

    }
}
