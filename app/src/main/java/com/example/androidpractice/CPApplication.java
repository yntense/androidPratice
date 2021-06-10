package com.example.androidpractice;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager;

/**
 * androidPractice 的 Application 入口。
 * Created by yntense on 21/6/10.
 */
public class CPApplication extends Application {
    private static final String TAG = "CPApplication";

    private static Context context;

    public static Context getContext(){ return context;};

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        QMUISwipeBackActivityManager.init(this);
        Log.i(TAG, "onCreate:CPApplication ");
    }
}
/**
 *  skill：
 *  1./** ctrl + enter 快速注释
 *  function：
 *  1.get context
 *
 *  notice：
 *  1.需要在Manifests中的 application 标签中添加 android:name=".CPApplication"，
 *  此文件才能在MAinActivity之前被调用
 *
 *
 */
