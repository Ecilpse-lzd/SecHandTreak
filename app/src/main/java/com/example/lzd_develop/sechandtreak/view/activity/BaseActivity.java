package com.example.lzd_develop.sechandtreak.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lzd-develop on 16-4-25.
 */
public class BaseActivity extends AppCompatActivity {


    private static Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
