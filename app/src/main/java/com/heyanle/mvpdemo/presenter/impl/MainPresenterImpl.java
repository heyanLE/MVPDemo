package com.heyanle.mvpdemo.presenter.impl;

import com.heyanle.mvpdemo.model.Model;
import com.heyanle.mvpdemo.presenter.MainPresenter;
import com.heyanle.mvpdemo.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HeYanLe on 2020/8/8 0008 19:39.
 * https://github.com/heyanLE
 */
public class MainPresenterImpl implements MainPresenter {

    private MainActivity view;
    private int num;
    private List<String> list;

    @Override
    public void onAddOneClick() {
        num ++;
        view.setNumText(num+"");
        Model.STRING_LIST.save(list);
    }

    @Override
    public void onZeroClick() {
        num = 0;
        view.setNumText(num+"");
        Model.STRING_LIST.save(list);
    }

    @Override
    public void onSignClick() {
        list.add(num+"");
        Model.STRING_LIST.save(list);
        view.setNumList(list);
    }

    @Override
    public void onBind(MainActivity view) {
        this.view = view;
        view.setNumText(num+"");
        view.setNumList(list);
    }

    @Override
    public void onUnbind() {

    }

    @Override
    public void onInit() {
        num = 0;
        list = Model.STRING_LIST.load();
        if (list == null){
            list = new ArrayList<>();
        }

    }
}
