package com.example.lzd_develop.sechandtreak.service.impl;

import android.os.Handler;
import android.os.Message;

import com.example.lzd_develop.sechandtreak.doman.OtherCommodity;
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
 * Created by lzd-develop on 16-5-1.
 */
public class LoadCommService implements ILodaService {


    Handler handler;

    public LoadCommService(Handler handler) {
        this.handler = handler;
    }


    @Override
    public void onLoad(int count) {
        ServiceFectroy.getLiteHttp().executeAsync(new LoadRefrishParam(LoadRefrishParam.LoadOrFrish.load, count).setHttpListener(new HttpListener<OtherCommodity>() {
            @Override
            public void onSuccess(OtherCommodity otherCommodity, Response<OtherCommodity> response) {
                Message msg = new Message();
                msg.what = otherCommodity.getMSG();
                msg.obj = otherCommodity;
                handler.sendMessage(msg);
            }

            @Override
            public void onFailure(HttpException e, Response<OtherCommodity> response) {
                Message msg = new Message();
                msg.what = ReturnType.LOAD_ERROR_NETWORK;

                handler.sendMessage(msg);
            }
        }));
    }

    @Override
    public void onReFrish() {
        ServiceFectroy.getLiteHttp().executeAsync(new LoadRefrishParam(LoadRefrishParam.LoadOrFrish.frish, 0).setHttpListener(new HttpListener<OtherCommodity>() {
            @Override
            public void onSuccess(OtherCommodity otherCommodity, Response<OtherCommodity> response) {
                Message msg = new Message();
                msg.what = otherCommodity.getMSG();
                msg.obj = otherCommodity;
                handler.sendMessage(msg);
            }

            @Override
            public void onFailure(HttpException e, Response<OtherCommodity> response) {
                Message msg = new Message();
                msg.what = ReturnType.REFRISH_ERROR_NETWORK;
                handler.sendMessage(msg);
            }
        }));
    }

    @HttpUri(value = URLS.URL_LOAD_AND_REFRISH)
    private static class LoadRefrishParam extends HttpRichParamModel<OtherCommodity> {
        private LoadOrFrish type;
        private int page;

        public LoadRefrishParam(LoadOrFrish type, int page) {
            this.type = type;
            this.page = page;
        }

        enum LoadOrFrish {
            load, frish
        }
    }
}
