package com.base.pj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.base.pj.bean.DataBean;
import com.base.pj.databinding.ActivityEventBinding;
import com.base.pj.event.StickyEvent;
import com.base.pj.event.TestEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import lib.bus.LiveDataBus;

public class EventActivity extends AppCompatActivity {
    ActivityEventBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_event);

        //注册EventBus
        EventBus.getDefault().register(this);


        binding.buttonLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBean dataBean = new DataBean();
                dataBean.setName("LiveData");
                dataBean.setState("LiveState");
                LiveDataBus.getDefault().withCreation("dataBean", DataBean.class).postValue(dataBean);
                LiveDataBus.getDefault().withCreation("dataBean", DataBean.class).postValue(dataBean);
                LiveDataBus.getDefault().withCreation("dataBean", DataBean.class).postValue(dataBean);
            }
        });
        binding.buttonEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送EventBus
                TestEvent event = new TestEvent();
                event.name = "TestEvent";
                event.value = "TestValue";
                EventBus.getDefault().post(event);
            }
        });

        //LiveDataBus订阅粘性事件
        LiveDataBus.getDefault().with("dataSticky", DataBean.class).observe(this, new Observer<DataBean>() {
            @Override
            public void onChanged(DataBean dataBean) {
                Log.i("LiveDataBus","with/onChanged="+dataBean.getName());
                //订阅结果回调
                binding.tvLiveSticky.append(dataBean.getName()+"   ");
            }
        });

    }

    /**
     * 接收EventBus sticky回调信息
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onStickyEvent(StickyEvent event){
        binding.tvEventSticky.setText(event.value);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销EventBus
        EventBus.getDefault().unregister(this);
    }
}