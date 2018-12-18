package com.gxl.searchcheck.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gxl.searchcheck.R;
import com.gxl.searchcheck.utils.StringUtils;

/**
 * author:Tomze
 * date:2018/12/18 15:10
 * description: 标题栏
 */
public class TitleBar extends LinearLayout implements View.OnClickListener {

    //左图中字右图 = 0
    //左图中搜右图 = 1
    //左图中搜右字 = 2
    //左图中字右字 = 3
    //左字中字右字 = 4
    //左字中搜右字 = 5
    //左字中字右图 = 6
    //左字中搜右图 = 7
    private int mShowType = 0;
    private Context mContext;

    private ImageView mImgLeft;
    private ImageView mImgRight;
    private TextView mTvLeft;
    private TextView mTvRight;
    private TextView mTvTitle;
    private AutoCompleteTextView mAtvSearch;
    private OnClickViewListener onClickViewListener;

    public TitleBar(Context context) {
        super(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.widget_titlebar, this);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
        try {
            mShowType = ta.getInteger(R.styleable.TitleBar_showType, 0);
        } finally {
            ta.recycle();
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
        setType();
    }

    private void initView() {
        LayoutInflater.from(mContext).inflate(R.layout.widget_titlebar, this);
        mImgLeft = findViewById(R.id.img_left);
        mImgRight = findViewById(R.id.img_right);
        mTvLeft = findViewById(R.id.tv_left);
        mTvRight = findViewById(R.id.tv_right);
        mTvTitle = findViewById(R.id.tv_title);
        mAtvSearch = findViewById(R.id.atv_search);
        mImgLeft.setOnClickListener(this);
    }

    private void setType() {
        switch (mShowType) {
            case 0:
                //左图中字右图
                mImgLeft.setVisibility(VISIBLE);
                mTvTitle.setVisibility(VISIBLE);
                mImgRight.setVisibility(VISIBLE);
                break;
            case 1:
                //左图中搜右图
                mImgLeft.setVisibility(VISIBLE);
                mAtvSearch.setVisibility(VISIBLE);
                mImgRight.setVisibility(VISIBLE);
                break;
            case 2:
                //左图中搜右字
                mImgLeft.setVisibility(VISIBLE);
                mAtvSearch.setVisibility(VISIBLE);
                mTvTitle.setVisibility(VISIBLE);
                break;
            case 3:
                //左图中字右字
                mImgLeft.setVisibility(VISIBLE);
                mTvTitle.setVisibility(VISIBLE);
                mTvTitle.setVisibility(VISIBLE);
                break;
            case 4:
                //左字中字右字
                mTvLeft.setVisibility(VISIBLE);
                mTvTitle.setVisibility(VISIBLE);
                mTvRight.setVisibility(VISIBLE);
                break;
            case 5:
                //左字中搜右字
                mTvLeft.setVisibility(VISIBLE);
                mAtvSearch.setVisibility(VISIBLE);
                mTvRight.setVisibility(VISIBLE);
                break;
            case 6:
                //左字中字右图
                mTvLeft.setVisibility(VISIBLE);
                mTvTitle.setVisibility(VISIBLE);
                mImgRight.setVisibility(VISIBLE);
                break;
            case 7:
                //左字中搜右图
                mTvLeft.setVisibility(VISIBLE);
                mAtvSearch.setVisibility(VISIBLE);
                mImgRight.setVisibility(VISIBLE);
                break;
        }
    }

    private void setText(TextView textView, String text) {
        if (textView != null && StringUtils.isNotNull(text)) {
            textView.setText(text);
        }
    }

    private void setImage(ImageView imageView, int resource) {
        if (imageView != null && resource != 0) {
            imageView.setBackgroundResource(resource);
        }
    }

    private void setGone(View view) {
        if (view != null) {
            view.setVisibility(GONE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_left:
            case R.id.tv_left:
                onClickViewListener.onLeftClickListener();
                break;
            case R.id.img_right:
            case R.id.tv_right:
                onClickViewListener.onRightClickListener();
                break;
            case R.id.tv_title:
                break;
            case R.id.atv_search:
                break;
        }
    }

    public void setTitleBarText(String leftText, String titleText, String rightText) {
        setText(mTvLeft, leftText);
        setText(mTvTitle, titleText);
        setText(mTvRight, rightText);
    }

    public void setTitleBarImage(int left, int right) {
        setImage(mImgLeft, left);
        setImage(mImgRight, right);
    }

    public void setLeftGone() {
        setGone(mTvLeft);
        setGone(mImgLeft);
    }

    public void setRightGone() {
        setGone(mTvRight);
        setGone(mImgRight);
    }

    public void setMiddleGone() {
        setGone(mAtvSearch);
        setGone(mTvTitle);
    }

    public void setOnClickViewListener(OnClickViewListener onClickViewListener) {
        this.onClickViewListener = onClickViewListener;
    }

    public interface OnClickViewListener {
        void onLeftClickListener();

        void onRightClickListener();
    }

}
