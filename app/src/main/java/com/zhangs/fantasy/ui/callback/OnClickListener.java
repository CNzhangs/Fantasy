package com.zhangs.fantasy.ui.callback;

import android.view.View;

/**
 * Created by zhang on 2017/3/25.
 */

public interface OnClickListener<T> {
    void onclick(View v,T data);
}
