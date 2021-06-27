package com.base.pj.fun.start;

import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.base.pj.MainActivity;
import com.base.pj.MyApplication;
import com.base.pj.R;
import com.base.pj.base.BaseActivity;
import com.base.pj.databinding.ActivityWelcomeBinding;
import com.base.pj.dialog.PrivacyDialog;
import com.base.pj.model.PrivacyInfo;
import com.base.pj.util.RoomUtil;
import com.google.gson.Gson;

import lib.room.PJCache;
import lib.util.JLog;
import test.RoomActivity;


/**
 * 启动页
 */
public class WelcomeActivity extends BaseActivity {
    private ActivityWelcomeBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);
        showPrivacy();
    }

    /**
     * 显示隐私协议
     */
    private void showPrivacy(){
        JLog.i("showPrivacy","showPrivacy");
        PJCache pjCache = RoomUtil.getPJCacheByKey(RoomUtil.key_privacy);
        if(pjCache == null || !new Gson().fromJson(pjCache.getPjValue(), PrivacyInfo.class).isAgreed()){
            PrivacyDialog privacyDialog = new PrivacyDialog(this, R.style.uncloseDialog, new PrivacyDialog.PrivacyListener() {
                @Override
                public void onAgree() {
                    JLog.i("showPrivacy","onAgree()");
                    PJCache PJCache = new PJCache(RoomUtil.key_privacy, new Gson().toJson(new PrivacyInfo(true)));
                    RoomUtil.insertOrUpdatePJCache(PJCache);
                    agreedPrivacy();
                }

                @Override
                public void onDisagree() {

                    JLog.i("showPrivacy","onDisagree()");
                    finish();
                    System.exit(0);
                }
            });
            JLog.i("showPrivacy","privacyDialog.show()");
            privacyDialog.show();
        }else {
            agreedPrivacy();
        }
    }

    /**
     * 隐私协议已同意
     */
    private void agreedPrivacy(){
        MyApplication.getInstance().initSDK();
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        finish();
    }


    @Override
    public void onClick(View v) {
    }
}