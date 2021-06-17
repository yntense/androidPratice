package com.example.androidpractice.manager;

import android.content.Context;

import com.example.androidpractice.R;
import com.example.androidpractice.base.BaseFragment;
import com.example.androidpractice.fragment.component.CPMapFragment;
import com.example.androidpractice.model.QDItemDescription;

import java.util.HashMap;
import java.util.Map;



class QDWidgetContainer {
    private static QDWidgetContainer sInstance = new QDWidgetContainer();

    private Map<Class<? extends BaseFragment>, QDItemDescription> mWidgets;

    private QDWidgetContainer() {
        mWidgets = new HashMap<>();
        mWidgets.put(CPMapFragment.class, new QDItemDescription(CPMapFragment.class, "CPMapFragment", R.mipmap.icon_grid_button, ""));
 }

    public static QDWidgetContainer getInstance() {
        return sInstance;
    }

    public QDItemDescription get(Class<? extends BaseFragment> fragment) {
        return mWidgets.get(fragment);
    }
}
