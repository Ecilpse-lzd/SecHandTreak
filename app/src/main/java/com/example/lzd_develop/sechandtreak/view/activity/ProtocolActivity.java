package com.example.lzd_develop.sechandtreak.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.example.lzd_develop.sechandtreak.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 使用条约
 * Created by lzd-develop on 16-4-26.
 */
public class ProtocolActivity extends BaseActivity {
    @Bind(R.id.ib_login_return)
    ImageView ibLoginReturn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_radish_history_rules);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ib_login_return)
    public void onClick() {
        finish();
    }
}
