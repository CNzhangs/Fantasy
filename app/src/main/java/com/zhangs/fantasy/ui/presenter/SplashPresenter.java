package com.zhangs.fantasy.ui.presenter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.zhangs.fantasy.R;
import com.zhangs.fantasy.ui.adapter.ViewPagerAdapter;
import com.zhangs.fantasy.ui.model.SplashModel;
import com.zhangs.fantasy.ui.model.SplashModelImpl;
import com.zhangs.mvp.model.IBaseModel;
import com.zhangs.mvp.presenter.BasePresenter;
import com.zhangs.utils.DensityUtil;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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

    public void setupViewPager(final ViewPager viewPager, final LinearLayout dotLayout) {
        Observable.create(new ObservableOnSubscribe<List<String>>() {
            @Override
            public void subscribe(ObservableEmitter<List<String>> e) throws Exception {
                e.onNext(adUrls = model.getAdUrls());
            }
        })
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(final List<String> strings) throws Exception {
                        ViewPagerAdapter adapter = new ViewPagerAdapter(context, strings);
                        viewPager.setAdapter(adapter);
                        setupDot(strings, dotLayout);
                        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                            @Override
                            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                            }

                            @Override
                            public void onPageSelected(int position) {
                                int pos = position % strings.size();
                                for (int i = 0; i < dotLayout.getChildCount(); i++) {
                                    View view = dotLayout.getChildAt(i);
                                    view.setSelected(pos == i);
                                }
                            }

                            @Override
                            public void onPageScrollStateChanged(int state) {

                            }
                        });

                    }
                });

    }

    public void setupDot(List<String> urls, LinearLayout dotLayout) {
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(DensityUtil.dp2px(context, 10), DensityUtil.dp2px(context, 10));
        layoutParams.leftMargin = DensityUtil.dp2px(context, 8);
        layoutParams.rightMargin = DensityUtil.dp2px(context, 8);

        for (int i = 0; i < urls.size(); i++) {
            View view = new View(context);
            view.setLayoutParams(layoutParams);
            view.setBackgroundResource(R.drawable.drawable_dot_selector);
            dotLayout.addView(view);
            if (i == 0) {
                view.setSelected(true);
            }
        }

    }


}
