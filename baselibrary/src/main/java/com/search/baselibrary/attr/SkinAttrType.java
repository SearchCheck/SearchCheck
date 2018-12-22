package com.search.baselibrary.attr;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.search.baselibrary.manager.ResourceManager;
import com.search.baselibrary.manager.SkinManager;

/**
 * @author Tomze
 * @time 2018年12月22日 22:21
 * @desc
 */
public enum SkinAttrType {

    BACKGROUND("background")
    {
        @Override
        public void apply(View view, String resName)
        {
            Drawable drawable = getResourceManager().getDrawableByName(resName);
            if (drawable != null)
            {
                view.setBackgroundDrawable(drawable);
            } else
            {
                try{
                    int color = getResourceManager().getColor(resName);
                    view.setBackgroundColor(color);
                } catch (Resources.NotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }, COLOR("textColor")
    {
        @Override
        public void apply(View view, String resName)
        {
            ColorStateList colorList = getResourceManager().getColorStateList(resName);
            if (colorList == null) return;
            ((TextView) view).setTextColor(colorList);
        }
    }, SRC("src")
    {
        @Override
        public void apply(View view, String resName)
        {
            if (view instanceof ImageView)
            {
                Drawable drawable = getResourceManager().getDrawableByName(resName);
                if (drawable == null) return;
                ((ImageView) view).setImageDrawable(drawable);
            }

        }
    }, DIVIDER("divider")
    {
        @Override
        public void apply(View view, String resName) {
        if (view instanceof ListView) {
            Drawable divider = getResourceManager().getDrawableByName(resName);
            if (divider == null) return;
            ((ListView) view).setDivider(divider);
        }
    }
    };

    String attrType;

    SkinAttrType(String attrType)
    {
        this.attrType = attrType;
    }

    public String getAttrType()
    {
        return attrType;
    }


    public abstract void apply(View view, String resName);

    public ResourceManager getResourceManager()
    {
        return SkinManager.getInstance().getResourceManager();
    }

}
