package com.base.pj.fragment.my;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.base.pj.R;
import com.base.pj.base.BaseFragment;
import com.base.pj.databinding.FragmentHomeBinding;
import com.base.pj.databinding.FragmentMyBinding;
import com.base.pj.fragment.home.contract.HomeContract;
import com.base.pj.fragment.home.presenter.HomePresenter;
import com.base.pj.fragment.my.contract.MyContract;
import com.base.pj.fragment.my.presenter.MyPresenter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.security.MessageDigest;

import lib.util.JLog;
/**
 * @ClassName: MyFragment
 * @Date: 2021/6/17
 * @Author: CS
 * @Description: 我的
 */
public class MyFragment extends BaseFragment implements MyContract.View {
    private FragmentMyBinding binding;
    private MyPresenter presenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_my, container, false);
        JLog.i("MyFragment","onCreateView");
        presenter = new MyPresenter(this);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        JLog.i("MyFragment","onViewCreated");
        init();
    }

    @Override
    public void onClick(View v) {
    }

    private void init(){
        binding.layoutTitle.titleLContent.setVisibility(View.VISIBLE);
        binding.layoutTitle.titleSetting.setVisibility(View.VISIBLE);
        binding.layoutTitle.titleContent.setText("我的");
        Glide.with(getActivity()).load(R.drawable.slide_3).into(binding.userPhoto);
    }


}