package com.example.lzd_develop.sechandtreak.utils;

import android.view.View;
import android.widget.EditText;

/**
 * Created by lzd-develop on 16-4-25.
 */
public class UIUTILS {
    public static void showPassword(EditText editText) {
        if (editText.getInputType() == 128) {
            editText.setInputType(129);
        } else if (editText.getInputType() == 129) {
            editText.setInputType(128);
        }
    }

    public static void buttonOnClickable(View view) {

            view.setClickable(!view.isClickable());


    }
}
