package com.example.lzd_develop.sechandtreak.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lzd_develop.sechandtreak.BaseApplication;
import com.example.lzd_develop.sechandtreak.R;
import com.example.lzd_develop.sechandtreak.doman.OtherWantBuy;
import com.example.lzd_develop.sechandtreak.service.ILodaService;
import com.example.lzd_develop.sechandtreak.service.ReturnType;
import com.example.lzd_develop.sechandtreak.service.ServiceFectroy;
import com.example.lzd_develop.sechandtreak.view.adapter.OtherWantAdapter;
import com.litesuits.android.log.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.trinea.android.common.view.DropDownListView;

/**
 * Created by lzd-develop on 16-4-26.
 */
public class WantToBuyFragment extends Fragment {


    //    @Bind(R.id.menu_item_0)
//    LinearLayout menuItem0;
    @Bind(R.id.menu_item_1)
    LinearLayout menuItem1;
//    @Bind(R.id.menu_item_2)
//    LinearLayout menuItem2;
    @Bind(R.id.buying_pull)
    DropDownListView buyingPull;
    @Bind(R.id.ib_home_search)
    ImageView ibHomeSearch;

    OtherWantBuy otherWantBuy = null;
    OtherWantAdapter otherWantAdapter;


    ILodaService lodaService;

    boolean item1IsDown = true;

    public WantToBuyFragment(OtherWantBuy otherWantBuy) {
        this.otherWantBuy = otherWantBuy;
        if (this.otherWantBuy == null) {
            this.otherWantBuy = new OtherWantBuy();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_goodsbuying, container, false);
        ButterKnife.bind(this, view);
        lodaService = (ILodaService) ServiceFectroy.getService(ServiceFectroy.ServiceType.loadwant, handler);
        otherWantAdapter = new OtherWantAdapter(getContext(), otherWantBuy.getItems());

        buyingPull.setAdapter(otherWantAdapter);
        buyingPull.setOnDropDownListener(new DropDownListView.OnDropDownListener() {

            @Override
            public void onDropDown() {
                lodaService.onReFrish();

            }
        });

        // set on bottom listener
        buyingPull.setOnBottomListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                lodaService.onLoad(0);
            }
        });
        return view;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ReturnType.LOAD_ERROR_NETWORK:

                    networkError(msg.what);

                    break;

                case ReturnType.LOAD_ERROR_NONE:
                    buyingPull.onBottomComplete();
                    buyingPull.setAutoLoadOnBottom(false);
                    break;

                case ReturnType.LOAD_SUCCESS:

                    getSuccess(false, ((OtherWantBuy) msg.obj).getItems());

                    break;

                case ReturnType.REFRISH_ERROR_NETWORK:

                    networkError(msg.what);

                    break;

                case ReturnType.RRFRISH_ERROR_NONE:
                    BaseApplication.getToastor().showSingletonToast("暂无更新内容");
                    buyingPull.onDropDownComplete();
                    break;

                case ReturnType.REFRISH_SUCCESS:

                    getSuccess(true, ((OtherWantBuy) msg.obj).getItems());

                    break;

                default:
            }
        }
    };

    private void networkError(int msg) {
        if (msg == ReturnType.LOAD_ERROR_NETWORK) {
            buyingPull.onBottomComplete();
            BaseApplication.getToastor().showSingletonToast("网络连接失败，请检查网络后重试！");
        } else if (msg == ReturnType.REFRISH_ERROR_NETWORK) {
            buyingPull.onDropDownComplete("网络连接失败，请检查网络后重试！");
        }
    }

    private void getSuccess(boolean isFrish,List<OtherWantBuy.ItemBean> list) {
        if (isFrish) {
            buyingPull.setAutoLoadOnBottom(true);
            otherWantAdapter.reFrish(list);

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
            buyingPull.onDropDownComplete(getString(R.string.update_at)
                    + dateFormat.format(new Date()));

        } else {
            otherWantAdapter.addItems(list);

            // should call onBottomComplete function of DropDownListView at end of on bottom complete.
            buyingPull.onBottomComplete();
        }


    }

    @OnClick({R.id.ib_home_search, R.id.menu_item_0, R.id.menu_item_1, R.id.menu_item_2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_home_search:
                break;
            case R.id.menu_item_0:
                break;
            case R.id.menu_item_1:
                Comparator comparator;
                if (item1IsDown) {
                    item1IsDown = false;
                    comparator = new ByPriceHei();



                } else {
                    item1IsDown = true;
                    comparator = new ByPriceLow();
                }
                menuItem1.setSelected(item1IsDown);
                List<OtherWantBuy.ItemBean> list = otherWantBuy.getItems();
                OtherWantBuy.ItemBean[] items = list.toArray(new OtherWantBuy.ItemBean[list.size()]);

                Arrays.sort(items,comparator);
                list.clear();
                otherWantAdapter.frish(items);


                break;
            case R.id.menu_item_2:
                break;
        }
    }

    static class ByPriceHei implements Comparator<OtherWantBuy.ItemBean>{

        @Override
        public int compare(OtherWantBuy.ItemBean lhs, OtherWantBuy.ItemBean rhs) {
            int w =  lhs.getPrice() - rhs.getPrice();
            if (w < 0) {
                return -1;
            } else if (w == 0) {
                return 0;
            } else {
                return 1;
            }

        }
    }
    static class ByPriceLow implements Comparator<OtherWantBuy.ItemBean>{

        @Override
        public int compare(OtherWantBuy.ItemBean lhs, OtherWantBuy.ItemBean rhs) {
            int w =  lhs.getPrice() - rhs.getPrice();
            if (w < 0) {
                return 1;
            } else if (w == 0) {
                return 0;
            } else {
                return -1;
            }

        }
    }

    //short

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
