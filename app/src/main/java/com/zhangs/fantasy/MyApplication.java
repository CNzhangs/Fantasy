package com.zhangs.fantasy;

import android.app.Application;

/**
 * Created by zhang on 2017/3/15.
 */

public class MyApplication extends Application {
    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        sInstance = this;
    }

    public static MyApplication getInstance() {
        if (sInstance == null) {
            throw new NullPointerException("application is null.");
        }
        return sInstance;
    }
}
