package com.gxl.searchcheck.mvp.test;

import com.gxl.searchcheck.mvp.BasePre;
import com.gxl.searchcheck.mvp.BaseView;

/**
 * author : gxl
 * email : 1739037476@qq.com
 * create data : 2018/12/21
 * Describe  :
 */
public interface TestContract {
    interface View extends BaseView<Presenter>{
        void loginOk();
    }
    interface Presenter extends BasePre{
        void login(String name);
    }
}
