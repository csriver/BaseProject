package com.base.pj;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.base.pj.base.BaseActivity;
import com.base.pj.base.BaseFragment;
import com.base.pj.databinding.ActivityMainBinding;
import com.base.pj.fragment.customer.CustomerFragment;
import com.base.pj.fragment.gether.GetherFragment;
import com.base.pj.fragment.home.HomeFragment;
import com.base.pj.fragment.my.MyFragment;
import com.base.pj.fun.main.MainFragmentPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

import java.util.ArrayList;
import java.util.List;

import lib.util.StatusBarUtil;
import lib.util.ToastUtil;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding binding;
    private List<BaseFragment> fragments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        StatusBarUtil.setTransparent(MainActivity.this);
        initViewPage();
        binding.mainBottomBar.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);//设置Label一直显示
        binding.mainBottomBar.setItemIconTintList(null);//禁用投影原生选择效果，否则图片只剩投影
        binding.mainBottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case  R.id.main_nv_home : {
                        StatusBarUtil.setTransparent(MainActivity.this);
                        binding.mainVp.setCurrentItem(0);
                       return  true;
                    }
                    case R.id.main_nv_gether : {
                        StatusBarUtil.setColor(MainActivity.this,"#009AB6");
                        binding.mainVp.setCurrentItem(1);
                        return  true;
                    }
                    case R.id.mian_nv_customer : {
                        StatusBarUtil.setColor(MainActivity.this,"#009AB6");
                        binding.mainVp.setCurrentItem(2);
                        return  true;
                    }
                    case R.id.mian_nv_my : {
                        StatusBarUtil.setColor(MainActivity.this,"#009AB6");
                        binding.mainVp.setCurrentItem(3);
                        return  true;
                    }
                }
                return false;
            }
        });
    }

    /**
     * 初始化APP的ViewPage
     */
    private void initViewPage(){
        if(fragments.size()>0){
            return;
        }
        fragments.add(new HomeFragment());
        fragments.add(new GetherFragment());
        fragments.add(new CustomerFragment());
        fragments.add(new MyFragment());
        binding.mainVp.setCanScroll(false);
        MainFragmentPagerAdapter adapter = new MainFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        binding.mainVp.setAdapter(adapter);
        binding.mainVp.setOffscreenPageLimit(4);
    }

    @Override
    public void onClick(View v) {
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