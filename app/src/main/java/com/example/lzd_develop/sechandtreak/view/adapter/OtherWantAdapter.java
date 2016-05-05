package com.example.lzd_develop.sechandtreak.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.lzd_develop.sechandtreak.R;

/**
 * Created by lzd-develop on 16-5-5.
 */
public class OtherWantAdapter extends BaseAdapter{

    private LayoutInflater inflator;

    public OtherWantAdapter(Context context) {
        this.context = context;
        this.inflator = LayoutInflater.from(context);
    }

    private Context context;

    @Override
    public int getCount() {
        return 0;
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
        View item = inflator.inflate(R.layout.item_listview_userbuying, null);
        return item;
    }
}
