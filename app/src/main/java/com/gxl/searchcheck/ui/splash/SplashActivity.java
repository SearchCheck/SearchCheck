package com.gxl.searchcheck.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.gxl.searchcheck.MainActivity;
import com.gxl.searchcheck.R;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.search.baselibrary.utils.AppUtils;
import com.search.baselibrary.utils.ToastUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SplashActivity extends AppCompatActivity {

    private TextView mTvJump;
    private ImageView mIvSearch;
    //跳转时间
    private int JUMP_TIME=3;
    private Disposable mDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //全屏 没有状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mTvJump = findViewById(R.id.tv_jump);
        mIvSearch = findViewById(R.id.iv_search);
        JUMP_TIME = AppUtils.isDebug(this) ? 0 : 3;
        initPermissions();
    }

    /**
     * 请求权限
     */
    private void initPermissions() {
        if (XXPermissions.isHasPermission(this, Permission.WRITE_EXTERNAL_STORAGE)) {
            jump();
        } else {
            XXPermissions.with(this)
                    .permission(Permission.WRITE_EXTERNAL_STORAGE)
                    .request(new OnPermission() {
                        @Override
                        public void hasPermission(List<String> granted, boolean isAll) {
                            jump();
                        }

                        @Override
                        public void noPermission(List<String> denied, boolean quick) {
                            ToastUtils.show(R.string.permission_denied);
                            finish();
                        }
                    });
        }
    }

    /**
     * 几秒后跳转
     */
    private void jump() {
        mDisposable = Observable.intervalRange(0, JUMP_TIME, 0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        mTvJump.setText(String.format(getString(R.string.splash_jump),(JUMP_TIME - aLong) + ""));
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        Intent toMain = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(toMain);
                    }
                })
                .subscribe();
    }
}
