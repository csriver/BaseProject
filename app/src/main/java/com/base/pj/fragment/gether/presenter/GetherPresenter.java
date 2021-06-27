package com.base.pj.fragment.gether.presenter;


import com.base.pj.fragment.gether.contract.GetherContract;

/**
 * Created by jcs on 2021/5/31.
 * Describe
 */
public class GetherPresenter implements GetherContract.Presenter {
    private GetherContract.View view;

    public GetherPresenter(GetherContract.View view){
        this.view=view;
    }



}
