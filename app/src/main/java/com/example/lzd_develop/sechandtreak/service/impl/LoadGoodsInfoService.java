package com.example.lzd_develop.sechandtreak.service.impl;

import android.os.Handler;
import android.os.Message;

import com.example.lzd_develop.sechandtreak.doman.GoodsInfo;
import com.example.lzd_develop.sechandtreak.service.ILoadGoodsInfoService;
import com.example.lzd_develop.sechandtreak.service.ReturnType;
import com.example.lzd_develop.sechandtreak.service.ServiceFectroy;
import com.example.lzd_develop.sechandtreak.service.URLS;
import com.litesuits.http.annotation.HttpUri;
import com.litesuits.http.exception.HttpException;
import com.litesuits.http.listener.HttpListener;
import com.litesuits.http.request.param.HttpRichParamModel;
import com.litesuits.http.response.Response;

/**
 * Created by lzd-develop on 16-5-16.
 */
public class LoadGoodsInfoService implements ILoadGoodsInfoService{
    Handler handler;

    public LoadGoodsInfoService(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void onLoadInfo(int goodsId,goodsType type) {
        ServiceFectroy.getLiteHttp().executeAsync(
                new LoadGoodsInfoParam(type.toString(), goodsId).setHttpListener(new HttpListener<GoodsInfo>() {
                    @Override
                    public void onSuccess(GoodsInfo goodsInfo, Response<GoodsInfo> response) {
                        Message msg = new Message();
                        msg.what = goodsInfo.getLODA_MSG();
                        msg.obj = goodsInfo;
                        handler.sendMessage(msg);
                    }

                    @Override
                    public void onFailure(HttpException e, Response<GoodsInfo> response) {
                        Message msg = new Message();
                        msg.what = ReturnType.LOAD_GOODS_INFO_NETWORK;
                        handler.sendMessage(msg);
                    }
                })
        );

    }

    @HttpUri(value = URLS.URL_LOAD_GOODS_INFO)
    private static class LoadGoodsInfoParam extends HttpRichParamModel<GoodsInfo> {
        private String goodsType;
        private int goodsId;

        public LoadGoodsInfoParam(String goodsType, int goodsId) {
            this.goodsType = goodsType;
            this.goodsId = goodsId;
        }
    }
}
