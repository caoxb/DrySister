package com.coderpig.drysister.utils;

import android.util.Log;

import com.coderpig.drysister.BuildConfig;

/**
 * 描述：日志工具类
 */
public class LogUtils {
    private final static String TAG = "DrySister";

    public static void v(String msg) {
        if (BuildConfig.DEBUG) Log.v(TAG, msg);
    }

    public static void v(String tag, String msg) {
        if (BuildConfig.DEBUG) Log.v(tag, msg);
    }

    public static void d(String msg) {
        if (BuildConfig.DEBUG) Log.d(TAG, msg);
    }

    public static void d(String tag, String msg) {
        if (BuildConfig.DEBUG) Log.d(tag, msg);
    }

    public static void i(String msg) {
        if (BuildConfig.DEBUG) Log.i(TAG, msg);
    }

    public static void i(String tag, String msg) {
        if (BuildConfig.DEBUG) Log.i(tag, msg);
    }

    public static void w(String msg) {
        if (BuildConfig.DEBUG) Log.w(TAG, msg);
    }

    public static void w(String tag, String msg) {
        if (BuildConfig.DEBUG) Log.w(tag, msg);
    }

    public static void e(String msg) {
        if (BuildConfig.DEBUG) Log.e(TAG, msg);
    }

    public static void e(String tag, String msg) {
        if (BuildConfig.DEBUG) Log.e(tag, msg);
    }
}
