package com.zhangs.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhangs.mvp.presenter.BasePresenter;


/**
 * Created by Zhangs on 2017/3/8.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IViewAction {
    protected P presenter;

    //返回布局
    public abstract int getLayoutId();


    //返回代理类Presenter
    public abstract P getPresenter();


    /**
     * 可以修改代理类
     */
    public void setPresenter(P p) {
        this.presenter = p;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayoutId() == 0) {
            throw new IllegalArgumentException();
        }
        beforeView();
        View contentView = inflater.inflate(getLayoutId(), container, false);
        initView();
        initData();

        return contentView;
    }

    @Override
    public void beforeView() {
        this.presenter = getPresenter();
        if (presenter.getModel() != null) {
            presenter.getModel().onStart();
        }

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter.getModel() != null) {
            presenter.getModel().onDestroy();
        }
    }

    @Override
    public void showProgress(String msg) {

    }

    @Override
    public void hideProgress() {

    }
}
