package com.example.lzd_develop.sechandtreak.service;

/**
 * Created by lzd-develop on 16-5-16.
 */
public interface ILoadGoodsInfoService extends IService {
    public void onLoadInfo(int goodsId,goodsType type);

    enum goodsType{
        sell,want
    }
}
