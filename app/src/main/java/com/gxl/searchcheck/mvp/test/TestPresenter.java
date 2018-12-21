package com.gxl.searchcheck.mvp.test;

import com.gxl.searchcheck.mvp.BasePresenter;

/**
 * author : gxl
 * email : 1739037476@qq.com
 * create data : 2018/12/21
 * Describe  :
 */
public class TestPresenter extends BasePresenter<TestContract.View> implements TestContract.Presenter{

    public TestPresenter(TestContract.View view) {
        super(view);
    }

    @Override
    public void login(String name) {

    }
}
