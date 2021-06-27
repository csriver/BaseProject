package com.base.pj.fragment.home.presenter;

import com.base.pj.fragment.home.contract.HomeContract;
import com.base.pj.model.JokeData;
import com.base.pj.model.PictureData;
import com.base.pj.net.BaseUrl;
import com.bumptech.glide.Glide;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lib.net.NetAPI;
import lib.net.RetrofitHelp;
import lib.util.JLog;
import test.RoomActivity;

/**
 * Created by jcs on 2021/5/31.
 * Describe
 */
public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;

    public HomePresenter(HomeContract.View view){
        this.view=view;
    }


    @Override
    public void getJoke() {
        Observable<JokeData> observable = RetrofitHelp.getInstance()
                .request(BaseUrl.url, NetAPI.class)
                .getJoke("utf-8", "json");
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new io.reactivex.rxjava3.core.Observer<JokeData>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        JLog.d("RetrofitHelp", "onSubscribe:" + d.toString());
                    }

                    @Override
                    public void onNext(@NonNull JokeData data) {
                        JLog.d("RetrofitHelp", "onNext:" + data.toString());
                        view.setJoke(data.getText());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        JLog.d("RetrofitHelp", "onSubscribe:" + e.getMessage());
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        JLog.d("RetrofitHelp", "onComplete:");
                    }
                });
    }


    public void getPicture(){
        Observable<PictureData> observable = RetrofitHelp.getInstance()
                .request(BaseUrl.url, NetAPI.class)
                .getPicture("fengjing", "json");
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new io.reactivex.rxjava3.core.Observer<PictureData>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        JLog.d("RetrofitHelp", "onSubscribe:" + d.toString());
                    }

                    @Override
                    public void onNext(@NonNull PictureData data) {
                        JLog.d("RetrofitHelp", "onNext:" + data.toString());
                        view.setPicture(data);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        JLog.d("RetrofitHelp", "onSubscribe:" + e.getMessage());
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        JLog.d("RetrofitHelp", "onComplete:");
                    }
                });
    }

}
