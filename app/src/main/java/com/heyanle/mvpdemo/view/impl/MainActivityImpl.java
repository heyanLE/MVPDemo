package com.heyanle.mvpdemo.view.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.heyanle.mvpdemo.adapter.ListAdapter;
import com.heyanle.mvpdemo.contract.MainContract;
import com.heyanle.mvpdemo.databinding.ActivityMainBinding;
import com.heyanle.mvpdemo.presenter.MainPresenter;
import com.heyanle.mvpdemo.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HeYanLe on 2020/8/8 0008 19:34.
 * https://github.com/heyanLE
 */
public class MainActivityImpl extends AppCompatActivity implements MainActivity {

    private MainPresenter mPresenter;
    private ActivityMainBinding mBinding;
    private ListAdapter listAdapter;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(mBinding.getRoot());


    }

    @Override
    protected void onStart() {
        super.onStart();
        initView();
        mPresenter = MainContract.getInstance().bind(this);
    }

    private void initView(){
        listAdapter = new ListAdapter(list);
        mBinding.recycler.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recycler.setAdapter(listAdapter);

        mBinding.sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onSignClick();
            }
        });
        mBinding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onAddOneClick();
            }
        });
        mBinding.zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onZeroClick();
            }
        });
        mBinding.restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityImpl.this, MainActivityImpl.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        MainContract.getInstance().unbind(this);
    }

    @Override
    public void setNumText(String s) {
        mBinding.num.setText(s);
    }

    @Override
    public void setNumList(List<String> list) {
        this.list.clear();
        this.list.addAll(list);
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
