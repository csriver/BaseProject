package com.base.pj.fragment.home.contract;

import android.widget.TextView;

import com.base.pj.base.BasePresenter;
import com.base.pj.base.BaseView;
import com.base.pj.model.PictureData;

/**
 * Created by jcs on 2021/5/31.
 * Describe
 */
public interface HomeContract{

    interface View extends BaseView {
        public void setJoke(String joke);

        public void setPicture(PictureData data);
    }

    interface Presenter extends BasePresenter {
        public void getJoke();
    }

}
