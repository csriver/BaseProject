package com.base.pj.fragment.media.presenter;

import com.base.pj.fragment.media.contract.MediaContract;

/**
 * Created by jcs on 2021/5/31.
 * Describe
 */
public class MediaPresenter implements MediaContract.Presenter {
    private MediaContract.View view;

    public MediaPresenter(MediaContract.View view){
        this.view=view;
    }



}
