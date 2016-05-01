package com.example.lzd_develop.sechandtreak;

import android.app.Application;

import com.example.lzd_develop.sechandtreak.doman.User;
import com.litesuits.common.assist.Toastor;
import com.litesuits.http.HttpConfig;
import com.litesuits.http.LiteHttp;

/**
 * Created by lzd-develop on 16-4-25.
 */
public class BaseApplication extends Application {

    private static User user;

    private static boolean isLogin = false;



    private static Toastor toastor;

    @Override

    public void onCreate() {
        super.onCreate();
        toastor = new Toastor(this);

    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        BaseApplication.user = user;
    }

    public static Toastor getToastor() {
        return toastor;
    }

    public static boolean isLogin() {
        return isLogin;
    }

    public static void setIsLogin(boolean isLogin) {
        BaseApplication.isLogin = isLogin;
    }

}
