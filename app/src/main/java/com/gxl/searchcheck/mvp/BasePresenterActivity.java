package com.gxl.searchcheck.mvp;

import com.search.baselibrary.base.BaseActivity;

/**
 * author : gxl
 * email : 1739037476@qq.com
 * create data : 2018/12/21
 * Describe  : 对应要使用mvp模式的Activity的进行封装
 */
public abstract class BasePresenterActivity<T extends BasePre> extends BaseActivity implements BaseView<T> {
    protected T mPresenter;

    @Override
    protected void initBefore() {
        super.initBefore();
        this.mPresenter = initPresenter();
    }

    /**
     * 初始化和View相关联的P层
     */
    protected abstract T initPresenter();

    /**
     * 设置P层
     */
    @Override
    public void setPresenter(T presenter) {
        this.mPresenter = presenter;
    }

    /**
     * 获取P层
     */
    public T getPresenter() {
        return mPresenter;
    }
}
