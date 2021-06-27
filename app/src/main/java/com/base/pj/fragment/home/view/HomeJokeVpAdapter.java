package com.base.pj.fragment.home.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.base.pj.R;

import java.util.ArrayList;
import java.util.List;

import lib.util.JLog;

/**
 *
 */
public class HomeJokeVpAdapter extends RecyclerView.Adapter<HomeJokeVpAdapter.JokeVpViewHolder> {

    private Context mContext;
    private List<String> list = new ArrayList<>();

    public HomeJokeVpAdapter(Context context,List<String> list) {
        mContext = context;
        this.list=list;
    }

    @NonNull
    @Override
    public JokeVpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        JLog.i("HomeJokeVpAdapter","viewType="+viewType);
        return new JokeVpViewHolder(LayoutInflater.from(mContext).inflate((R.layout.home_joke_vp_item), parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull JokeVpViewHolder holder, int position) {
        holder.tv_joke.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class JokeVpViewHolder extends RecyclerView.ViewHolder {
        TextView tv_joke;
        JokeVpViewHolder(@NonNull View v) {
            super(v);
            tv_joke =v.findViewById(R.id.tv_joke);
        }
    }
}
