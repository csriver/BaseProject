package com.base.pj.fragment.gether;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager2.widget.ViewPager2;

import com.base.pj.R;
import com.base.pj.base.BaseFragment;
import com.base.pj.databinding.FragmentGetherBinding;
import com.base.pj.fragment.gether.contract.GetherContract;
import com.base.pj.fragment.gether.presenter.GetherPresenter;
import com.base.pj.fragment.home.contract.HomeContract;
import com.base.pj.fragment.home.presenter.HomePresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import lib.util.JLog;

/**
 * @ClassName: GetherFragment
 * @Date: 2021/6/17
 * @Author: CS
 * @Description: 组件功能集合
 */
public class GetherFragment extends BaseFragment implements GetherContract.View {
    private FragmentGetherBinding binding;
    private GetherPresenter presenter;

    //顶部Tab栏
    private String[] tableTitles = new String[]{"推荐","热门","图片","新闻"};
    private List<BaseFragment> fragments = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_gether, container, false);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new GetherPresenter(this);
        initTableLayout();
        initViewPage();
    }

    @Override
    public void onClick(View v) {
    }

    /**
     * 初始化首页Tab栏
     */
    private void initTableLayout(){
        JLog.e("HomeFragment","initTableLayout");
        for(int i=0;i<tableTitles.length;i++){
            binding.getherTl.addTab(binding.getherTl.newTab());
            binding.getherTl.getTabAt(i).setText(tableTitles[i]);
        }
        binding.getherTl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.getherVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }

    /**
     * 初始化首页ViewPage
     */
    private void initViewPage(){
        if(fragments.size()>0){
            return;
        }
        fragments.add(new GetherSubFragmentFirst());
        fragments.add(new GetherSubFragmentSecond());
        fragments.add(new GetherSubFragmentThird());
        fragments.add(new GetherSubFragmentFourth());
        GetherFragmentPagerAdapter adapter = new GetherFragmentPagerAdapter(getActivity(),fragments);
        binding.getherVp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.getherTl.selectTab(binding.getherTl.getTabAt(position));
            }
        });
        binding.getherVp.setUserInputEnabled(true); //true:滑动，false：禁止滑动
        binding.getherVp.setAdapter(adapter);
    }

}