package com.gxl.searchcheck.mvp.test;

import com.gxl.searchcheck.mvp.BasePresenterFragment;

/**
 * author : gxl
 * email : 1739037476@qq.com
 * create data : 2018/12/21
 * Describe  :
 */
public class TestFragment extends BasePresenterFragment<TestContract.Presenter> implements TestContract.View{

    @Override
    protected TestContract.Presenter initPresenter() {
        return new TestPresenter(this);
    }

    @Override
    public void loginOk() {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
