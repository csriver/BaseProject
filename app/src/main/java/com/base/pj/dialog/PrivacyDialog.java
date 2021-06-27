package com.base.pj.dialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;

import com.base.pj.R;
import com.base.pj.databinding.DialogPrivacyBinding;

import lib.util.ToastUtil;

/**
 * @ClassName: PrivacyDialog
 * @Date: 2021/6/17
 * @Author: CS
 * @Description: 隐私协议
 */
public class PrivacyDialog extends BaseDialog {

    private Context context;
    private DialogPrivacyBinding binding;
    private PrivacyListener listener;
    private String message = "尊敬的用户：\n" +
            "      您好！您在使用APP时，平台需要收集使用部分个人信息，否则将无法为您服务。我们非常重视个人信息安全，采用符合业界标准的安全防护措施确保未收集无关的个人信息。\n" +
            "      为更好地保护您的合法权益，根据《中华人民共和国网络安全法》规定，须通过《互联网平台隐私条例》向您明确信息收集、使用规则，并经您确认同意。";

    public PrivacyDialog(Context context,int style,PrivacyListener listener) {
        super(context, style);
        this.context=context;
        this.listener=listener;
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        binding=DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_privacy, null, false);
        setContentView(binding.getRoot());
        binding.btnAgree.setOnClickListener(this);
        binding.btnDisagree.setOnClickListener(this);
        binding.privacyCotent.setHighlightColor(context.getResources().getColor(R.color.white));
        SpannableString spanStrStart = new SpannableString(message);
        SpannableString spanStrClick = new SpannableString("查看详细协议");
        spanStrClick.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                //隐私协议详情页
                ToastUtil.toastShort(context,"暂未开放");
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(context.getResources().getColor(R.color.blue_dark)); //设置颜色
                //去掉下划线，默认是带下划线的
                ds.setUnderlineText(false);
                //设置字体背景
                ds.bgColor = Color.parseColor("#FFFFFF");
            }
        }, 0, spanStrClick.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.privacyCotent.append(spanStrStart);
        binding.privacyCotent.append(spanStrClick);
        binding.privacyCotent.setMovementMethod(LinkMovementMethod.getInstance());

    }


    @Override
    public void onClick(View v) {
        if(v == binding.btnAgree){
            cancel();
            if(listener!=null){
                listener.onAgree();
            }
        }else if(v == binding.btnDisagree){
            cancel();
            if(listener!=null){
                listener.onDisagree();
            }
        }
    }

    @Override
    public void onBackPressed() { }

    public interface PrivacyListener{
        /**
         * 同意隐私协议
         */
        public void onAgree();
        /**
         * 不同意隐私协议
         */
        public void onDisagree();
    }
}
