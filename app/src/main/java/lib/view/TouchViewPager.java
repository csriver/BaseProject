package lib.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * @ClassName: TouchViewPager
 * @Date: 2021/6/24
 * @Author: CS
 * @Description: 是否可滑动ViewPager
 */
public class TouchViewPager extends ViewPager {
    /*是否可滑动*/
    private boolean canScroll = true;

    public TouchViewPager(@NonNull Context context) {
        super(context);
    }

    public TouchViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCanScroll(boolean canScroll) {
        this.canScroll = canScroll;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(canScroll){
            return super.onInterceptTouchEvent(ev);
        }else {
            return false;
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(canScroll){
            return super.onTouchEvent(ev);
        }else {
            return false;
        }
    }
}
