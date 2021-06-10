package com.base.pj.base;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by jcs on 2021/5/30.
 * Describe
 */
public class MyActivityManager {
    /**
     * 保存所有Activity
     */
    private static volatile Stack<Activity> activityStack = new Stack<Activity>();


    /**
     * 保存的Activity是否为空
     */
    public static boolean isStackEmpty(){
        return activityStack==null || activityStack.size()<=0;
    }

    /**
     * 将当前Activity推入栈中
     * @param activity Activity
     */
    public static void addActivity(Activity activity) {
        if (activity == null){
            return;
        }
        if(!activityStack.contains(activity)){
            activityStack.add(activity);
        }
    }

    /**
     * 删除Activity
     * @param activity Activity
     */
    public static boolean removeActivity(Activity activity) {
        if(activity == null){
            return false;
        }
        if(activityStack.contains(activity)){
            activityStack.remove(activity);
            return true;
        }else{
            return false;
        }
    }

    /**
     * 清空Activity
     */
    public static void clearActivity() {
        for (int i = 0; i < activityStack.size(); i++) {
            if(activityStack.get(i)!=null){
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 获得当前栈顶的Activity
     *
     * @return Activity Activity
     */
    public static Activity getCurrentActivity()
    {
        Activity activity = null;
        if (!activityStack.empty())
        {
            activity = activityStack.lastElement();
        }
        return activity;
    }

}
