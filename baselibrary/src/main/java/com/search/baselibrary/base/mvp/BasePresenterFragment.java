package com.search.baselibrary.base.mvp;

import android.content.Context;

import com.search.baselibrary.base.BaseFragment;

/**
 * author : gxl
 * email : 1739037476@qq.com
 * create data : 2018/12/21
 * Describe  : 对使用mvp模式的Fragment层进行封装
 */
public abstract class BasePresenterFragment<T extends BasePre> extends BaseFragment implements BaseView<T> {
    protected T mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mPresenter = initPresenter();
    }

    /**
     * 初始化和View相关联的P层
     */
    protected abstract T initPresenter();

    @Override
    public void setPresenter(T presenter) {
        this.mPresenter = presenter;
    }
}
