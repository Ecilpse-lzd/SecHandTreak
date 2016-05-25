package com.example.lzd_develop.sechandtreak.service;

/**
 * Created by lzd-develop on 16-5-16.
 */
public interface ILoadInfoService extends IService {

    public void onLodaWantInfo(int wantId, goodsType type);

    public void onLoadGoodsInfo(int goodsId, goodsType type);


    enum goodsType{
        sell,want
    }
}
