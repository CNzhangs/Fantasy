package com.zhangs.utils.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.zhangs.utils.GlideUtils;

import java.util.List;

/**
 * Created by zhang on 2017/3/22.
 */

public class AdBannerView extends RelativeLayout{
    public AdBannerView(Context context) {
        super(context);
    }

    public AdBannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AdBannerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static abstract class SimpleAdapter extends PagerAdapter{
        public SimpleAdapter() {
        }

        abstract List<String> getUrls();
        abstract View getView();

        @Override
        public int getCount() {
            return getUrls().size();
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
}
