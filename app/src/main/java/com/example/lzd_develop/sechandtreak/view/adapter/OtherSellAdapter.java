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
import com.litesuits.http.data.GsonImpl;
import com.nostra13.universalimageloader.core.ImageLoader;

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
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.inflator = LayoutInflater.from(context);
    }


    public void addItem(OtherCommodity.CommBean commBean) {
        listIsEmpty();
        list.add(commBean);
    }

    public void addItems(List<OtherCommodity.CommBean> list) {
        listIsEmpty();
        this.list.addAll(list.size(), list);
        notifyDataSetChanged();
    }

    public void refrishItems (List<OtherCommodity.CommBean> list) {
        listIsEmpty();
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void listIsEmpty() {
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
        View item = inflator.inflate(R.layout.item_listview_otherselling, null);
        ViewHolder holder = new ViewHolder(item);

        OtherCommodity.CommBean comm = list.get(position);

        holder.tvGoodsUsername.setText(comm.getSeller());
        holder.tvGoodsContent.setText(comm.getTitle());
        holder.tvGoodsPrice.setText(comm.getSecPrice()+"");
        holder.tvGoodsOriginprice.setText(comm.getFirPrice()+"");
        //ImageLoader.getInstance().displayImage(comm.getCommpic(),holder.ivGoodsImage);
//

        return item;
    }

    static class ViewHolder {

        @Bind(R.id.tv_goods_username)
        TextView tvGoodsUsername;
        @Bind(R.id.tv_goods_content)
        TextView tvGoodsContent;
        @Bind(R.id.tv_goods_price)
        TextView tvGoodsPrice;
        @Bind(R.id.tv_goods_originprice)
        TextView tvGoodsOriginprice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
