package test;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import com.base.pj.R;
import com.base.pj.base.BaseActivity;
import com.base.pj.databinding.ActivityRoomBinding;
import com.base.pj.model.JokeData;
import com.base.pj.model.PictureData;
import com.base.pj.net.BaseUrl;
import com.base.pj.util.RoomUtil;
import com.bumptech.glide.Glide;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lib.net.NetAPI;
import lib.net.RetrofitHelp;
import lib.room.PJCache;
import lib.util.JLog;


/**
 * room 数据库测试
 */
public class RoomActivity extends BaseActivity {
    private ActivityRoomBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room);

        String androidId = Settings.System.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        binding.textView.setText(androidId);

//        LoadingDialog dialog = new LoadingDialog(this,R.style.closeDialog);
//        dialog.show();

        update();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJoke();
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PJCache PJCache = new PJCache(RoomUtil.key_phone, "132000002");
                RoomUtil.insertOrUpdatePJCache(PJCache);
            }
        });

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PJCache PJCache = new PJCache(RoomUtil.key_phone, "1320033333");
                RoomUtil.insertOrUpdatePJCache(PJCache);
            }
        });

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoomUtil.deletePJCacheByKeys(RoomUtil.key_phone);
            }
        });
    }

    private void update() {
        JLog.d("update", "update()");
        RoomUtil.getAllPJCacheLive().observe(this, new Observer<List<PJCache>>() {
            @Override
            public void onChanged(List<PJCache> PJCaches) {
                JLog.d("onChanged", "persons=" + PJCaches.size());
                StringBuilder text = new StringBuilder();
                binding.textView.setText("");
                for (PJCache PJCache : PJCaches) {
                    binding.textView.append(String.valueOf(PJCache.getPjTime()));
                    binding.textView.append("、");
                    binding.textView.append(PJCache.getPjKey());
                    binding.textView.append(":");
                    binding.textView.append(PJCache.getPjValue());
                    binding.textView.append("\n");
                }
            }
        });
    }

    private void getJoke(){
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
                        binding.textView.setText(data.getText());
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


    private void getPicture(){
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
                        Glide.with(RoomActivity.this).load(data.imgurl).into(binding.imageView2);
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

    @Override
    public void onClick(View v) {
    }
}