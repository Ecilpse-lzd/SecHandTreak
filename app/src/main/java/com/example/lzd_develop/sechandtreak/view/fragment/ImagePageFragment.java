package com.example.lzd_develop.sechandtreak.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lzd_develop.sechandtreak.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lzd-develop on 16-5-14.
 */
public class ImagePageFragment extends Fragment {

    @Bind(R.id.imageView2)
    ImageView pageImageView;

    private String picURL;



    private ImagePageFragment(String picURL) {
        this.picURL = picURL;
    }

    public static ImagePageFragment newInstance(String picURL) {
         return new ImagePageFragment(picURL);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.item_image_page, container, false);
        ButterKnife.bind(this, view);
        DisplayImageOptions options=new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.signin_local_gallry)
                .showImageOnFail(R.drawable.signin_local_gallry)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        ImageLoader.getInstance().displayImage(picURL, pageImageView,options);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
