package com.base.pj.fragment.life.presenter;


import com.base.pj.fragment.life.contract.LifeContract;

/**
 * Created by jcs on 2021/5/31.
 * Describe
 */
public class LifePresenter implements LifeContract.Presenter {
    private LifeContract.View view;

    public LifePresenter(LifeContract.View view){
        this.view=view;
    }



}
