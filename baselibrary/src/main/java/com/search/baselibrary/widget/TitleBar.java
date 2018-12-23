package com.search.baselibrary.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.search.baselibrary.R;
import com.search.baselibrary.utils.StringUtils;

/**
 * author:Tomze
 * date:2018/12/18 15:10
 * description: 标题栏
 */
public class TitleBar extends LinearLayout {

    //左图中字右图 = 0
    public static final int LEFT_IMAGE_MIDDLE_WORD_RIGHT_IMAGE = 0;
    //左图中搜右图 = 1
    public static final int LEFT_IMAGE_MIDDLE_SEARCH_RIGHT_IMAGE = 1;
    //左图中搜右字 = 2
    public static final int LEFT_IMAGE_MIDDLE_SEARCH_RIGHT_WORD = 2;
    //左图中字右字 = 3
    public static final int LEFT_IMAGE_MIDDLE_WORD_RIGHT_WORD = 3;
    //左字中字右字 = 4
    public static final int LEFT_WORD_MIDDLE_WORD_RIGHT_WORD = 4;
    //左字中搜右字 = 5
    public static final int LEFT_WORD_MIDDLE_SEARCH_RIGHT_WORD = 5;
    //左字中字右图 = 6
    public static final int LEFT_WORD_MIDDLE_WORD_RIGHT_IMAGE = 6;
    //左字中搜右图 = 7
    public static final int LEFT_WORD_MIDDLE_SEARCH_RIGHT_IMAGE = 7;

    private int mShowType = 0;
    private Context mContext;

    private ImageView mImgLeft;
    private ImageView mImgRight;
    private TextView mTvLeft;
    private TextView mTvRight;
    private TextView mTvTitle;
    private AutoCompleteTextView mAtvSearch;

    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.widget_titlebar, this);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
        mShowType = ta.getInteger(R.styleable.TitleBar_showType, LEFT_IMAGE_MIDDLE_WORD_RIGHT_IMAGE);
        initView();
        setType();
        ta.recycle();
    }


    /**
     * 初始化View
     */
    private void initView() {
        //左右两边图片
        mImgLeft = findViewById(R.id.img_left);
        mImgRight = findViewById(R.id.img_right);
        //左中右文字
        mTvLeft = findViewById(R.id.tv_left);
        mTvRight = findViewById(R.id.tv_right);
        mTvTitle = findViewById(R.id.tv_title);
        //中间的搜索框
        mAtvSearch = findViewById(R.id.atv_search);
//        mImgLeft.setOnClickListener(this);
    }

    private void setType() {
        switch (mShowType) {
            case LEFT_IMAGE_MIDDLE_WORD_RIGHT_IMAGE:
                //左图中字右图
                mImgLeft.setVisibility(VISIBLE);
                mTvTitle.setVisibility(VISIBLE);
                mImgRight.setVisibility(VISIBLE);
                mTvLeft.setVisibility(GONE);
                mAtvSearch.setVisibility(GONE);
                mTvRight.setVisibility(GONE);
                break;
            case LEFT_IMAGE_MIDDLE_SEARCH_RIGHT_IMAGE:
                //左图中搜右图
                mImgLeft.setVisibility(VISIBLE);
                mAtvSearch.setVisibility(VISIBLE);
                mImgRight.setVisibility(VISIBLE);
                mTvLeft.setVisibility(GONE);
                mTvTitle.setVisibility(GONE);
                mTvRight.setVisibility(GONE);
                break;
            case LEFT_IMAGE_MIDDLE_SEARCH_RIGHT_WORD:
                //左图中搜右字
                mImgLeft.setVisibility(VISIBLE);
                mAtvSearch.setVisibility(VISIBLE);
                mTvRight.setVisibility(VISIBLE);
                mTvLeft.setVisibility(GONE);
                mTvTitle.setVisibility(GONE);
                mImgRight.setVisibility(GONE);
                break;
            case LEFT_IMAGE_MIDDLE_WORD_RIGHT_WORD:
                //左图中字右字
                mImgLeft.setVisibility(VISIBLE);
                mTvTitle.setVisibility(VISIBLE);
                mTvRight.setVisibility(VISIBLE);
                mTvLeft.setVisibility(GONE);
                mAtvSearch.setVisibility(GONE);
                mImgRight.setVisibility(GONE);
                break;
            case LEFT_WORD_MIDDLE_WORD_RIGHT_WORD:
                //左字中字右字
                mTvLeft.setVisibility(VISIBLE);
                mTvTitle.setVisibility(VISIBLE);
                mTvRight.setVisibility(VISIBLE);
                mTvLeft.setVisibility(GONE);
                mAtvSearch.setVisibility(GONE);
                mImgRight.setVisibility(GONE);
                break;
            case LEFT_WORD_MIDDLE_SEARCH_RIGHT_WORD:
                //左字中搜右字
                mTvLeft.setVisibility(VISIBLE);
                mAtvSearch.setVisibility(VISIBLE);
                mTvRight.setVisibility(VISIBLE);
                mImgLeft.setVisibility(GONE);
                mTvTitle.setVisibility(GONE);
                mImgRight.setVisibility(GONE);
                break;
            case LEFT_WORD_MIDDLE_WORD_RIGHT_IMAGE:
                //左字中字右图
                mTvLeft.setVisibility(VISIBLE);
                mTvTitle.setVisibility(VISIBLE);
                mImgRight.setVisibility(VISIBLE);
                mImgLeft.setVisibility(GONE);
                mAtvSearch.setVisibility(GONE);
                mTvRight.setVisibility(GONE);
                break;
            case LEFT_WORD_MIDDLE_SEARCH_RIGHT_IMAGE:
                //左字中搜右图
                mTvLeft.setVisibility(VISIBLE);
                mAtvSearch.setVisibility(VISIBLE);
                mImgRight.setVisibility(VISIBLE);
                mImgLeft.setVisibility(GONE);
                mTvTitle.setVisibility(GONE);
                mTvRight.setVisibility(GONE);
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

   /* @Override
    public void onClick(View v) {
        if (onClickViewListener == null) {
            return;
        }
        int i = v.getId();
        if (i == R.id.img_left || i == R.id.tv_left) {
            onClickViewListener.onLeftClickListener();
        } else if (i == R.id.img_right || i == R.id.tv_right) {
            onClickViewListener.onRightClickListener();
        } else if (i == R.id.tv_title) {
        } else if (i == R.id.atv_search) {
        }
    }*/

    /**
     * 设置左边的文字
     */
    public TitleBar setLeftText(String leftText) {
        setText(mTvLeft, leftText);
        return this;
    }

    /**
     * 设置中间的标题的文字
     */
    public TitleBar setTitleText(String titleText) {
        setText(mTvTitle, titleText);
        return this;
    }

    /**
     * 设置右边文字
     */
    public TitleBar setRightText(String rightText) {
        setText(mTvTitle, rightText);
        return this;
    }

    /**
     * 设置左右两边和中间的文字
     */
    public TitleBar setTitleBarText(String leftText, String titleText, String rightText) {
        setText(mTvLeft, leftText);
        setText(mTvTitle, titleText);
        setText(mTvRight, rightText);
        return this;
    }

    /**
     * 设置左边图片资源
     */
    public TitleBar setLeftImage(@DrawableRes int leftRes) {
        setImage(mImgLeft, leftRes);
        return this;
    }

    /**
     * 设置右边图片资源
     */
    public TitleBar setRightImage(@DrawableRes int rightRes) {
        setImage(mImgLeft, rightRes);
        return this;
    }

    /**
     * 设置左右两边的图像素材 没有可以写0
     */
    public TitleBar setTitleBarImage(int left, int right) {
        setImage(mImgLeft, left);
        setImage(mImgRight, right);
        return this;
    }

    /**
     * 设置左边控件隐藏
     */
    public TitleBar setLeftGone() {
        setGone(mTvLeft);
        setGone(mImgLeft);
        return this;
    }

    /**
     * 设置右边控件隐藏
     */
    public TitleBar setRightGone() {
        setGone(mTvRight);
        setGone(mImgRight);
        return this;
    }

    /**
     * 设置中间控件隐藏
     */
    public TitleBar setMiddleGone() {
        setGone(mAtvSearch);
        setGone(mTvTitle);
        return this;
    }

    /**
     * 设置左边的点击事件
     */
    public TitleBar setOnLeftClickListener(View.OnClickListener listener) {
        mTvLeft.setOnClickListener(listener);
        mImgLeft.setOnClickListener(listener);
        return this;
    }

    /**
     * 设置右边的点击事件
     */
    public TitleBar setOnRightClickListener(View.OnClickListener listener) {
        mImgRight.setOnClickListener(listener);
        mTvRight.setOnClickListener(listener);
        return this;
    }

    /**
     * 设置类型
     */
    public TitleBar setType(int type) {
        mShowType = type;
        setType();
        return this;
    }

}
