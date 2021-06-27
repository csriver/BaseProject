package com.base.pj.fragment.gether;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
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
public class GetherFragmentPagerAdapter extends FragmentStateAdapter {

    private FragmentActivity fragmentActivity;
    private List<BaseFragment> fragments = new ArrayList<>();

    public GetherFragmentPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<BaseFragment> fragments) {
        super(fragmentActivity);
        this.fragmentActivity=fragmentActivity;
        this.fragments = fragments;

    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
