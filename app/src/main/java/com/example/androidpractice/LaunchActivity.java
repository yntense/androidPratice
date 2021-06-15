package com.example.androidpractice;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.qmuiteam.qmui.arch.QMUILatestVisit;
import com.qmuiteam.qmui.arch.annotation.ActivityScheme;

import static android.content.ContentValues.TAG;


@ActivityScheme(name = "launcher") //启动，注解方式
public class LaunchActivity extends Activity {
//    private static final String TAG = "launcher";

    private static final int PERMISSIONS_REQUEST_CODE = 10;//自己设置的权限请求代码
    //权限数组
    private static final String[] PERMISSIONS_REQUIRED = {Manifest.permission.WRITE_EXTERNAL_STORAGE};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
        //intent activity 启动标志
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
        //权限获取
        if (allPermissionsGranted()) {
            Log.i(TAG, "allPermissionsGranted()");
            doAfterPermissionsGranted();
        } else {
            //对整个 PERMISSIONS_REQUIRED数组内的权限进行请求
            Log.i(TAG, "doAfterPermissionsGranted");
            ActivityCompat.requestPermissions(this, PERMISSIONS_REQUIRED, PERMISSIONS_REQUEST_CODE);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSIONS_REQUEST_CODE) {
            if (allPermissionsGranted()) {
                Log.i(TAG, "doAfterPermissionsGranted()");
                doAfterPermissionsGranted();
            } else {
                Toast.makeText(this, "Permissions not granted by the user.", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    private void doAfterPermissionsGranted() {
        Intent intent = QMUILatestVisit.intentOfLatestVisit(this);
        if (intent == null) {
            intent = new Intent(this, CPMainActivity.class);
        }
        startActivity(intent);
        finish();
    }

    private boolean allPermissionsGranted() {
        for (String permission : PERMISSIONS_REQUIRED) {
            //检查是否有权限
            if (ContextCompat.checkSelfPermission(getBaseContext(), permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}