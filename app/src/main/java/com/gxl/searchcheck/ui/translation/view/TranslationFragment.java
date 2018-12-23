package com.gxl.searchcheck.ui.translation.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.gxl.searchcheck.MainActivity;
import com.gxl.searchcheck.R;
import com.search.baselibrary.base.BaseFragment;
import com.search.baselibrary.utils.UiUtils;
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
        mTitle.setType(TitleBar.LEFT_IMAGE_MIDDLE_SEARCH_RIGHT_IMAGE)
                .setLeftImage(R.drawable.ic_menu)
                .setOnRightClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "右边", Toast.LENGTH_SHORT).show();
                    }
                })
                .setOnLeftClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((MainActivity)getActivity()).toggleDrawableLayout();
                    }
                });
    }
}
