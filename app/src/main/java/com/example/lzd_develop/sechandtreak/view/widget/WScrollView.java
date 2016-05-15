package com.example.lzd_develop.sechandtreak.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by lzd-develop on 16-5-15.
 */
public class WScrollView extends ScrollView {
    private ScrollViewListener scrollViewListener = null;


    public WScrollView(Context context) {
        super(context);
    }

    public WScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }




    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }


    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(x, y, oldx, oldy);
        }
    }

    public interface ScrollViewListener {

        void onScrollChanged(int x, int y, int oldx, int oldy);
    }
}
