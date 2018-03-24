package com.zhangs.fantasy.main.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.zhangs.fantasy.R;
import com.zhangs.fantasy.main.presenter.SplashPresenter;
import com.zhangs.mvp.view.BaseActivity;

import butterknife.BindView;

/**
 * Created by zhang on 2017/3/15.
 */

public class SplashActivity extends BaseActivity<SplashPresenter> {
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            MainActivity.launch(SplashActivity.this);
            finish();
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashPresenter getPresenter() {
        return new SplashPresenter(this);
    }

    @Override
    public void initData() {
        super.initData();
        handler.sendMessageDelayed(Message.obtain(), 2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }
}
