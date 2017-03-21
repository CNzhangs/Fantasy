package com.zhangs.fantasy.ui.activity;

import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.zhangs.fantasy.R;
import com.zhangs.fantasy.ui.presenter.SplashPresenter;
import com.zhangs.mvp.view.BaseActivity;

import butterknife.BindView;

/**
 * Created by zhang on 2017/3/15.
 */

public class SplashActivity extends BaseActivity<SplashPresenter> {
    @BindView(R.id.vp_ad)
    ViewPager vpAd;
    @BindView(R.id.view_ad_dot)
    LinearLayout mViewAdDot;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashPresenter getPresenter() {
        return new SplashPresenter(this);
    }

    @Override
    public void initView() {
        if (vpAd != null) {
            presenter.setupViewPager(vpAd,mViewAdDot);
        }
    }

}
