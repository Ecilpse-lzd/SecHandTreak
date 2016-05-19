package com.example.lzd_develop.sechandtreak.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import com.example.lzd_develop.sechandtreak.R;
import com.example.lzd_develop.sechandtreak.doman.OtherCommodity;
import com.example.lzd_develop.sechandtreak.doman.OtherWantBuy;
import com.example.lzd_develop.sechandtreak.service.ILodaService;
import com.example.lzd_develop.sechandtreak.service.ReturnType;
import com.example.lzd_develop.sechandtreak.service.ServiceFectroy;

/**
 * Created by lzd-develop on 16-5-1.
 */
public class WelecomActivity extends BaceActivity {

    OtherCommodity otherCommodity = null;
    OtherWantBuy otherWantBuy = null;

    boolean isReady = false;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ILodaService serviceComm = (ILodaService) ServiceFectroy.getService(ServiceFectroy.ServiceType.loadcomm, handler);
       // ILodaService serviceWant = (ILodaService) ServiceFectroy.getService(ServiceFectroy.ServiceType.loadwant, handler);
        serviceComm.onReFrish();
        //serviceWant.onReFrish();


    }



    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ReturnType.REFRISH_ERROR_NETWORK:

                    break;
                case ReturnType.REFRISH_SUCCESS:
                    if (msg.obj instanceof OtherCommodity) {
                        otherCommodity = (OtherCommodity) msg.obj;

                    } else if (msg.obj instanceof OtherWantBuy) {
                        otherWantBuy = (OtherWantBuy) msg.obj;
                    }

                    if (otherCommodity != null && otherWantBuy != null) {

                    }
                    handler.sendEmptyMessage(ReturnType.GET_REFRISH_SUCCESS);
                    break;
                case ReturnType.RRFRISH_ERROR_NONE:
                    break;
                case ReturnType.GET_REFRISH_SUCCESS:

                    Intent intent = new Intent(WelecomActivity.this, MainActivity.class);
                    intent.putExtra("comms", otherCommodity);
                    //intent.putExtra("want", otherWantBuy);
                    startActivity(intent);
                    finish();
                    break;

            }
        }
    };
}
