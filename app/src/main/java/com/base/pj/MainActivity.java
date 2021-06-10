package com.base.pj;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.os.Bundle;
import android.view.View;

import com.base.pj.base.BaseActivity;
import com.base.pj.databinding.ActivityMainBinding;

import java.util.List;

import lib.util.JLog;
import lib.util.ToastUtil;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.buttonSticky.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v==binding.buttonSticky){
            checkPermission(100,Manifest.permission.CAMERA,Manifest.permission.RECORD_AUDIO,Manifest.permission.ACCESS_FINE_LOCATION);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms)  {
        super.onPermissionsGranted(requestCode,perms);
        ToastUtil.toastLong(this,"Granted="+requestCode);

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        super.onPermissionsDenied(requestCode,perms);
        ToastUtil.toastLong(this,"Denied="+requestCode);
    }
}