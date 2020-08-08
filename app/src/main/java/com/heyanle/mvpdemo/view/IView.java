package com.heyanle.mvpdemo.view;

import android.content.Context;
import android.view.View;

/**
 * Created by HeYanLe on 2020/8/8 0008 19:23.
 * https://github.com/heyanLE
 */
public interface IView {

    Context getContext();

    <T extends View> T findViewById(int id);

}