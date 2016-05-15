package com.example.lzd_develop.sechandtreak.view.widget;

import android.content.Context;
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
    private Button back;

    public TitleBar(Context context) {
        super(context);


    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        back = (Button) getChildAt(0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setScrollView(WScrollView scrollView) {
        this.scrollView = scrollView;
        scrollView.setScrollViewListener(new WScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(int x, int y, int oldx, int oldy) {
                int goodsScScrolly = DensityUtil.px2dip(getContext(), TitleBar.this.scrollView.getScrollY());
                if (0 <= goodsScScrolly && goodsScScrolly < 340) {
                    goodsScScrolly = goodsScScrolly * 255 / 340;
                    getBackground().setAlpha(goodsScScrolly);
                }
            }
        });
    }


}
