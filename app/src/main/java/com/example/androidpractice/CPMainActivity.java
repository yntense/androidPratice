package com.example.androidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidpractice.base.BaseFragmentActivity;
import com.example.androidpractice.fragment.home.HomeFragment;
import com.qmuiteam.qmui.arch.annotation.DefaultFirstFragment;
import com.qmuiteam.qmui.arch.annotation.FirstFragments;
import com.qmuiteam.qmui.arch.annotation.LatestVisitRecord;

@FirstFragments(
        value = {
                HomeFragment.class,
        })
@DefaultFirstFragment(HomeFragment.class)
@LatestVisitRecord
public class CPMainActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
    }
}