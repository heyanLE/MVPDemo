package com.heyanle.mvpdemo;

import android.app.Application;

/**
 * Created by HeYanLe on 2020/8/8 0008 19:12.
 * https://github.com/heyanLE
 */
public class DemoApplication extends Application {

    private static DemoApplication INSTANCE;
    public static DemoApplication getInstance(){
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}
