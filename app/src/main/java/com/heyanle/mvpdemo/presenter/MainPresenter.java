package com.heyanle.mvpdemo.presenter;

import com.heyanle.mvpdemo.view.MainActivity;

/**
 * Created by HeYanLe on 2020/8/8 0008 19:37.
 * https://github.com/heyanLE
 */
public interface MainPresenter extends IPresenter<MainActivity> {

    void onAddOneClick();

    void onZeroClick();

    void onSignClick();

}
