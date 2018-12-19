package com.search.baselibrary.base;

/**
 * @author Tomze
 * @time 2018年12月18日 23:17
 * @desc Contract范例
 */
public interface BaseContract {

    interface View extends BaseView<Presenter> {
    }

    abstract class Presenter extends BasePresenter<View> {
        protected Presenter(View mView) {
            super(mView);
        }
    }

}
