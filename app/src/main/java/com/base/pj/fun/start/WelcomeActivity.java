package com.base.pj.fun.start;

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.base.pj.R;
import com.base.pj.base.BaseActivity;
import com.base.pj.databinding.ActivityWelcomeBinding;


public class WelcomeActivity extends BaseActivity {
    private ActivityWelcomeBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);


    }


    @Override
    public void onClick(View v) {
    }
}