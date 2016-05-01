package com.example.lzd_develop.sechandtreak.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lzd_develop.sechandtreak.BaseApplication;
import com.example.lzd_develop.sechandtreak.R;
import com.example.lzd_develop.sechandtreak.doman.User;
import com.example.lzd_develop.sechandtreak.service.ILoginService;
import com.example.lzd_develop.sechandtreak.service.IRegisterService;
import com.example.lzd_develop.sechandtreak.service.ReturnType;
import com.example.lzd_develop.sechandtreak.service.ServiceFectroy;
import com.example.lzd_develop.sechandtreak.utils.UIUTILS;
import com.litesuits.common.assist.Toastor;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lzd-develop on 16-4-25.
 */
public class RegisterActivity extends BaceActivity {
    @Bind(R.id.ib_register_return)
    ImageView ibRegisterReturn;
    @Bind(R.id.et_register_name)
    EditText etRegisterName;
    @Bind(R.id.et_register_password1)
    EditText etRegisterPassword1;
    @Bind(R.id.is_register_show_password)
    ImageView isShowPassword1;
    @Bind(R.id.cb_register_rule)
    CheckBox cbRegisterRule;
    @Bind(R.id.et_register_password_again)
    TextView etRegisterPassword_again;
    @Bind(R.id.btn_register_next)
    Button btnRegisterNext;

    Toastor toastor;
    private String mUserName;
    private String mPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        btnRegisterNext.setClickable(cbRegisterRule.isChecked());
        toastor = new Toastor(this);
    }

    @OnClick({R.id.ib_register_return, R.id.btn_register_next,
            R.id.cb_register_rule,R.id.tx_register_protocol,R.id.is_register_show_password})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_register_return:
                finish();
                break;
            case R.id.btn_register_next:

                String username = etRegisterName.getText().toString();
                String password = etRegisterPassword1.getText().toString();
                String passWordAgain = etRegisterPassword_again.getText().toString();

                if (username.equals("") || password.equals("") || passWordAgain.equals("")) {
                    toastor.showSingletonToast(R.string.register_user_pass_empty);
                    return;
                }

                if (!password.equals(passWordAgain)) {
                    toastor.showSingletonToast(R.string.register_password_equals);
                    return;
                }
                mUserName = username;
                mPassword = password;

                IRegisterService service = (IRegisterService) ServiceFectroy.getService(ServiceFectroy.ServiceType.register, handler);
                service.onRegister(username, password);
                break;
            case R.id.cb_register_rule:
                btnRegisterNext.setClickable(cbRegisterRule.isChecked());
                break;
            case R.id.tx_register_protocol:
                Intent intent = new Intent(this, ProtocolActivity.class);
                startActivity(intent);

                break;
            case R.id.is_register_show_password:
                UIUTILS.showPassword(etRegisterPassword1);
                break;
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ReturnType.REGISTER_SUCCESS:

                    registerSuccess();
                    break;
                case ReturnType.REGISTER_HAVE_USER:
                    toastor.showSingletonToast(R.string.register_have_user);
                    break;
                case ReturnType.REGISTER_NETWORK_ERROR:
                    toastor.showSingletonToast(R.string.register_netwoek_error);
                    break;
                case ReturnType.LOGIN_SUCCESS:
                    toastor.showSingletonToast(R.string.register_success);
                    BaseApplication.setIsLogin(true);
                    BaseApplication.setUser((User) msg.obj);
                    loginSuccess();
                    break;
                case ReturnType.LOGIN_NETWORK_ERROR:
                    toastor.showSingletonToast(R.string.register_login_error);
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    break;
                default:
            }
        }
    };
    private void registerSuccess() {
        ILoginService loginService = (ILoginService) ServiceFectroy.getService(ServiceFectroy.ServiceType.login, handler);
        loginService.onLogin(mUserName, mPassword);
    }

    private void loginSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}

