package com.example.lzd_develop.sechandtreak.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.lzd_develop.sechandtreak.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lzd-develop on 16-5-30.
 */
public class WantReleaseActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_release);
        ButterKnife.bind(this);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        //// TODO: 16-6-30  为R.id.backto_home按钮添加动画


    }


    @OnClick({R.id.want_release_add_bt_goods, R.id.want_release_add_bt_wantto, R.id.backto_home})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.want_release_add_bt_goods:
                break;
            case R.id.want_release_add_bt_wantto:
                break;
            case R.id.backto_home:
                finish();
                break;
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
