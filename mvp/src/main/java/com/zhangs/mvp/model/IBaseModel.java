package com.zhangs.mvp.model;

/**
 * 数据层，所有数据处理均以接口形式返回数据；不涉及其他逻辑
 */

public interface IBaseModel {
    /**
     * 初始化Model时准备数据，比如new对象等。运行在UI线程；
     */
    void onStart();

    /**
     * 请求数据成功时回调，暂时还没想好怎么用；
     *
     * @param obj
     */
    void onSuccess(Object... obj);

    /**
     * 在Activity的onDestroy处回调，回收内存
     */
    void onDestroy();
}
