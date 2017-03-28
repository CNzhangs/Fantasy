package com.zhangs.fantasy.ui.fragment;

import com.zhangs.fantasy.ui.presenter.MainFragmentPresenter;
import com.zhangs.mvp.view.BaseFragment;

/**
 * Created by zhang on 2017/3/25.
 */

public class MainFragment extends BaseFragment<MainFragmentPresenter> {

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public MainFragmentPresenter getPresenter() {
        return new MainFragmentPresenter(getActivity());
    }

}
