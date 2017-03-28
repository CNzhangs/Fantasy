package com.zhangs.fantasy.ui.presenter;

import android.content.Context;

import com.zhangs.mvp.model.IBaseModel;
import com.zhangs.mvp.presenter.BasePresenter;

/**
 * Created by zhang on 2017/3/25.
 */

public class MainActivityPresenter extends BasePresenter{
    public MainActivityPresenter(Context context) {
        super(context);
    }

    @Override
    public IBaseModel getModel() {
        return null;
    }
}
