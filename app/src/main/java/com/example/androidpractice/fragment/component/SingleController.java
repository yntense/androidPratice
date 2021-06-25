package com.example.androidpractice.fragment.component;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.androidpractice.R;
import com.example.androidpractice.base.BaseFragment;
import com.example.androidpractice.fragment.home.HomeComponentsController;
import com.example.androidpractice.fragment.home.HomeController;
import com.example.androidpractice.fragment.home.HomeFragment;
import com.example.androidpractice.fragment.home.HomeLabController;
import com.example.androidpractice.fragment.home.HomeUtilController;
import com.qmuiteam.qmui.layout.QMUIButton;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.QMUIViewPager;

import java.util.HashMap;


public class SingleController extends Controller {

    private Context mContext;

    public SingleController(Context context) {
        super(context);
        mContext = context;
        initPagers();
    }

    private HashMap<Pager, MController> mPages;
    //页面适配器
    private PagerAdapter mPagerAdapter = new PagerAdapter() {

        private int mChildCount = 0;

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public int getCount() {
            return mPages.size();
        }

        @Override
        public Object instantiateItem(final ViewGroup container, int position) {
            MController page = mPages.get(Pager.getPagerFromPositon(position));
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            container.addView(page, params);
            return page;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getItemPosition(Object object) {
            if (mChildCount == 0) {
                return POSITION_NONE;
            }
            return super.getItemPosition(object);
        }

        @Override
        public void notifyDataSetChanged() {
            mChildCount = getCount();
            super.notifyDataSetChanged();
        }
    };

    private void initPagers() {


        mPages = new HashMap<>();


        MController firstItem = new FirstItem(mContext);
        mPages.put(Pager.First, firstItem);

        MController secondItem = new SecondItem(mContext);
        mPages.put(Pager.Second, secondItem);



//        mPages.put(Pager.Second, homeUtilController);
//
//
//        mPages.put(Pager.Third, homeLabController);

        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setSwipeable(false);
        mViewPager.setCurrentItem(1);
    }
    private class MController extends LinearLayout
    {

        public MController(Context context) {
            super(context);
            setOrientation(LinearLayout.VERTICAL);
        }
    }

    private class FirstItem extends MController
    {
        private final QMUIButton mButton;
        QMUITopBarLayout mTopBar ;
        public FirstItem(Context context) {
            super(context);
            mTopBar = new QMUITopBarLayout(context);
            mTopBar.setId(View.generateViewId());
            mTopBar.setFitsSystemWindows(true);
            addView(mTopBar, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mTopBar.setTitle("bar");
            Log.i("FirstItem", "FirstItem: ");

            mButton = new QMUIButton(context);
            mButton.setId(View.generateViewId());
            addView(mButton, new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mButton.setText("下一页");
            mButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.setCurrentItem(1);
                }
            });
        }
    }

    private class SecondItem extends MController
    {
        private final QMUIButton mButton;
        QMUITopBarLayout mTopBar ;

        public SecondItem(Context context) {
            super(context);
            mTopBar = new QMUITopBarLayout(context);
            mTopBar.setId(View.generateViewId());
//            mTopBar.setFitsSystemWindows(true);
            addView(mTopBar, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mTopBar.setTitle("Bar2");

            mButton = new QMUIButton(context);
            mButton.setId(View.generateViewId());
            addView(mButton, new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mButton.setText("下一页");
            mButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.setCurrentItem(0);
                }
            });

            Log.i("FirstItem", "FirstItem: ");
        }
    }


    enum Pager {
        First, Second, Third;

        public static Pager getPagerFromPositon(int position) {
            switch (position) {
                case 0:
                    return First;
                case 1:
                    return Second;
                case 2:
                    return Third;
                default:
                    return First;
            }
        }
    }


}