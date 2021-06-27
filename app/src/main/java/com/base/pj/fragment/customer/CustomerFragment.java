package com.base.pj.fragment.customer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.base.pj.R;
import com.base.pj.base.BaseFragment;
import com.base.pj.databinding.FragmentCustomerBinding;
import com.base.pj.fragment.customer.contract.CustomerContract;
import com.base.pj.fragment.customer.presenter.CustomerPresenter;
import com.base.pj.fragment.home.contract.HomeContract;
import com.base.pj.fragment.home.presenter.HomePresenter;
/**
 * @ClassName: MyFragment
 * @Date: 2021/6/17
 * @Author: CS
 * @Description: 自选功能
 */
public class CustomerFragment extends BaseFragment implements CustomerContract.View {
    private FragmentCustomerBinding binding;
    private CustomerPresenter presenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_customer, container, false);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new CustomerPresenter(this);
    }

    @Override
    public void onClick(View v) {
    }
}