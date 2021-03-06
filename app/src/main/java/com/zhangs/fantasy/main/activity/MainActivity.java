package com.zhangs.fantasy.main.activity;

import android.content.Context;
import android.content.Intent;

import com.zhangs.fantasy.R;
import com.zhangs.fantasy.main.fragment.MainFragment;
import com.zhangs.fantasy.main.presenter.MainActivityPresenter;
import com.zhangs.mvp.view.BaseActivity;

public class MainActivity extends BaseActivity<MainActivityPresenter> {
    public final static void launch(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainActivityPresenter getPresenter() {
        return new MainActivityPresenter(this);
    }

    @Override
    public void initView() {
        super.initView();
    }
}
