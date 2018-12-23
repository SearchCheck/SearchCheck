package com.gxl.searchcheck.ui.translation.view;

import android.support.v7.widget.RecyclerView;
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

    @BindView(R.id.titlebar)
    TitleBar mTitle;
    @BindView(R.id.recycler)
    RecyclerView mRecycler;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_traslation;
    }

    @Override
    protected void initBefore(View view) {
        super.initBefore(view);
        mTitle.setType(TitleBar.IMAGE_SEARCH_IMAGE)
                .setLeftImage(R.drawable.ic_menu)
                .set2Activity((BaseActivity) this.getActivity(), MainActivity.class)
                .setOnLeftClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((MainActivity) getActivity()).toggleDrawableLayout();
                    }
                });
    }
}
