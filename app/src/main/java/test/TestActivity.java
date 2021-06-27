package test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.base.pj.Gps;
import com.base.pj.R;

import lib.net.NetAPI;
import lib.util.FileUtil;
import test.bean.DataBean;

import com.base.pj.databinding.ActivityTestBinding;
import com.google.protobuf.InvalidProtocolBufferException;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lib.bus.LiveDataBus;
import lib.net.RetrofitHelp;
import lib.util.JLog;
import test.event.TestEvent;

public class TestActivity extends AppCompatActivity {
    ActivityTestBinding binding;
    private DataBean dataBean;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test);
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

                Intent intent = new Intent(TestActivity.this, EventActivity.class);
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

    private void protobuf(){
        Gps.gps_data.Builder build =  Gps.gps_data.newBuilder();
        build.setId(1);
        build.setDataTime("20191018105706");
        Gps.gps_data info = build.build();
        byte[] bt = info.toByteArray();
        System.out.println(bt);
        try {
            info =  Gps.gps_data.parseFrom(FileUtil.getByteFromApp("p"));
            FileUtil.saveByteToApp("p",bt,false);
            System.out.println(info);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
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