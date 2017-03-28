package com.zhangs.fantasy.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zhangs.fantasy.ui.callback.OnClickListener;
import com.zhangs.utils.GlideUtils;

import java.util.List;

/**
 * Created by zhang on 2017/3/20.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<String> mUrls;
    private ViewPager.LayoutParams mLayoutParams;
    OnClickListener mListener;

    public void setListener(OnClickListener listener) {
        mListener = listener;
    }

    public ViewPagerAdapter(Context context, List<String> urls) {
        mContext = context;
        mUrls = urls;
        mLayoutParams = new ViewPager.LayoutParams();
        mLayoutParams.width = ViewPager.LayoutParams.MATCH_PARENT;
        mLayoutParams.height = ViewPager.LayoutParams.MATCH_PARENT;
    }

    @Override
    public int getCount() {
        return mUrls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * 初始化ViewPager中的View
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int pos = position % mUrls.size();
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(mLayoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (pos==mUrls.size()-1){
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if (mListener!=null){
                            mListener.onclick(v,null);
                        }
                }
            });
        }
        GlideUtils.load(mContext, mUrls.get(pos), imageView);
        container.addView(imageView);
        return imageView;
    }

    /**
     * 移除ViewPager中的View
     *
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
