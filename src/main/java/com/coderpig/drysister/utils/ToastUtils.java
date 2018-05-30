package com.coderpig.drysister.utils;

import android.view.Gravity;
import android.widget.Toast;

import com.coderpig.drysister.DrySisterApp;

/**
 * 描述：Toast 工具类
 */
public class ToastUtils {
    public static void shortToast(String msg) {
        Toast toast = Toast.makeText(DrySisterApp.getContext(),msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 40);
        toast.show();
    }

    public static void longToast(String msg) {
        Toast toast = Toast.makeText(DrySisterApp.getContext(),msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 40);
        toast.show();
    }
}
