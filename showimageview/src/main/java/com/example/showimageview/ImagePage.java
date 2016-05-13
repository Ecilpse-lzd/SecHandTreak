package com.example.showimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.List;

/**
 * Created by lzd-develop on 16-5-13.
 */
public class ImagePage extends ViewPager {

    int mImageCount;

    private int moveX, moveY;

    ImageView[] mImageViews;

    ViewGroup child;


    public ImagePage(Context context) {
        super(context);
    }

    public ImagePage(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ImagePage);
        mImageCount =  typedArray.getInteger(R.styleable.ImagePage_imageCount, 0);
        mImageViews = new ImageView[mImageCount];
        typedArray.recycle();

    }

    public int getmInageCount() {
        return mImageCount;
    }

    public void setmInageCount(int mInageCount) {
        this.mImageCount = mInageCount;
    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {


        final int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_MOVE:
                Log.d("Event", "in2>>>>>>>>>>");
                break;
        }
        return true;
    }

    private static class ImagePageAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return false;
        }
    }

    private static class ImageIndicator extends View{

        private int indicatorCount;

        public ImageIndicator(Context context, int indicatorCount) {
            super(context);
            this.indicatorCount = indicatorCount;
        }

        public ImageIndicator(Context context) {
            super(context);
        }

        public ImageIndicator(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public ImageIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);

            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ImageIndicator);


            typedArray.recycle();

        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);



        }
    }
}
