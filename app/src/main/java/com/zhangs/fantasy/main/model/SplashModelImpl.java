package com.zhangs.fantasy.main.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2017/3/15.
 */

public class SplashModelImpl implements SplashModel {
    @Override
    public void onStart() {
    }
    @Override
    public void onDestroy() {
    }

    @Override
    public List<String> getAdUrls() {
        List<String> adUrls = null;
        adUrls = loadFromNet();
        if (adUrls == null) {
            adUrls = loadFromLocal();
        }
        return adUrls;
    }

    private List<String> loadFromLocal() {
        List<String> urls = new ArrayList<>();
        urls.add("http://img.juweixin.com/article/2016/1104/t_c33f5203222ffd99e6419bc824b71466.jpg");
        urls.add("http://i.zeze.com/attachment/forum/201511/21/230758_8142.jpg");
        urls.add("http://img3.duitang.com/uploads/item/201608/24/20160824212334_UQkuW.jpeg");
        return urls;
    }

    private List<String> loadFromNet() {
        return null;
    }
}
