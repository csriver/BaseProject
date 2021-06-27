package com.base.pj.fragment.home.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import com.base.pj.R;
import com.base.pj.util.APPConfig;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

import java.util.ArrayList;
import java.util.List;

import lib.util.FileUtil;
import lib.util.JLog;
import test.RoomActivity;

/**
 *
 */
public class HomePictureVpAdapter extends RecyclerView.Adapter<HomePictureVpAdapter.PictureVpViewHolder> {

    private Context context;
    private List<String> pictures = new ArrayList<>();
    private int curPosition = 0;
    private PictureListener pictureListener;

    public HomePictureVpAdapter(Context context,List<String> pictures) {
        this.context = context;
        this.pictures=pictures;
    }

    public void setPictureListener(PictureListener pictureListener) {
        this.pictureListener = pictureListener;
    }

    @NonNull
    @Override
    public PictureVpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        JLog.i("HomePictureVpAdapter","viewType="+viewType);
        return new PictureVpViewHolder(LayoutInflater.from(context).inflate((R.layout.home_picture_vp_item), parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PictureVpViewHolder holder, int position) {
        curPosition = position;
        if(TextUtils.isEmpty(pictures.get(position))){
            Bitmap bitmap = FileUtil.getBitmapFromApp(APPConfig.PICTURE_FOLDER,"slide"+position);
            if(bitmap!=null){
                holder.iv_picture.setImageBitmap(bitmap);
            }else {
                if(position==0){
                    holder.iv_picture.setImageResource(R.drawable.slide_1);
                }else if(position==1){
                    holder.iv_picture.setImageResource(R.drawable.slide_2);
                }else if(position==2){
                    holder.iv_picture.setImageResource(R.drawable.slide_3);
                }
            }
        }else {
            //Glide.with(context).load(pictures.get(position)).into(holder.iv_picture);
            Glide.with(context).load(pictures.get(position)).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                    holder.iv_picture.setImageDrawable(resource);
                    BitmapDrawable bd = (BitmapDrawable) resource;
                    Bitmap bm = bd.getBitmap();
                    FileUtil.saveBitmapToApp(bm, APPConfig.PICTURE_FOLDER,"slide"+position);
                }
            });
        }
        JLog.i("HomePictureVpAdapter","onBindViewHolder="+position);
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    class PictureVpViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_picture;
        PictureVpViewHolder(@NonNull View v) {
            super(v);
            iv_picture=v.findViewById(R.id.iv_picture);
            iv_picture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(pictureListener!=null){
                        pictureListener.onClick(curPosition);
                    }
                }
            });
        }
    }

    public interface PictureListener{
        public void onClick(int position);
    }
}
