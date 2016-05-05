package com.example.lzd_develop.sechandtreak.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.lzd_develop.sechandtreak.R;
import com.example.lzd_develop.sechandtreak.view.adapter.OtherWantAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.trinea.android.common.view.DropDownListView;

/**
 * Created by lzd-develop on 16-4-26.
 */
public class WantToBuyFragment extends Fragment {


    OtherWantAdapter otherWantAdapter;
    @Bind(R.id.menu_item_0)
    LinearLayout menuItem0;
    @Bind(R.id.menu_item_1)
    LinearLayout menuItem1;
    @Bind(R.id.menu_item_2)
    LinearLayout menuItem2;
    @Bind(R.id.buying_pull)
    DropDownListView buyingPull;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goodsbuying, container, false);
        ButterKnife.bind(this, view);
        otherWantAdapter = new OtherWantAdapter(getContext());
        buyingPull.setAdapter(otherWantAdapter);

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
