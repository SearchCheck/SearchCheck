package com.search.baselibrary.base;

/**
 * @author Tomze
 * @time 2018年12月18日 23:13
 * @desc 基础的Presenter
 */
public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {

    protected final V mView;
    protected M mModel;

    public BasePresenter(V mView) {
        this.mView = mView;
    }

    public abstract M getModel();
}
