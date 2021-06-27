package com.base.pj.fun.main;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.base.pj.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: FragmentPagerAdapter
 * @Date: 2021/6/17
 * @Author: CS
 * @Description:
 */
public class MainFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> fragmentList;

    public MainFragmentPagerAdapter(@NonNull FragmentManager fm, List<BaseFragment> list) {
        super(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        fragmentList = list;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
