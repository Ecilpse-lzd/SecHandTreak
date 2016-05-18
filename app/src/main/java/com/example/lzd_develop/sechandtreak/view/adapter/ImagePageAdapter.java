package com.example.lzd_develop.sechandtreak.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lzd_develop.sechandtreak.view.fragment.ImagePageFragment;

import java.util.List;

/**
 * Created by lzd-develop on 16-5-14.
 */
public class ImagePageAdapter extends FragmentPagerAdapter {

    private List<String> urlList;

    public ImagePageAdapter(FragmentManager fm, List<String> urlList) {
        super(fm);
        this.urlList = urlList;
    }


    @Override
    public Fragment getItem(int position) {
        return ImagePageFragment.newInstance(urlList.get(position));
    }

    @Override
    public int getCount() {
        return urlList.size();
    }
}
