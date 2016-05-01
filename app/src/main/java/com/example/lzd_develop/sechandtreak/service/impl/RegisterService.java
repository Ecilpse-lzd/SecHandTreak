package com.example.lzd_develop.sechandtreak.service.impl;

import android.os.Handler;
import android.os.Message;

import com.example.lzd_develop.sechandtreak.doman.RegisterMsg;
import com.example.lzd_develop.sechandtreak.doman.User;
import com.example.lzd_develop.sechandtreak.service.IRegisterService;
import com.example.lzd_develop.sechandtreak.service.ReturnType;
import com.example.lzd_develop.sechandtreak.service.ServiceFectroy;
import com.example.lzd_develop.sechandtreak.service.URLS;
import com.example.lzd_develop.sechandtreak.utils.MD5Util;
import com.litesuits.http.annotation.HttpUri;
import com.litesuits.http.exception.HttpException;
import com.litesuits.http.listener.HttpListener;
import com.litesuits.http.request.param.HttpRichParamModel;
import com.litesuits.http.response.Response;

/**
 * Created by lzd-develop on 16-4-24.
 */
public class RegisterService implements IRegisterService {
    private Handler handler;

    public RegisterService(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void onRegister(String username, String password) {
        password = MD5Util.byteArrayToHex(password);
        ServiceFectroy.getLiteHttp().executeAsync(new RegisterParam(username, password).
                setHttpListener(new HttpListener<RegisterMsg>() {
                    @Override
                    public void onSuccess(RegisterMsg registerMsg, Response<RegisterMsg> response) {
                        Message msg = new Message();
                        msg.what = registerMsg.getMsg();
                        handler.sendMessage(msg);
                    }

                    @Override
                    public void onFailure(HttpException e, Response<RegisterMsg> response) {
                        Message msg = new Message();
                        msg.what = ReturnType.REGISTER_NETWORK_ERROR;
                        handler.sendMessage(msg);
                    }
                }));
    }


    @HttpUri(value = URLS.URL_REGISTER)
    private static class RegisterParam extends HttpRichParamModel<RegisterMsg> {
        private String username;
        private String password;

        public RegisterParam(String username, String password) {
            this.username = username;
            this.password = password;
        }


    }
}
