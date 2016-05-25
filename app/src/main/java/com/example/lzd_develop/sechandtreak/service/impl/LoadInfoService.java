package com.example.lzd_develop.sechandtreak.service.impl;

import android.os.Handler;
import android.os.Message;

import com.example.lzd_develop.sechandtreak.doman.GoodsInfo;
import com.example.lzd_develop.sechandtreak.doman.Info;
import com.example.lzd_develop.sechandtreak.doman.WantInfo;
import com.example.lzd_develop.sechandtreak.service.ILoadInfoService;
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
public class LoadInfoService implements ILoadInfoService {
    Handler handler;

    public LoadInfoService(Handler handler) {
        this.handler = handler;
    }


    @Override
    public void onLodaWantInfo(int wantId, goodsType type) {
        ServiceFectroy.getLiteHttp().executeAsync(new LoadWantInfoParam(type.toString(), wantId).setHttpListener(new HttpListener<WantInfo>() {
            @Override
            public void onSuccess(WantInfo wantInfo, Response<WantInfo> response) {
                Message msg = new Message();
                msg.what = wantInfo.getMSG();
                msg.obj = wantInfo;
                handler.sendMessage(msg);
            }

            @Override
            public void onFailure(HttpException e, Response<WantInfo> response) {
                handler.sendEmptyMessage(ReturnType.LOAD_WANT_INFO_NETWORK);

            }
        }));

    }

    @Override
    public void onLoadGoodsInfo(int goodsId, goodsType type) {

        ServiceFectroy.getLiteHttp().executeAsync(new LoadGoodsInfoParam(type.toString(), goodsId).setHttpListener(new HttpListener<GoodsInfo>() {
            @Override
            public void onSuccess(GoodsInfo goodsInfo, Response<GoodsInfo> response) {
                Message msg = new Message();
                msg.what = goodsInfo.getLODA_MSG();
                msg.obj = goodsInfo;
                handler.sendMessage(msg);
            }

            @Override
            public void onFailure(HttpException e, Response<GoodsInfo> response) {
                handler.sendEmptyMessage(ReturnType.LOAD_GOODS_INFO_NETWORK);
            }
        }));
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

    @HttpUri(value = URLS.URL_LOAD_GOODS_INFO)
    private static class LoadWantInfoParam extends HttpRichParamModel<WantInfo> {
        private String goodsType;
        private int goodsId;

        public LoadWantInfoParam(String goodsType, int goodsId) {
            this.goodsType = goodsType;
            this.goodsId = goodsId;
        }
    }


}
