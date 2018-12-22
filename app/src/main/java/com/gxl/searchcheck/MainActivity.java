package com.gxl.searchcheck;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.gxl.searchcheck.ui.express.view.ExpressFragment;
import com.gxl.searchcheck.ui.movie.view.MovieFragment;
import com.gxl.searchcheck.ui.train.view.TrainFragment;
import com.gxl.searchcheck.ui.translation.view.TranslationFragment;
import com.gxl.searchcheck.ui.weather.view.WeatherFragment;
import com.search.baselibrary.base.BaseActivity;
import com.search.baselibrary.base.BaseFragment;
import com.search.baselibrary.manager.SkinManager;
import com.search.baselibrary.widget.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.home_navigation)
    NavigationView mNavigation;
    @BindView(R.id.home_drawer_layout)
    DrawerLayout mDrawerLayout;

    List<BaseFragment> mFragments;
    private BaseFragment mCurrentFragment;
    private CircleImageView mHeadView;
    private TextView mHeadTitle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        initFragments();
        mHeadView = findViewById(R.id.home_head_view);
        mHeadTitle = findViewById(R.id.home_head_title);
        //先将第一个Fragment替代
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.home_frame_layout, mFragments.get(0))
                .commit();
        mCurrentFragment = mFragments.get(0);
        //开始时关闭DrawableLayout
        mDrawerLayout.closeDrawer(Gravity.LEFT);
        //处理Navigation的点击事件
        mNavigation.setNavigationItemSelectedListener(this);
        //默认选中第一个
        mNavigation.setCheckedItem(R.id.item_movie);
        //去掉右边阴影
        mDrawerLayout.setScrimColor(Color.TRANSPARENT);
    }

    /**
     * 初始化Fragments
     */
    private void initFragments() {
        //将所有的fragment全部添加
        mFragments = new ArrayList<>();
        mFragments.add(new MovieFragment());
        mFragments.add(new TrainFragment());
        mFragments.add(new ExpressFragment());
        mFragments.add(new TranslationFragment());
        mFragments.add(new WeatherFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.item_movie:
                SkinManager.getInstance().changeSkin("black");
                switchFragment(mCurrentFragment, mFragments.get(0));
                return true;
            case R.id.item_train:
                SkinManager.getInstance().changeSkin("white");
                switchFragment(mCurrentFragment, mFragments.get(1));
                return true;
            case R.id.item_express:
                switchFragment(mCurrentFragment, mFragments.get(2));
                return true;
            case R.id.item_translation:
                switchFragment(mCurrentFragment, mFragments.get(3));
                return true;
            case R.id.item_weather:
                switchFragment(mCurrentFragment, mFragments.get(4));
                return true;
        }
        return false;
    }

    /**
     * 从from切换到to
     */
    @SuppressLint("RestrictedApi")
    private void switchFragment(BaseFragment from, BaseFragment to) {
        if (from != to) {
            mCurrentFragment = to;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (!to.isAdded()) {
                transaction.hide(from).add(R.id.home_frame_layout, to).commit();
            } else {
                transaction.hide(from).show(to).commit();
            }
            toggleDrawableLayout();
        }
    }

    /**
     * 切换左边侧滑菜单
     */
    public void toggleDrawableLayout() {
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            //如果打开了侧滑
            mDrawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            mDrawerLayout.openDrawer(Gravity.LEFT);
        }
    }
}
