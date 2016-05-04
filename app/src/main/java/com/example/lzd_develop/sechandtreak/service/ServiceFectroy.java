package com.example.lzd_develop.sechandtreak.service;

import android.os.Handler;

import com.example.lzd_develop.sechandtreak.service.impl.LoadCommService;
import com.example.lzd_develop.sechandtreak.view.activity.BaceActivity;
import com.example.lzd_develop.sechandtreak.service.impl.LoginService;
import com.example.lzd_develop.sechandtreak.service.impl.RegisterService;
import com.litesuits.http.HttpConfig;
import com.litesuits.http.LiteHttp;
import com.litesuits.http.request.param.HttpMethods;

/**
 * Created by lzd-develop on 16-4-25.
 */
public class ServiceFectroy {

    private static LiteHttp liteHttp = null;
    private ServiceFectroy() {    }

    public static synchronized LiteHttp getLiteHttp() {
        if (liteHttp == null) {
            HttpConfig config = new HttpConfig(BaceActivity.getContext())
                    .setDebugged(true)
                    .setDetectNetwork(true)              // detect network before connect
                    .setDefaultHttpMethod(HttpMethods.Post)
                    .setDoStatistics(true)               // statistics of time and traffic
                    .setUserAgent("Mozilla/5.0 (...)")   // set custom User-Agent
                    .setTimeOut(10000, 10000);
            liteHttp = LiteHttp.newApacheHttpClient(config);
        }
        return liteHttp;
    }


    public static IService getService(ServiceType serviceType, Handler handler) {
        switch (serviceType) {
            case login:
                return new LoginService(handler);

            case register:
                return new RegisterService(handler);
            case load:
                return new LoadCommService(handler);
            default:
                return null;
        }

    }

    public enum ServiceType{
        login,register,load
    }
}
