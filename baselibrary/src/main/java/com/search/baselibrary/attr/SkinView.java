package com.search.baselibrary.attr;

import android.view.View;

import java.util.List;

/**
 * @author Tomze
 * @time 2018年12月22日 22:21
 * @desc
 */
public class SkinView {
    public View view ;
    public List<SkinAttr> attrs;

    public SkinView(View view, List<SkinAttr> skinAttrs)
    {
        this.view = view;
        this.attrs = skinAttrs;
    }

    public void apply()
    {
        // View view = viewRef.get();
        if (view == null) return;

        for (SkinAttr attr : attrs)
        {
            attr.apply(view);
        }
    }
}
