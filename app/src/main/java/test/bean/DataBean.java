package test.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


/**
 * Created by jcs on 2021/5/25.
 * Describe
 */
public class DataBean extends BaseObservable {
    //BaseObservable双向绑定
    private String name;
    private String state;
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
//        notifyPropertyChanged(BR.name);//通知某个变量发生了变化
        notifyChange();//通知全部变量发生了变化,刷新UI
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyChange();//通知全部变量发生了变化,刷新UI
    }
}
