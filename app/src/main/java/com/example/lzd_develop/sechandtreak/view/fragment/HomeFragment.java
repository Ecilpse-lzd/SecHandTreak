package com.example.lzd_develop.sechandtreak.view.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lzd_develop.sechandtreak.BaseApplication;
import com.example.lzd_develop.sechandtreak.R;
import com.example.lzd_develop.sechandtreak.service.ILodaService;
import com.example.lzd_develop.sechandtreak.service.ReturnType;
import com.example.lzd_develop.sechandtreak.service.ServiceFectroy;
import com.example.lzd_develop.sechandtreak.view.adapter.OtherSellAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.trinea.android.common.view.DropDownListView;

/**
 * Created by lzd-develop on 16-4-26.
 */
public class HomeFragment extends Fragment {

    @Bind(R.id.ib_home_search)
    ImageView ibHomeSearch;
    @Bind(R.id.home_pull)
    DropDownListView homePull;

    OtherSellAdapter adapter;
    ILodaService lodaService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        lodaService = (ILodaService) ServiceFectroy.getService(ServiceFectroy.ServiceType.load, handler);

        adapter = new OtherSellAdapter(getContext());
        homePull.setAdapter(adapter);

        homePull.setOnDropDownListener(new DropDownListView.OnDropDownListener() {

            @Override
            public void onDropDown() {
                lodaService.onLoad(0);
            }
        });

        // set on bottom listener
        homePull.setOnBottomListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                lodaService.onReFrish();
            }
        });


        return view;
    }


    @OnClick(R.id.ib_home_search)
    public void onClick() {

    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ReturnType.LOAD_ERROR_NETWORK:
                    networkError(msg.what);
                    break;
                case ReturnType.LOAD_ERROR_NONE:
                    break;
                case ReturnType.LOAD_SUCCESS:
                    break;
                case ReturnType.REFRISH_ERROR_NETWORK:
                    networkError(msg.what);
                    break;
                case ReturnType.REFRISH_SUCCESS:
                    break;
                case ReturnType.RRFRISH_ERROR_NONE:
                    break;
                default:
            }
        }
    };


    private void networkError(int msg) {
        if (msg == ReturnType.LOAD_ERROR_NETWORK) {
            homePull.onBottomComplete();
            BaseApplication.getToastor().showSingletonToast("网络连接失败，请检查网络后重试！");
        } else if (msg == ReturnType.REFRISH_ERROR_NETWORK) {
            homePull.onDropDownComplete("网络连接失败，请检查网络后重试！");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    
}
