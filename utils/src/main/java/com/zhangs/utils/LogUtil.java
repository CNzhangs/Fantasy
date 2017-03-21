package com.zhangs.utils;

import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by zhang on 2017/3/21.
 */

public class LogUtil {
    public final static String TAG = "fantasy";

    public static void e(String... msg) {
        if (BuildConfig.DEBUG) {
            StringBuffer sb = buildMsg(msg);
            Log.e(TAG, sb.toString());
        }
    }
    public static void d(String... msg) {
        if (BuildConfig.DEBUG) {
            StringBuffer sb = buildMsg(msg);
            Log.d(TAG, sb.toString());
        }
    }
    @NonNull
    private static StringBuffer buildMsg(String[] msg) {
        StringBuffer sb = new StringBuffer();
        for (String str : msg) {
            sb.append(str);
        }
        return sb;
    }
}
