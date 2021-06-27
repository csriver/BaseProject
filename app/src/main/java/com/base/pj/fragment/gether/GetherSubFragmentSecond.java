package com.base.pj.fragment.gether;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.base.pj.R;
import com.base.pj.base.BaseFragment;
import com.base.pj.databinding.FragmentHomeSubSecondBinding;
import com.base.pj.fragment.gether.contract.GetherContract;
import com.base.pj.fragment.gether.presenter.GetherPresenter;
import com.base.pj.fragment.home.contract.HomeContract;
import com.base.pj.fragment.home.presenter.HomePresenter;

import lib.util.JLog;

public class GetherSubFragmentSecond extends BaseFragment implements GetherContract.View {
    private FragmentHomeSubSecondBinding binding;
    private GetherPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_home_sub_second, container, false);
        JLog.i("HomeSubFragmentSecond","onCreateView");
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new GetherPresenter(this);
        JLog.i("HomeSubFragmentSecond","onViewCreated");
    }

    @Override
    public void onClick(View v) {
    }
}