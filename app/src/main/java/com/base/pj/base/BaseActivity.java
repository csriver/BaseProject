package com.base.pj.base;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import java.util.Arrays;
import java.util.List;

import lib.util.JLog;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;


public class BaseActivity extends AppCompatActivity  implements View.OnClickListener,EasyPermissions.PermissionCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyActivityManager.addActivity(this);
    }

    @Override
    public void onClick(View v) {
    }

    /**
     * 申请动态权限
     * @param requestCode
     * @param perms
     */
    @SuppressLint("RestrictedApi")
    public void checkPermission(int requestCode, @NonNull String... perms){
        if (EasyPermissions.hasPermissions(this, perms)){
            onPermissionsGranted(requestCode, Arrays.asList(perms));
        }else{
            // rational的值为空时，直接调用权限申请，绕过EasyPermission的判断
            PermissionRequest request = new PermissionRequest.Builder(this, requestCode, perms).build();
            request.getHelper().directRequestPermissions(requestCode, perms);
            //EasyPermissions.requestPermissions(new PermissionRequest.Builder(this, requestCode, perms).build());
        }
    }

    //权限申请成功onPermissionsGranted
    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        JLog.e("onPermissionsGranted","requestCode="+requestCode+"/perms="+Arrays.toString(perms.toArray()));
    }
    //权限申请失败onPermissionsDenied
    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        JLog.e("onPermissionsDenied","requestCode="+requestCode+"/perms="+Arrays.toString(perms.toArray()));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        MyActivityManager.removeActivity(this);
        super.onDestroy();
    }

}