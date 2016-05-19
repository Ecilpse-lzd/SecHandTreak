package com.example.lzd_develop.sechandtreak.view.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lzd_develop.sechandtreak.BaseApplication;
import com.example.lzd_develop.sechandtreak.R;
import com.example.lzd_develop.sechandtreak.doman.OtherCommodity;
import com.example.lzd_develop.sechandtreak.service.ILodaService;
import com.example.lzd_develop.sechandtreak.service.ReturnType;
import com.example.lzd_develop.sechandtreak.service.ServiceFectroy;
import com.example.lzd_develop.sechandtreak.view.activity.ShowCommActivity;
import com.example.lzd_develop.sechandtreak.view.adapter.OtherSellAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.trinea.android.common.util.ListUtils;
import cn.trinea.android.common.view.DropDownListView;

/**
 * Created by lzd-develop on 16-4-26.
 */
public class HomeFragment extends Fragment {

    @Bind(R.id.ib_home_search)
    ImageView ibHomeSearch;
    @Bind(R.id.home_pull)
    DropDownListView homePull;
    @Bind(R.id.linearlayout_frame_loading)
    LinearLayout llFrameLoading;

    OtherSellAdapter adapter;
    ILodaService lodaService;
    OtherCommodity otherCommodity;


    public HomeFragment(OtherCommodity otherCommodity) {
        this.otherCommodity = otherCommodity;
    }

    public HomeFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        lodaService = (ILodaService) ServiceFectroy.getService(ServiceFectroy.ServiceType.loadcomm, handler);

        if (otherCommodity == null) {
            otherCommodity = new OtherCommodity();


        } else {
            llFrameLoading.setVisibility(View.GONE);
        }
        adapter = new OtherSellAdapter(getContext(), otherCommodity.getComm());
        homePull.setAdapter(adapter);

        homePull.setOnDropDownListener(new DropDownListView.OnDropDownListener() {

            @Override
            public void onDropDown() {
                lodaService.onReFrish();

            }
        });

        // set on bottom listener
        homePull.setOnBottomListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                lodaService.onLoad(0);
            }
        });

        homePull.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), ShowCommActivity.class);
                intent.putExtra("goodsid", otherCommodity.getComm().get(position).getCommId());
                startActivity(intent);

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
                    homePull.onBottomComplete();
                    homePull.setAutoLoadOnBottom(false);
                    break;

                case ReturnType.LOAD_SUCCESS:

                    getSuccess(false, ((OtherCommodity) msg.obj).getComm());

                    break;

                case ReturnType.REFRISH_ERROR_NETWORK:

                    networkError(msg.what);

                    break;

                case ReturnType.RRFRISH_ERROR_NONE:
                    BaseApplication.getToastor().showSingletonToast("暂无更新内容");
                    homePull.onDropDownComplete();
                    break;

                case ReturnType.REFRISH_SUCCESS:

                    getSuccess(true, ((OtherCommodity) msg.obj).getComm());

                    break;

                default:
            }
        }
    };

    private void getSuccess(boolean isFrish, List<OtherCommodity.CommBean> list) {
        if (isFrish) {
            homePull.setAutoLoadOnBottom(true);
            adapter.refrishItems(list);

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
            homePull.onDropDownComplete(getString(R.string.update_at)
                    + dateFormat.format(new Date()));

        } else {
            adapter.addItems(list);

            // should call onBottomComplete function of DropDownListView at end of on bottom complete.
            homePull.onBottomComplete();
        }


    }


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
