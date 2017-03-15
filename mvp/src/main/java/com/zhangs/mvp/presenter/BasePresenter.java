package com.zhangs.mvp.presenter;

import android.content.Context;

import com.witaction.mvp.model.IBaseModel;

/**
 * 表示层/代理层，将Model产生的数据和View做关联，但不涉及到具体的View
 */

public abstract class BasePresenter<T extends IBaseModel> {
    protected T model;
    protected Context context;

    public abstract Class getModelClass();

    public BasePresenter(Context context) throws IllegalAccessException, InstantiationException {
        this.context = context;
        this.model = (T) getModelClass().newInstance();
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}
