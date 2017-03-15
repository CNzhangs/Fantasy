package com.zhangs.mvp.presenter;

import android.content.Context;

import com.zhangs.mvp.model.IBaseModel;


/**
 * 表示层/代理层，将Model产生的数据和View做关联，但不涉及到具体的View
 */

public abstract class BasePresenter<T extends IBaseModel> {
    protected T model;
    protected Context context;

    public BasePresenter(Context context) {
        this.context = context;
    }

    public BasePresenter(Context context, T t) {
        this.context = context;
        this.model = t;
    }


    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}
