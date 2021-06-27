package lib.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;

import com.base.pj.R;
import com.bumptech.glide.Glide;

/**
 * @ClassName: LoadingDialog
 * @Date: 2021/6/16
 * @Author: CS
 * @Description: 加载框
 */
public class LoadingDialog extends AlertDialog {
    private Context context;
    public LoadingDialog(Context context,int style) {
        super(context, style);
        this.context=context;
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.dialog_loading);
        ImageView loading = findViewById(R.id.iv_loading);
        Glide.with(context).load(R.drawable.loading).into(loading);
    }

}
