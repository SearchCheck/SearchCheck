package com.gxl.searchcheck.ui.translation.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.gxl.searchcheck.MainActivity;
import com.gxl.searchcheck.R;
import com.search.baselibrary.base.BaseActivity;
import com.search.baselibrary.base.BaseFragment;
import com.search.baselibrary.widget.TitleBar;

import butterknife.BindView;

/**
 * author : gxl
 * email : 1739037476@qq.com
 * create data : 2018/12/19
 * Describe  :
 */
public class TranslationFragment extends BaseFragment {

    @BindView(R.id.tb_translation)
    TitleBar mTitle;
    @BindView(R.id.recycler)
    RecyclerView mRecycler;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_translation;
    }

    @Override
    protected void initBefore(View view) {
        super.initBefore(view);
        mTitle.setType(TitleBar.IMAGE_WORD_IMAGE)
                .setLeftImage(R.drawable.ic_menu)
                .setTitleText("单词")
                .set2Activity((BaseActivity) this.getActivity(), SearchActivity.class)
                .setOnLeftClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((MainActivity) getActivity()).toggleDrawableLayout();
                    }
                });
    }

    @Override
    protected void initData() {
        super.initData();
        //在标题下面放一些和英语相关的内容
    }
}
