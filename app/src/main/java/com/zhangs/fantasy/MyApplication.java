package com.zhangs.fantasy;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


/**
 * Created by zhang on 2017/3/15.
 */

public class MyApplication extends Application {
    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initLibraries();
    }

    private void initLibraries() {
        Utils.init(this);
        Logger.addLogAdapter(new AndroidLogAdapter(){
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }

    public static MyApplication getInstance() {
        if (sInstance == null) {
            throw new NullPointerException("application is null.");
        }
        return sInstance;
    }
}
