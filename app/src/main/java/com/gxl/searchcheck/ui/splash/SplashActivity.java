package com.gxl.searchcheck.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.gxl.searchcheck.MainActivity;
import com.gxl.searchcheck.R;
import com.gxl.searchcheck.TestActivity;
import com.gxl.searchcheck.utils.FileUtils;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.search.baselibrary.utils.AppUtils;
import com.search.baselibrary.utils.DateUtil;
import com.search.baselibrary.utils.ToastUtils;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tv_jump)
    TextView mTvJump;
    @BindView(R.id.iv_search)
    ImageView mIvSearch;
    @BindView(R.id.tv_copy_right)
    TextView mTvCopyRight;

    private Context mContext;
    private int JUMP_TIME = 5;
    private Timer timer;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        this.mContext = this;
        //全屏 没有状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        JUMP_TIME = AppUtils.isDebug(this) ? 0 : JUMP_TIME;
        mTvJump.setOnClickListener(this);
        mTvCopyRight.setText(String.format(getString(R.string.copy_right), DateUtil.getYear(new Date())));
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
                            FileUtils.createAllDirs(mContext);
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
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                JUMP_TIME--;
                if (JUMP_TIME == 0) {
                    jump2Activity();
                } else {
                    mHandler.post(new Run2ChangeTime());
                }
            }
        }, 1000, 1000);
    }

    class Run2ChangeTime implements Runnable {
        @Override
        public void run() {
            mTvJump.setText(String.format(getString(R.string.splash_jump), JUMP_TIME + ""));
        }
    }

    private void jump2Activity() {
        Intent toMain = new Intent(SplashActivity.this, TestActivity.class);
        startActivity(toMain);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_jump:
                jump2Activity();
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (JUMP_TIME > 0) {
            initPermissions();
        } else {
            jump2Activity();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (timer != null) {
            timer.cancel();
        }
    }
}
