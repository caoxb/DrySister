package com.coderpig.drysister.utils;

import com.coderpig.drysister.DrySisterApp;

/**
 * 描述：获取文件资源工具类
 */
public class ResUtils {
    /* 获取文件资源 */
    public static String getString(int strId) {
        return DrySisterApp.getContext().getResources().getString(strId);
    }
}
