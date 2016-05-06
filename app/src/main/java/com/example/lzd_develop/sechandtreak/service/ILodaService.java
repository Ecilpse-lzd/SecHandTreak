package com.example.lzd_develop.sechandtreak.service;

/**
 * Created by lzd-develop on 16-5-1.
 */
public interface ILodaService extends IService {
    public void onLoad(int count);

    public void onReFrish();

    enum LoadOrFrish {
        load, frish
    }
}
