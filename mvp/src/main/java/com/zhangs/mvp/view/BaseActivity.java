package com.zhangs.mvp.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

import com.witaction.mvp.presenter.BasePresenter;

/**
 * View展示层，负责控制具体UI的init,getter&setter
 */

public abstract class BaseActivity<P extends BasePresenter> extends Activity implements IViewAction {
    protected P presenter;
    protected ProgressDialog progressDialog;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() == 0) {
            throw new IllegalArgumentException();
        }
        setContentView(getLayoutId());
        beforeView();
        initView();
        initData();
    }

    @Override
    public void beforeView() {
        this.presenter = getPresenter();
        presenter.getModel().onStart();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().getModel().onDestroy();
    }

    @Override
    public void showProgress(String msg) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        progressDialog.setMessage(msg);
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
