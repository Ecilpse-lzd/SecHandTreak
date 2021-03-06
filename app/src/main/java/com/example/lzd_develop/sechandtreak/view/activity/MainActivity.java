package com.example.lzd_develop.sechandtreak.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;

import com.example.lzd_develop.sechandtreak.BaseApplication;
import com.example.lzd_develop.sechandtreak.R;
import com.example.lzd_develop.sechandtreak.doman.OtherCommodity;
import com.example.lzd_develop.sechandtreak.doman.OtherWantBuy;
import com.example.lzd_develop.sechandtreak.view.fragment.HomeFragment;
import com.example.lzd_develop.sechandtreak.view.fragment.MessageFragment;
import com.example.lzd_develop.sechandtreak.view.fragment.MyFragment;
import com.example.lzd_develop.sechandtreak.view.fragment.WantToBuyFragment;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    FragmentManager fm = null;

    Map<FragmentType, Fragment> fragmentMap = new HashMap<>();

    @Bind(R.id.ll_main_home)
    LinearLayout llMainHome;
    @Bind(R.id.ll_main_want)
    LinearLayout llMainWant;
    @Bind(R.id.ll_main_msg)
    LinearLayout llMainMsg;
    @Bind(R.id.ll_main_my)
    LinearLayout llMainMy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        OtherCommodity commodity = (OtherCommodity) intent.getSerializableExtra("comms");
        OtherWantBuy otherWantBuy = (OtherWantBuy) intent.getSerializableExtra("want");
        fm = getSupportFragmentManager();

        initFragments(commodity, otherWantBuy);
    }

    private void initFragments(OtherCommodity commodity, OtherWantBuy otherWantBuy) {

        fragmentMap.put(FragmentType.home, new HomeFragment(commodity));
        fragmentMap.put(FragmentType.message, new MessageFragment());
        fragmentMap.put(FragmentType.my, new MyFragment());
        fragmentMap.put(FragmentType.want, new WantToBuyFragment(otherWantBuy));
        setTabSelection(FragmentType.home);
    }

    private void hideFragments(FragmentTransaction transaction) {

        for (Fragment fragment : fragmentMap.values()) {
            transaction.hide(fragment);
        }
    }

    private void setTabSelection(FragmentType type) {

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        hideFragments(fragmentTransaction);
        if (fm.findFragmentByTag(type.toString()) == null) {
            fragmentTransaction.add(R.id.fl_main, fragmentMap.get(type), type.toString()).show(fragmentMap.get(type));
        } else {
            fragmentTransaction.show(fragmentMap.get(type));
        }
        fragmentTransaction.commit();
    }

    private void shouldLogin() {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    @OnClick({R.id.ll_main_home, R.id.ll_main_want, R.id.ll_main_msg, R.id.ll_main_my, R.id.ll_main_add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_main_home:
                setTabSelection(FragmentType.home);
                break;
            case R.id.ll_main_want:
                setTabSelection(FragmentType.want);
                break;
            case R.id.ll_main_msg:
                if (BaseApplication.isLogin()) {

                    setTabSelection(FragmentType.message);
                } else {
                    shouldLogin();

                }
                break;
            case R.id.ll_main_my:
                setTabSelection(FragmentType.my);
                break;
            case R.id.ll_main_add:
                //TODO 调试用,登陆流程完成后去掉叹号
                if (!BaseApplication.isLogin()) {

                    Intent intent = new Intent(this, WantReleaseActivity.class);
                    //overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
                    startActivity(intent);

                } else {
                    shouldLogin();

                }
                break;
        }
    }

    interface getMsg {
        public void get();
    }

    private enum FragmentType {
        home, message, my, want
    }
}
