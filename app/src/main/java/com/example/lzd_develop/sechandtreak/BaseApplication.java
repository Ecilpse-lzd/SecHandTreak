package com.example.lzd_develop.sechandtreak;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import com.example.lzd_develop.sechandtreak.doman.User;
import com.litesuits.common.assist.Toastor;
import com.litesuits.http.HttpConfig;
import com.litesuits.http.LiteHttp;
import com.nostra13.universalimageloader.cache.disc.impl.LimitedAgeDiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import java.io.File;

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
        initImgLoad();

    }

    private void initImgLoad() {
        String sdcardpath = Environment.getExternalStorageDirectory().getPath();
        File  cacheDir = new File(sdcardpath+"/eyunda/img");
        Log.d("sdcardpath", cacheDir.getPath());
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)

                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)
                .diskCache(new UnlimitedDiskCache(cacheDir))
//              TODO: 16-5-20  发布时删除
                .writeDebugLogs()
                .build();

        ImageLoader.getInstance().init(config);

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
