package com.example.lzd_develop.sechandtreak.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lzd_develop.sechandtreak.BaseApplication;
import com.example.lzd_develop.sechandtreak.R;
import com.example.lzd_develop.sechandtreak.doman.User;
import com.example.lzd_develop.sechandtreak.service.ILoginService;
import com.example.lzd_develop.sechandtreak.service.ReturnType;
import com.example.lzd_develop.sechandtreak.service.ServiceFectroy;
import com.example.lzd_develop.sechandtreak.utils.UIUTILS;
import com.litesuits.common.assist.Toastor;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lzd-develop on 16-4-24.
 */
public class LoginActivity extends BaceActivity {
    @Bind(R.id.et_login_name)
    EditText etLoginName;
    @Bind(R.id.et_login_password)
    EditText etLoginPassword;
    @Bind(R.id.btn_login_login)
    Button btnLoginLogin;
    @Bind(R.id.tv_login_register)
    TextView tvLoginRegister;
    @Bind(R.id.textview_frame_waiting)
    TextView textviewFrameWaiting;
    @Bind(R.id.tv_login_forget)
    TextView tvLoginForget;
    @Bind(R.id.is_show_password)
    ImageView isShowPassword;
    @Bind(R.id.ib_login_return)
    ImageView ibLoginReturn;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btn_login_login, R.id.tv_login_forget, R.id.tv_login_register, R.id.is_show_password,R.id.ib_login_return})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login_login:

                String username = etLoginName.getText().toString();
                String password = etLoginPassword.getText().toString();
                if (username.equals("") || password.equals("")) {
                    BaseApplication.getToastor().showSingletonToast(R.string.login_user_pass_empty);
                    return;
                }
                ILoginService service = (ILoginService) ServiceFectroy.getService(ServiceFectroy.ServiceType.login, handler);
                service.onLogin(username, password);

                break;
            case R.id.tv_login_forget:
                break;
            case R.id.tv_login_register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.is_show_password:
                UIUTILS.showPassword(etLoginPassword);
                break;
            case R.id.ib_login_return:
                finish();
                break;
            default:
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ReturnType.LOGIN_SUCCESS:
                    BaseApplication.setUser((User) msg.obj);
                    BaseApplication.setIsLogin(true);
                    loginSuccess();
                    break;
                case ReturnType.LOGIN_ERROR_PASSWORD:
                    loginError();
                    break;
                case ReturnType.LOGIN_ERROR_USERNAME:
                    loginError();
                    break;
                case ReturnType.LOGIN_NETWORK_ERROR:
                    BaseApplication.getToastor().showSingletonToast(R.string.login_network_error);

                    break;
                default:
            }
        }
    };


    private void loginError() {
        BaseApplication.getToastor().showSingletonToast(R.string.login_user_pass_error);
    }

    private void loginSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}






















