package com.example.lzd_develop.sechandtreak.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import com.example.lzd_develop.sechandtreak.utils.DensityUtil;

/**
 * Created by lzd-develop on 16-5-15.
 */
public class TitleBar extends FrameLayout {

    private WScrollView scrollView;
    private View back;

    public TitleBar(Context context) {
        super(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        getBackground().setAlpha(0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    public void setScrollViewAndBackButton(WScrollView scrollView,Button back) {
        this.scrollView = scrollView;
        this.back = back;
        back.getBackground().setAlpha(255);
        scrollView.setScrollViewListener(new WScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(int x, int y, int oldx, int oldy) {
                int goodsScScrolly = DensityUtil.px2dip(getContext(), TitleBar.this.scrollView.getScrollY());
                if (0 <= goodsScScrolly && goodsScScrolly < 340) {
                    goodsScScrolly = goodsScScrolly * 255 / 340;
                    getBackground().setAlpha(goodsScScrolly);
                    String color_str="#"+return2(Integer.toHexString((int)goodsScScrolly))+return2(Integer.toHexString((int)goodsScScrolly))+return2(Integer.toHexString((int)goodsScScrolly));
                    TitleBar.this.back.setBackgroundColor(new Color().parseColor(color_str));
                    TitleBar.this.back.getBackground().setAlpha(goodsScScrolly);

                }
            }
        });
    }

    String return2(String str){
        if(str.length()==1)
            return "0"+str;
        if(str.length()==0)
            return "00"+str;
        if(str.length()>2)
            return str.substring(str.length()-2,str.length());
        return str;
    }


}
