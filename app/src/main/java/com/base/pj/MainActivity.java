package com.base.pj;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import com.base.pj.bean.DataBean;
import com.base.pj.databinding.ActivityMainBinding;
import com.base.pj.event.StickyEvent;
import com.base.pj.event.TestEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lib.bus.LiveDataBus;
import lib.net.API;
import lib.net.RetrofitHelp;
import lib.util.JLog;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private DataBean dataBean;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JLog.isDebug=true;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataBean=new DataBean();
        binding.setDataBean(dataBean);
        binding.setLifecycleOwner(this);
        binding.hello.setTextColor(getResources().getColor(R.color.teal_200));
        dataBean.setName("hello wold");
        dataBean.setState(String.valueOf(i));
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i<1000) {
                    try {
                        i++;
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //Log.d("MainActivity","Thread/run()="+i+" / "+dataBean.getName());
                            dataBean.setState(String.valueOf(i));
                            dataBean.setName(String.valueOf(System.currentTimeMillis()));
                        }
                    });
                }
            }
        }).start();
        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBean dataBean = new DataBean();
                dataBean.setName("粘性事件");
                dataBean.setState("粘性事件");
                LiveDataBus.getDefault().with("dataSticky", DataBean.class).postValue(dataBean);

                Intent intent = new Intent(MainActivity.this,EventActivity.class);
                startActivity(intent);
            }
        });

        binding.buttonSticky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送EventBus
//                StickyEvent event = new StickyEvent();
//                event.name = "StickyEvent";
//                event.value = "StickyValue";
//                EventBus.getDefault().postSticky(event);

                //http://t.weather.itboy.net/api/weather/city/101030100
                //http://gank.io/api/data/Android/10/1
                //https://api.apiopen.top/getJoke?page=1&count=2&type=video
                RetrofitHelp.isDebug = false;
                Observable<Object> observable=  RetrofitHelp.get()
                        .request("https://api.apiopen.top/", API.class)
                        .getJoke("1","2","video");
                observable .map(new Function<Object, Object>() {
                        @Override
                        public Object apply(Object o) throws Throwable {
                            //JLog.i("RetrofitHelp","apply:" + o.toString());
                            return o;
                        }
                 })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new io.reactivex.rxjava3.core.Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        JLog.d("RetrofitHelp","onSubscribe:" + d.toString());
                    }

                    @Override
                    public void onNext(@NonNull Object objects) {
                        JLog.d("RetrofitHelp","onNext:" + objects.toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        JLog.d("RetrofitHelp","onSubscribe:" + e.getMessage());
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        JLog.d("RetrofitHelp","onComplete:" );
                    }
                });


            }
        });
        //发布事件LiveDataBus
        //LiveDataBus.getDefault().with("dataBean", DataBean.class).postValue(dataBean);
        //订阅事件LiveDataBus
        LiveDataBus.getDefault().withCreation("dataBean", DataBean.class).observe(this, new Observer<DataBean>() {
            @Override
            public void onChanged(DataBean homeBean) {
                Log.i("LiveDataBus","withCreation/onChanged="+homeBean.getName());
                //订阅结果回调
                binding.tvLive.setText(homeBean.getName());
            }
        });

        //注册EventBus
        EventBus.getDefault().register(this);
        //发送EventBus
        //TestEvent event = new TestEvent();
        //EventBus.getDefault().post(event);



        Observable.just(this)
                .map(new Function<Activity, ArrayList<DataBean>>() {
                    @Override
                    public ArrayList<DataBean> apply(Activity activity) throws Exception {
                        ArrayList<DataBean> list =new ArrayList<>();
                        return list;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ArrayList<DataBean>>() {
                    @Override
                    public void accept(ArrayList<DataBean> configItems) throws Exception {

                    }
                });
    }

    /**
     * 接收EventBus回调信息
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTestEvent(TestEvent event){
        binding.tvEvent.setText(event.name);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销EventBus
        EventBus.getDefault().unregister(this);
    }
}