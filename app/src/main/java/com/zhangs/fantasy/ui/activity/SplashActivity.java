package com.zhangs.fantasy.ui.activity;

import com.zhangs.fantasy.ui.presenter.SplashPresenter;
import com.zhangs.mvp.view.BaseActivity;

/**
 * Created by zhang on 2017/3/15.
 */

public class SplashActivity extends BaseActivity<SplashPresenter>{
    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public SplashPresenter getPresenter() {
        return new SplashPresenter(this);
    }
}
