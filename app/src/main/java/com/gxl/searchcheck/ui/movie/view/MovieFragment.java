package com.gxl.searchcheck.ui.movie.view;

import android.util.Log;
import android.view.View;

import com.gxl.searchcheck.R;
import com.gxl.searchcheck.net.ApiService;
import com.gxl.searchcheck.net.RetrofitManager;
import com.gxl.searchcheck.net.Test;
import com.gxl.searchcheck.net.Test2;
import com.gxl.searchcheck.utils.AppConstants;
import com.search.baselibrary.base.BaseFragment;
import com.search.baselibrary.utils.ToastUtils;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author : gxl
 * email : 1739037476@qq.com
 * create data : 2018/12/19
 * Describe  :
 */
public class MovieFragment extends BaseFragment {
    private static final String TAG = "MovieFragment";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);

    }

    @Override
    protected void initData() {
        super.initData();
        RetrofitManager.getInstance().create(ApiService.class)
                .test("你好","eng", 1, "json")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Test>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Test test) {
                        Log.i(TAG, "onNext: " + test.getData().toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        RetrofitManager.getInstance().create(ApiService.class)
                .test2(101020100)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Test2>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Test2 test2) {
                        Log.i(TAG, "onNext: " + test2.getValue().toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
