package com.zhangs.mvp.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.zhangs.mvp.presenter.BasePresenter;

import butterknife.ButterKnife;


/**
 * View展示层，负责控制具体UI的init,getter&setter
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IViewAction {
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

    @CallSuper
    @Override
    public void beforeView() {
        this.presenter = getPresenter();
        ButterKnife.bind(this);
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
    protected void onDestroy() {
        super.onDestroy();
        if (presenter.getModel() != null) {
            presenter.getModel().onDestroy();
        }
    }

    @Override
    public void showProgress(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (progressDialog == null) {
                    progressDialog = new ProgressDialog(getApplicationContext());
                }
                if (!TextUtils.isEmpty(msg)) {
                    progressDialog.setMessage(msg);
                }
                progressDialog.show();
            }
        });
    }

    @Override
    public void hideProgress() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
            }
        });

    }
}
