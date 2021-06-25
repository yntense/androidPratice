package com.example.androidpractice.fragment.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.QMUIViewPager;

public abstract class Controller extends LinearLayout {
//    private final QMUITopBarLayout mTopBar;
    protected  QMUIViewPager mViewPager;

    public Controller(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
//        mTopBar = new QMUITopBarLayout(context);
//        mTopBar.setId(View.generateViewId());
////        mTopBar.setFitsSystemWindows(true);
//        addView(mTopBar, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
////        mTopBar.setTitle("hhh");

        mViewPager = new QMUIViewPager(context);
        mViewPager.setId(View.generateViewId());
        mViewPager.setFitsSystemWindows(true);
        addView(mViewPager, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));


    }
}
