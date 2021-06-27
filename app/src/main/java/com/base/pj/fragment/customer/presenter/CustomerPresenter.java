package com.base.pj.fragment.customer.presenter;

import com.base.pj.fragment.customer.contract.CustomerContract;

/**
 * Created by jcs on 2021/5/31.
 * Describe
 */
public class CustomerPresenter implements CustomerContract.Presenter {
    private CustomerContract.View view;

    public CustomerPresenter(CustomerContract.View view){
        this.view=view;
    }



}
