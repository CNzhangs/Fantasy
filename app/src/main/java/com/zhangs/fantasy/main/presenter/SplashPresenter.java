package com.zhangs.fantasy.main.presenter;

import android.content.Context;

import com.zhangs.fantasy.main.model.SplashModel;
import com.zhangs.fantasy.main.model.SplashModelImpl;
import com.zhangs.mvp.model.IBaseModel;
import com.zhangs.mvp.presenter.BasePresenter;

import java.util.List;

/**
 * Created by zhang on 2017/3/15.
 */

public class SplashPresenter extends BasePresenter<SplashModel> {
    List<String> adUrls;

    @Override
    public IBaseModel getModel() {
        return new SplashModelImpl();
    }

    public SplashPresenter(Context context) {
        super(context);
    }


}
