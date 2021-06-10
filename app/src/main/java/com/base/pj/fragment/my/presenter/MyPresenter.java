package com.base.pj.fragment.my.presenter;

import com.base.pj.fragment.my.contract.MyContract;

/**
 * Created by jcs on 2021/5/31.
 * Describe
 */
public class MyPresenter implements MyContract.Presenter {
    private MyContract.View view;

    public MyPresenter(MyContract.View view){
        this.view=view;
    }



}
