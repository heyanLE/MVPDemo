package com.heyanle.mvpdemo.contract;

import com.heyanle.mvpdemo.presenter.MainPresenter;
import com.heyanle.mvpdemo.presenter.impl.MainPresenterImpl;
import com.heyanle.mvpdemo.view.MainActivity;

/**
 * Created by HeYanLe on 2020/8/8 0008 19:37.
 * https://github.com/heyanLE
 */
public class MainContract extends Contract<MainActivity, MainPresenter> {

    @Override
    MainPresenter newPresenter() {
        return new MainPresenterImpl();
    }

    private static MainContract INSTANCE = new MainContract();
    public static MainContract getInstance(){
        return INSTANCE;
    }
    private MainContract(){}
}
