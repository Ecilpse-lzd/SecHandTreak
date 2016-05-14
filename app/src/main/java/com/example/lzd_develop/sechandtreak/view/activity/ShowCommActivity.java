package com.example.lzd_develop.sechandtreak.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lzd_develop.sechandtreak.R;
import com.example.lzd_develop.sechandtreak.view.adapter.ImagePageAdapter;
import com.example.lzd_develop.sechandtreak.view.fragment.ImagePageFragment;
import com.viewpagerindicator.CirclePageIndicator;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lzd-develop on 16-5-10.
 */
public class ShowCommActivity extends BaceActivity {


    @Bind(R.id.ib_goods_collect)
    ImageView ibGoodsCollect;
    @Bind(R.id.tv_goods_collectnum)
    TextView tvGoodsCollectnum;
    @Bind(R.id.ll_goods_collect)
    LinearLayout llGoodsCollect;
    @Bind(R.id.ib_goods_comment)
    ImageView ibGoodsComment;
    @Bind(R.id.tv_goods_commentnum)
    TextView tvGoodsCommentnum;
    @Bind(R.id.ll_goods_comment)
    LinearLayout llGoodsComment;
    @Bind(R.id.iv_goods_chat2)
    TextView ivGoodsChat2;
    @Bind(R.id.btn_goods_order)
    TextView btnGoodsOrder;
    @Bind(R.id.goods_bootm)
    FrameLayout goodsBootm;
    @Bind(R.id.goodsselling_discount)
    ImageView goodssellingDiscount;
    @Bind(R.id.goods_image_pager)
    ViewPager goodsImagePager;
    @Bind(R.id.goods_image_indicator)
    CirclePageIndicator goodsImageIndicator;
    @Bind(R.id.iv_goods_header)
    ImageView ivGoodsHeader;
    @Bind(R.id.iv_goods_auth)
    ImageView ivGoodsAuth;
    @Bind(R.id.tv_goods_username)
    TextView tvGoodsUsername;
    @Bind(R.id.goodssellinginfo_dist)
    TextView goodssellinginfoDist;
    @Bind(R.id.tv_goods_price)
    TextView tvGoodsPrice;
    @Bind(R.id.goodssellinginfo_oprice)
    TextView goodssellinginfoOprice;
    @Bind(R.id.goodsselling_browse)
    TextView goodssellingBrowse;
    @Bind(R.id.sellinginfo_free_bargin)
    LinearLayout sellinginfoFreeBargin;
    @Bind(R.id.sellinginfo_new)
    LinearLayout sellinginfoNew;
    @Bind(R.id.sellinginfo_offline)
    LinearLayout sellinginfoOffline;
    @Bind(R.id.goodssellinginfo_label)
    LinearLayout goodssellinginfoLabel;
    @Bind(R.id.tv_goods_name)
    TextView tvGoodsName;
    @Bind(R.id.goodssellinginfo_time)
    TextView goodssellinginfoTime;
    @Bind(R.id.tv_goods_content)
    TextView tvGoodsContent;
    @Bind(R.id.goodsselling_weekly_stars)
    LinearLayout goodssellingWeeklyStars;
    @Bind(R.id.goodsselling_reason)
    TextView goodssellingReason;
    @Bind(R.id.goodsselling_weekly)
    LinearLayout goodssellingWeekly;
    @Bind(R.id.turtor_guide_more)
    LinearLayout turtorGuideMore;

    ImagePageAdapter imagePageAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_sell_info);
        ButterKnife.bind(this);

        imagePageAdapter = new ImagePageAdapter(getSupportFragmentManager());
        goodsImagePager.setAdapter(imagePageAdapter);
        goodsImageIndicator.setViewPager(goodsImagePager);


    }


}























