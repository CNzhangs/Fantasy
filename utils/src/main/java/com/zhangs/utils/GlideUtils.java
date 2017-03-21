package com.zhangs.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by zhang on 2017/3/20.
 */

public class GlideUtils {
    public static void load(Context context, String url, ImageView iv) {
        Glide.with(context).load(url).into(iv);
    }

    public static void load(Activity activity, String url, ImageView iv) {
        Glide.with(activity).load(url).into(iv);
    }

}
