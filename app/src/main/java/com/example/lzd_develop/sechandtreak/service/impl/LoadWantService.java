package com.example.lzd_develop.sechandtreak.service.impl;

import android.os.Handler;
import android.os.Message;

import com.example.lzd_develop.sechandtreak.doman.OtherCommodity;
import com.example.lzd_develop.sechandtreak.doman.OtherWantBuy;
import com.example.lzd_develop.sechandtreak.service.ILodaService;
import com.example.lzd_develop.sechandtreak.service.ReturnType;
import com.example.lzd_develop.sechandtreak.service.ServiceFectroy;
import com.example.lzd_develop.sechandtreak.service.URLS;
import com.litesuits.http.annotation.HttpUri;
import com.litesuits.http.exception.HttpException;
import com.litesuits.http.listener.HttpListener;
import com.litesuits.http.request.param.HttpRichParamModel;
import com.litesuits.http.response.Response;

/**
 * Created by lzd-develop on 16-5-4.
 */
public class LoadWantService implements ILodaService {


    Handler handler;

    public LoadWantService(Handler handler) {
        this.handler = handler;
    }

    public void onLoad(int count) {
        ServiceFectroy.getLiteHttp().executeAsync(
                new LoadRefrishParam(LoadOrFrish.load.toString(), count)
                        .setHttpListener(new HttpListener<OtherWantBuy>() {
                            @Override
                            public void onSuccess(OtherWantBuy otherWantBuy, Response<OtherWantBuy> response) {
                                Message msg = new Message();
                                msg.what = otherWantBuy.getMsg();
                                msg.obj = otherWantBuy;
                                handler.sendMessage(msg);
                            }

                            @Override
                            public void onFailure(HttpException e, Response<OtherWantBuy> response) {
                                Message msg = new Message();
                                msg.what = ReturnType.LOAD_ERROR_NETWORK;

                                handler.sendMessage(msg);
                            }
                        }));
    }

    @Override
    public void onReFrish() {
        ServiceFectroy.getLiteHttp().executeAsync(
                new LoadRefrishParam(LoadOrFrish.frish.toString(), 0)
                        .setHttpListener(new HttpListener<OtherWantBuy>() {
                            @Override
                            public void onSuccess(OtherWantBuy otherCommodity, Response<OtherWantBuy> response) {
                                Message msg = new Message();
                                msg.what = otherCommodity.getMsg();
                                msg.obj = otherCommodity;
                                handler.sendMessage(msg);
                            }

                            @Override
                            public void onFailure(HttpException e, Response<OtherWantBuy> response) {
                                Message msg = new Message();
                                msg.what = ReturnType.REFRISH_ERROR_NETWORK;
                                handler.sendMessage(msg);
                            }
                        }));
    }

    @HttpUri(value = URLS.URL_LOAD_AND_REFRISH_WANT)
    private static class LoadRefrishParam extends HttpRichParamModel<OtherWantBuy> {
        private String type;
        private int page;

        public LoadRefrishParam(String type, int page) {
            this.type = type;
            this.page = page;
        }


    }

}
