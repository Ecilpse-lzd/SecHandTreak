package com.example.lzd_develop.sechandtreak.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lzd_develop.sechandtreak.R;
import com.example.lzd_develop.sechandtreak.doman.OtherCommodity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lzd-develop on 16-4-30.
 */
public class OtherSellAdapter extends BaseAdapter {
    private LayoutInflater inflator;


    Context context;
    List<OtherCommodity.CommBean> list = null;


    public OtherSellAdapter(Context context,List<OtherCommodity.CommBean> list) {
        this.context = context;
        this.list = list;
        this.inflator = LayoutInflater.from(context);
    }


    public void addItem(OtherCommodity.CommBean commBean) {
        listIsEmpty();
        list.add(commBean);
    }

    public void addItems(List<OtherCommodity.CommBean> list) {
        listIsEmpty();
        this.list.addAll(list.size(), list);
    }

    public void refrishItems (List<OtherCommodity.CommBean> list) {
        listIsEmpty();
        this.list.clear();
        this.list.addAll(list);
    }

    public void listIsEmpty() {
        if (list == null) {
            list = new ArrayList<>();
        }
    }


    @Override
    public int getCount() {
        return 40;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = inflator.inflate(R.layout.item_listview_otherselling, null);
        ViewHolder holder = new ViewHolder(item);
        return item;
    }

    static class ViewHolder {
        @Bind(R.id.iv_goods_image)
        ImageView ivGoodsImage;
        @Bind(R.id.img_have_sold)
        ImageView imgHaveSold;
        @Bind(R.id.iv_goods_header)
        ImageView ivGoodsHeader;
        @Bind(R.id.goodsselling_item_auth)
        ImageView goodssellingItemAuth;
        @Bind(R.id.tv_goods_username)
        TextView tvGoodsUsername;
        @Bind(R.id.tv_goods_title)
        TextView tvGoodsTitle;
        @Bind(R.id.tv_goods_content)
        TextView tvGoodsContent;
        @Bind(R.id.tv_goods_price)
        TextView tvGoodsPrice;
        @Bind(R.id.tv_goods_originprice)
        TextView tvGoodsOriginprice;
        @Bind(R.id.fl_item_sell_clock)
        FrameLayout flItemSellClock;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}