package com.example.lzd_develop.sechandtreak.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lzd_develop.sechandtreak.R;
import com.example.lzd_develop.sechandtreak.doman.OtherWantBuy;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lzd-develop on 16-5-5.
 */
public class OtherWantAdapter extends BaseAdapter {

    private LayoutInflater inflator;

    List<OtherWantBuy.ItemBean> list;

    private Context context;

    public OtherWantAdapter(Context context, List<OtherWantBuy.ItemBean> list) {

        this.list = list;
        empty();

        this.context = context;
        this.inflator = LayoutInflater.from(context);
    }

    public void addItems(List<OtherWantBuy.ItemBean> list) {
        empty();
        this.list.addAll(list.size(), list);
        notifyDataSetChanged();
    }

    public void reFrish(List<OtherWantBuy.ItemBean> list) {
        empty();
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    private void empty() {
        if (list == null) {
            list = new ArrayList<>();
        }
    }


    @Override
    public int getCount() {
        return list.size();
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
        View itemView = inflator.inflate(R.layout.item_listview_userbuying, null);
        ViewHolder viewHolder = new ViewHolder(itemView);
        OtherWantBuy.ItemBean itemV = list.get(position);
        viewHolder.tvGoodsTitle.setText(itemV.getTitle());
        viewHolder.tvGoodsContent.setText(itemV.getContext());
        viewHolder.tvGoodsPrice.setText(itemV.getPrice()+"");
        viewHolder.tvGoodsCommentnum.setText(itemV.getSellcount() + "");

        //TODO
        //添加时间转换
        //viewHolder.tvGoodsTime.setText("");

        return itemView;
    }

    static class ViewHolder {
        @Bind(R.id.tv_goods_title)
        TextView tvGoodsTitle;
        @Bind(R.id.tv_goods_want_price)
        TextView tvGoodsPrice;
        @Bind(R.id.tv_goods_content)
        TextView tvGoodsContent;
        @Bind(R.id.tv_goods_time)
        TextView tvGoodsTime;
        @Bind(R.id.tv_goods_commentnum)
        TextView tvGoodsCommentnum;
        @Bind(R.id.iv_goods_more)
        LinearLayout ivGoodsMore;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
        @OnClick(R.id.iv_goods_more)
        public void OnClick(){

        }
    }
}
