package com.search.baselibrary.attr;

import android.view.View;

/**
 * @author Tomze
 * @time 2018年12月22日 22:20
 * @desc
 */
public class SkinAttr {
    public String resName;
    public SkinAttrType attrType;


    public SkinAttr(SkinAttrType attrType, String resName)
    {
        this.resName = resName;
        this.attrType = attrType;
    }

    public void apply(View view)
    {
        attrType.apply(view, resName);
    }
}
