package com.example.lzd_develop.sechandtreak.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lzd_develop.sechandtreak.view.fragment.ImagePageFragment;

/**
 * Created by lzd-develop on 16-5-14.
 */
public class ImagePageAdapter extends FragmentPagerAdapter{
    public ImagePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new ImagePageFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
