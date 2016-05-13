package com.example.lzd_develop.sechandtreak.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.lzd_develop.sechandtreak.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lzd-develop on 16-5-10.
 */
public class ShowCommActivity extends BaceActivity {
    @Bind(R.id.selling_goods_images)
    ImageView sellingGoodsImages;
    @Bind(R.id.selling_goods_image)
    ImageView sellingGoodsImage;
    @Bind(R.id.selling_view_switcher)
    ViewSwitcher sellingViewSwitcher;
    @Bind(R.id.sellinginfo_sold)
    ImageView sellinginfoSold;
    @Bind(R.id.goods_pic_list)
    RecyclerView goodsPicList;
    @Bind(R.id.sellinginfo_sold_page)
    RelativeLayout sellinginfoSoldPage;
    @Bind(R.id.ll_goods_points)
    LinearLayout llGoodsPoints;
    @Bind(R.id.selling_voice_playing)
    ImageView sellingVoicePlaying;
    @Bind(R.id.selling_voice_duration)
    TextView sellingVoiceDuration;
    @Bind(R.id.selling_voice)
    FrameLayout sellingVoice;
    @Bind(R.id.goodsselling_discount)
    ImageView goodssellingDiscount;
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
    @Bind(R.id.goodssellinginfo_comment_list)
    ListView goodssellinginfoCommentList;
    @Bind(R.id.goodssellinginfo_comment)
    LinearLayout goodssellinginfoComment;
    @Bind(R.id.goodssellinginfo_scroll)
    ScrollView goodssellinginfoScroll;
    @Bind(R.id.goodssellinginfo_commenting_blank)
    View goodssellinginfoCommentingBlank;
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
    @Bind(R.id.ll_goods_actions)
    FrameLayout llGoodsActions;
    @Bind(R.id.goods_selling_bottom)
    FrameLayout goodsSellingBottom;
    @Bind(R.id.rl_goods_info)
    LinearLayout rlGoodsInfo;
    @Bind(R.id.goodssellinginfo_custom)
    FrameLayout goodssellinginfoCustom;
    @Bind(R.id.title_return)
    ImageView titleReturn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodssellinginfo);
        ButterKnife.bind(this);
        LinearLayoutManager mg = new LinearLayoutManager(this);
        mg.setOrientation(OrientationHelper.HORIZONTAL);
        goodsPicList.setLayoutManager(mg);
        goodsPicList.setAdapter(new ImageGroupAdapter());

    }

    private class ImageGroupAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(
                    ShowCommActivity.this).inflate(R.layout.item_image_page, parent,
                    false));
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

}
