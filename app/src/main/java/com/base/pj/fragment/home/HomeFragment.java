package com.base.pj.fragment.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.base.pj.R;
import com.base.pj.base.BaseFragment;
import com.base.pj.databinding.FragmentHomeBinding;
import com.base.pj.fragment.home.contract.HomeContract;
import com.base.pj.fragment.home.presenter.HomePresenter;
import com.base.pj.fragment.home.view.HomeJokeVpAdapter;
import com.base.pj.fragment.home.view.HomePictureVpAdapter;
import com.base.pj.model.PictureData;

import java.util.ArrayList;
import java.util.List;

import lib.util.JLog;
import lib.util.ScreenUtil;

/**
 * @ClassName: MyFragment
 * @Date: 2021/6/17
 * @Author: CS
 * @Description: 首页
 */
public class HomeFragment extends BaseFragment implements HomeContract.View {
    private FragmentHomeBinding binding;
    private HomePresenter presenter;
    //轮播图Adapter
    private HomePictureVpAdapter pictureVpAdapter;
    private List<String> pictureList = new ArrayList<>();

    //毒鸡汤adapter
    private HomeJokeVpAdapter jokeVpAdapter;
    private List<String> jokeList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false);
        presenter = new HomePresenter(this);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initTitle();
        initPictureViewPage();
        initJokeViewPage();
    }

    private void initTitle(){
        binding.homeTitleLayout.titleLSearch.setVisibility(View.VISIBLE);
        binding.homeTitleLayout.titleContent.setText("我的");
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onClick(View v) {
    }

    /**
     * 初始化轮播图
     */
    private void initPictureViewPage(){
        for (int i = 0; i < 3; i++) {
            pictureList.add("");
        }
        pictureVpAdapter = new HomePictureVpAdapter(getContext(),pictureList);
        binding.homeIvp.setAdapter(pictureVpAdapter);
        binding.homeIvp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < pictureVpAdapter.getItemCount(); i++) {
                    if(binding.homeIvpIndicate.getChildAt(i)!=null){
                        if(binding.homeIvpIndicate.getChildAt(i) instanceof ImageView){
                            ((ImageView) binding.homeIvpIndicate.getChildAt(i)).setImageResource(R.drawable.indicate_normal);
                        }
                    }
                }
                if(binding.homeIvpIndicate.getChildAt(position)!=null){
                    if(binding.homeIvpIndicate.getChildAt(position) instanceof ImageView){
                        ((ImageView) binding.homeIvpIndicate.getChildAt(position)).setImageResource(R.drawable.indicate_select);
                    }
                }
            }
        });
        pictureVpAdapter.setPictureListener(new HomePictureVpAdapter.PictureListener() {
            @Override
            public void onClick(int position) {
                presenter.getPicture();
            }
        });
        for (int i = 0; i < pictureVpAdapter.getItemCount(); i++) {
            ImageView imageView =new ImageView(getContext());
            if(i==0){
                imageView.setImageResource(R.drawable.indicate_select);
            }else {
                imageView.setImageResource(R.drawable.indicate_normal);
            }
            int p = ScreenUtil.dp2px(getContext(),5f);
            imageView.setPadding(p,p,p,p);
            binding.homeIvpIndicate.addView(imageView);
        }
    }

    private void initJokeViewPage(){
        for (int i = 0; i < 3; i++) {
            jokeList.add("");
        }
        jokeVpAdapter=new HomeJokeVpAdapter(getContext(),jokeList);
        binding.homeJokeVp.setAdapter(jokeVpAdapter);
        binding.homeJokeVp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if(TextUtils.isEmpty(jokeList.get(position))){
                    presenter.getJoke();
                }
            }
        });
    }

    @Override
    public void setJoke(String joke) {
        JLog.d("setJoke",joke);
        jokeList.set(binding.homeJokeVp.getCurrentItem(),joke);
        jokeVpAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPicture(PictureData data) {
        pictureList.set(binding.homeIvp.getCurrentItem(),data.imgurl);
        pictureVpAdapter.notifyDataSetChanged();
    }
}