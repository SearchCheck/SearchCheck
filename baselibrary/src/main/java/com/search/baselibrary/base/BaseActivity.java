package com.search.baselibrary.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.search.baselibrary.R;
import com.search.baselibrary.manager.SkinManager;
import com.search.baselibrary.utils.ActivityManagerUtil;
import com.search.baselibrary.utils.DisplayUtil;
import com.search.baselibrary.utils.StatusBarUtil;
import com.search.baselibrary.utils.UiUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        StatusBarUtil.setColor(BaseActivity.this, UiUtils.getColor(R.color.colorStatusToolBar), 1);
        //统一管理Activity
        ActivityManagerUtil.getInstance().addActivity(this);
        SkinManager.getInstance().register(this);
        //ButterKnife
        unbinder = ButterKnife.bind(this);
        mContext = this;
        //初始化
        initBefore();
        initToolbar();
        initView();
        initData();
    }

    /**
     * 初始化toolbar
     */
    protected void initToolbar() {
    }

    /**
     * 初始化data
     */
    protected void initData() {
    }

    /**
     * 初始化view
     */
    protected void initView() {
    }

    /**
     * 最新初始化
     */
    protected void initBefore() {
    }

    /**
     * 获取布局的id
     */
    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
