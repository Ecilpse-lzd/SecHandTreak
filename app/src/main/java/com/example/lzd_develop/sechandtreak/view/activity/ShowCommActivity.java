package com.example.lzd_develop.sechandtreak.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.lzd_develop.sechandtreak.BaseApplication;
import com.example.lzd_develop.sechandtreak.R;
import com.example.lzd_develop.sechandtreak.doman.GoodsInfo;
import com.example.lzd_develop.sechandtreak.service.ILoadGoodsInfoService;
import com.example.lzd_develop.sechandtreak.service.ReturnType;
import com.example.lzd_develop.sechandtreak.service.ServiceFectroy;
import com.example.lzd_develop.sechandtreak.utils.DensityUtil;
import com.example.lzd_develop.sechandtreak.view.adapter.ImagePageAdapter;
import com.example.lzd_develop.sechandtreak.view.fragment.ImagePageFragment;
import com.example.lzd_develop.sechandtreak.view.widget.TitleBar;
import com.example.lzd_develop.sechandtreak.view.widget.WScrollView;
import com.viewpagerindicator.CirclePageIndicator;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lzd-develop on 16-5-10.
 */
public class ShowCommActivity extends BaceActivity {


    @Bind(R.id.ib_goods_collect)//关注按钮
            ImageView ibGoodsCollect;
    @Bind(R.id.tv_goods_collectnum)//关注人数
            TextView tvGoodsCollectnum;
    @Bind(R.id.ll_goods_collect)//关注数的布局
            LinearLayout llGoodsCollect;
    @Bind(R.id.ib_goods_comment)//留言按钮
            ImageView ibGoodsComment;
    @Bind(R.id.tv_goods_commentnum)//留言数
            TextView tvGoodsCommentnum;
    @Bind(R.id.ll_goods_comment)//留言布局
            LinearLayout llGoodsComment;
    @Bind(R.id.iv_goods_chat2)//聊一聊按钮
            TextView ivGoodsChat2;
    @Bind(R.id.btn_goods_order)//购买按钮
            TextView btnGoodsOrder;
    @Bind(R.id.goodsselling_discount)//打几折
            ImageView goodssellingDiscount;
    @Bind(R.id.goods_image_pager)
    ViewPager goodsImagePager;
    @Bind(R.id.goods_image_indicator)
    CirclePageIndicator goodsImageIndicator;
    @Bind(R.id.iv_goods_header)//卖家头像
            ImageView ivGoodsHeader;
    @Bind(R.id.iv_goods_auth)//是否认证
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
    //标签
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
    @Bind(R.id.goodsselling_reason)
    TextView goodssellingReason;
    @Bind(R.id.goodsselling_weekly)
    LinearLayout goodssellingWeekly;
    @Bind(R.id.turtor_guide_more)//更多
    LinearLayout turtorGuideMore;
    @Bind(R.id.goods_info_scroll)
    WScrollView goodsInfoScoll;
    @Bind(R.id.goods_title_fl)
    TitleBar goodsTitle;
    @Bind(R.id.goods_bt_back)
    Button goodsBtBack;
    @Bind(R.id.is_load_error)
    ImageView isLoadError;
    @Bind(R.id.is_loading)
    ImageView isLoading;
    @Bind(R.id.textview_frame_loading)
    TextView tvFromFoading;
    @Bind(R.id.linearlayout_frame_loading)
    LinearLayout lyFromeLoading;
    @Bind(R.id.goods_load_success)
    RelativeLayout goodsLoadSuccess;

    private ImagePageAdapter imagePageAdapter;

    private ILoadGoodsInfoService service;
    private int goodsId;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_sell_info);
        ButterKnife.bind(this);
        setVisi(showType.isLoading);
        Intent intent = getIntent();
        goodsId = intent.getIntExtra("goodsid", 1);
        if (goodsId == -1) {
            setVisi(showType.isLoadError);
            return;
        }

        service = (ILoadGoodsInfoService) ServiceFectroy.getService(ServiceFectroy.ServiceType.loadgoodsinfo, handler);
        service.onLoadInfo(goodsId, ILoadGoodsInfoService.goodsType.sell);

    }

    private void setVisi(showType type) {
        switch (type) {
            case isLoading:
                lyFromeLoading.setVisibility(View.VISIBLE);
                isLoading.setVisibility(View.VISIBLE);
                isLoadError.setVisibility(View.GONE);
                tvFromFoading.setVisibility(View.VISIBLE);

                break;

            case isLoadError:
                lyFromeLoading.setVisibility(View.GONE);
                isLoadError.setVisibility(View.VISIBLE);
                tvFromFoading.setVisibility(View.VISIBLE);
                tvFromFoading.setText("加载失败了");

                break;
            case isLoadSeuccess:
                lyFromeLoading.setVisibility(View.GONE);
                goodsLoadSuccess.setVisibility(View.VISIBLE);

                break;

        }
    }



    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case ReturnType.LOAD_GOODS_INFO_SUCCESS:
                    setVisi(showType.isLoadSeuccess);
                    loadSuccess((GoodsInfo) msg.obj);
                    break;
                case ReturnType.LOAD_GOODS_INFO_NETWORK:
                    setVisi(showType.isLoadError);
                    break;
                case ReturnType.LOAD_GOODS_INFO_SELLED:
                    break;
                case ReturnType.LOAD_GOODS_INFO_DOWN:
                    break;
                default:

            }
        }
    };

    private void loadSuccess(GoodsInfo info) {

        imagePageAdapter = new ImagePageAdapter(getSupportFragmentManager(), info.getPicURlS());
        goodsImagePager.setAdapter(imagePageAdapter);
        goodsImageIndicator.setViewPager(goodsImagePager);

        goodsTitle.setScrollViewAndBackButton(goodsInfoScoll, goodsBtBack);

        //TODO 界面加载成功设置值
        tvGoodsUsername.setText(info.getSeller());
        tvGoodsPrice.setText(info.getPrice() + "");
        goodssellinginfoOprice.setText(info.getPriceOld() + "");
        showGoodssellingDiscount(info.getPrice(), info.getPriceOld());

        goodssellingBrowse.setText("浏览次数：" + info.getReadCount());
        tvGoodsName.setText(info.getGoodsTitle());
        //TODO 添加HTML显示
        tvGoodsContent.setText(info.getGoodsDescription());
        goodssellinginfoTime.setText(info.getAddedTime());

        goodssellinginfoDist.setText(info.getAddress());
        if (!info.isChoice()) {
            goodssellingWeekly.setVisibility(View.GONE);
        } else {
            goodssellingReason.setText(info.getChoiseCount());

        }
    }

    private enum showType {
        isLoading,isLoadError,isLoadSeuccess

    }

    private void showGoodssellingDiscount(int price, int priceOld) {
        float w = ((float) price / (float) priceOld)*100;
        int m = (int) (w / 10);
        int n = (int) (w % 10);
        int res = 0;
        Log.d("goodes", ">>>>>>>>>price: " +price+">>>>>>>>>priceOld: " +priceOld+">>>>>>>>>m: " +m+ ">>>>>>>>>n: "+n + ">>>>>>>>>w: " +w);
        switch (m) {
            case 1:
                if (n == 0) {
                    res = R.drawable.discount_one;
                } else {
                    res = R.drawable.discount_one_half;
                }

                break;
            case 2:
                if (n == 0) {
                    res = R.drawable.discount_two;
                } else {
                    res = R.drawable.discount_two_half;
                }

                break;
            case 3:
                if (n == 0) {
                    res = R.drawable.discount_three;
                } else {
                    res = R.drawable.discount_three_half;
                }

                break;
            case 4:
                if (n == 0) {
                    res = R.drawable.discount_four;
                } else {
                    res = R.drawable.discount_four_half;

                }

                break;
            case 5:
                if (n == 0) {
                    res = R.drawable.discount_five;
                } else {
                    res = R.drawable.discount_five_half;

                }

                break;
            case 6:
                if (n == 0) {
                    res = R.drawable.discount_six;
                } else {

                    res = R.drawable.discount_six_half;
                }

                break;
            case 7:
                if (n == 0) {
                    res = R.drawable.discount_seven;
                } else {

                    res = R.drawable.discount_seven_half;
                }

                break;
            case 8:
                if (n == 0) {
                    res = R.drawable.discount_eight;
                } else {

                    res = R.drawable.discount_eight_half;
                }

                break;
            case 9:
                if (n == 0) {
                    res = R.drawable.discount_nine;
                } else {
                    res = R.drawable.discount_nine_half;

                }

                break;
        }
        if (res != 0) {
            goodssellingDiscount.setImageResource(res);
        }

    }

}























