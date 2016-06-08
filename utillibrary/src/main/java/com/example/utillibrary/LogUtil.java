package com.example.utillibrary;

import android.util.Log;

/**
 * Created by lzd-develop on 16-5-30.
 */
public class LogUtil{
    private static boolean isDebug = false;
    private static String TAG = "";


    public static void setTAG(String TAG) {
        LogUtil.TAG = TAG;
    }

    public static void setDebug(boolean debug) {
        isDebug = debug;
    }

    public static void d(String log) {
        if (isDebug) {
            Log.d(TAG, log);
        }
    }






}
