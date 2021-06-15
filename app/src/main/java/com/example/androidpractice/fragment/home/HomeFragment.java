package com.example.androidpractice.fragment.home;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.viewpager.widget.ViewPager;

import com.example.androidpractice.R;
import com.example.androidpractice.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.pager)
    ViewPager mViewPager;
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, layout);
//        initTabs();
//        initPagers();
        return layout;
    }


}
