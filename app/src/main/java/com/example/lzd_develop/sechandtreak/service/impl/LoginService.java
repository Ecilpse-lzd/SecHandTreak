package com.example.lzd_develop.sechandtreak.service.impl;

import android.os.Handler;
import android.os.Message;

import com.example.lzd_develop.sechandtreak.doman.User;
import com.example.lzd_develop.sechandtreak.service.ILoginService;
import com.example.lzd_develop.sechandtreak.service.ReturnType;
import com.example.lzd_develop.sechandtreak.service.ServiceFectroy;
import com.example.lzd_develop.sechandtreak.service.URLS;
import com.example.lzd_develop.sechandtreak.utils.MD5Util;
import com.litesuits.http.LiteHttp;
import com.litesuits.http.annotation.HttpUri;
import com.litesuits.http.exception.HttpException;
import com.litesuits.http.listener.HttpListener;
import com.litesuits.http.request.param.HttpRichParamModel;
import com.litesuits.http.response.Response;

import java.net.URL;

/**
 * Created by lzd-develop on 16-4-24.
 */
public class LoginService implements ILoginService {
    Handler handler;

    public LoginService(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void onLogin(String username,String password) {
        password = MD5Util.byteArrayToHex(password);
        ServiceFectroy.getLiteHttp().executeAsync(new LoginParam(username,password).setHttpListener(new HttpListener<User>() {
            @Override
            public void onSuccess(User user, Response<User> response) {
                Message msg = new Message();
                msg.what = user.getLOGIN_MESSAGE();
                msg.obj = user;
                handler.sendMessage(msg);

            }

            @Override
            public void onFailure(HttpException e, Response<User> response) {
                Message msg = new Message();
                msg.what = ReturnType.LOGIN_NETWORK_ERROR;
                handler.sendMessage(msg);
            }
        }));
    }


    @HttpUri(value = URLS.URL_LOGIN)
    private static class LoginParam extends HttpRichParamModel<User> {
        private String username;
        private String password;

        public LoginParam(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
}
