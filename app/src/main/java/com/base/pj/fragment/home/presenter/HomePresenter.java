package com.base.pj.fragment.home.presenter;

import com.base.pj.fragment.home.contract.HomeContract;

/**
 * Created by jcs on 2021/5/31.
 * Describe
 */
public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;

    public HomePresenter(HomeContract.View view){
        this.view=view;
    }



}
