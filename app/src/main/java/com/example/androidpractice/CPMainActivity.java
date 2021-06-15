package com.example.androidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidpractice.base.BaseFragmentActivity;

public class CPMainActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}