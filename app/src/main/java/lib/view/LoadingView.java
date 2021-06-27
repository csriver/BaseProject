package lib.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.base.pj.R;
import com.bumptech.glide.Glide;

/**
 * @ClassName: LoadingView
 * @Date: 2021/6/16
 * @Author: CS
 * @Description: 自定义加载框控件
 */
public class LoadingView extends AppCompatImageView {
    public LoadingView(@NonNull Context context) {
        super(context);
        Glide.with(context).load(R.drawable.loading).into(this);
    }

    public LoadingView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Glide.with(context).load(R.drawable.loading).into(this);
    }

    public LoadingView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Glide.with(context).load(R.drawable.loading).into(this);
    }
}
