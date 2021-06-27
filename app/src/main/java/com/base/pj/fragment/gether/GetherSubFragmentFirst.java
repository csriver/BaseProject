package com.base.pj.fragment.gether;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.datastore.core.DataStore;
import androidx.viewpager2.widget.ViewPager2;

import com.base.pj.Gps;
import com.base.pj.R;
import com.base.pj.base.BaseFragment;
import com.base.pj.databinding.FragmentHomeSubFirstBinding;
import com.base.pj.fragment.gether.contract.GetherContract;
import com.base.pj.fragment.gether.presenter.GetherPresenter;
import com.base.pj.fragment.home.contract.HomeContract;
import com.base.pj.fragment.home.presenter.HomePresenter;
import com.base.pj.fragment.home.view.HomePictureVpAdapter;
import com.google.protobuf.InvalidProtocolBufferException;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.OutputStream;
import java.util.prefs.Preferences;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import lib.util.FileUtil;
import lib.util.JLog;

public class GetherSubFragmentFirst extends BaseFragment implements GetherContract.View {
    private FragmentHomeSubFirstBinding binding;
    private GetherPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_home_sub_first, container, false);
        JLog.i("HomeSubFragmentFirst","onCreateView");
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new GetherPresenter(this);
        JLog.i("HomeSubFragmentFirst","onViewCreated");








    }

    @Override
    public void onClick(View v) {
    }
}