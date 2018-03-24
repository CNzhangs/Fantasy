package com.zhangs.mvp.view;

/**
 * Created by Zhangs on 2017/3/8.
 */

public interface IViewAction {

    void beforeView();

    /**
     * 控制view的初始化等
     */
    void initView();

    /**
     * 完成初始化后加载数据,在内部调用Presenter来绑定数据
     */
    void initData();


    void showProgress(String msg);

    void hideProgress();
}
