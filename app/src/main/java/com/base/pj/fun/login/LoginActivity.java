package com.base.pj.fun.login;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.base.pj.R;
import com.base.pj.base.BaseActivity;
import com.base.pj.databinding.ActivityLoginBinding;

/**
 * Created by jcs on 2021/5/31.
 * Describe
 */
public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
    }


    @Override
    public void onClick(View v) {

    }
}
