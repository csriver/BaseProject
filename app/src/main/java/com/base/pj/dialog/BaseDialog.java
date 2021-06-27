package com.base.pj.dialog;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

/**
 * @ClassName: BaseDialog
 * @Date: 2021/6/17
 * @Author: CS
 * @Description:
 */
public class BaseDialog  extends AlertDialog implements View.OnClickListener {
    protected BaseDialog(@NonNull Context context) {
        super(context);
    }

    protected BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected BaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public void onClick(View v) {

    }
}
