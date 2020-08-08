package com.heyanle.mvpdemo.model.impl;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.heyanle.mvpdemo.DemoApplication;
import com.heyanle.mvpdemo.model.StringListModel;

import java.util.List;

/**
 * Created by HeYanLe on 2020/8/8 0008 19:19.
 * https://github.com/heyanLE
 */
public class StringListModelImpl implements StringListModel {

    static final String FILE_NAME = "file_name";
    static final String KEY_LIST = "key_list";

    @Override
    public List<String> load() {
        String s = DemoApplication.getInstance().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
                .getString(KEY_LIST,"[]");
        return new Gson().fromJson(s,
                new TypeToken<List<String>>() {}.getType());
    }

    @Override
    public void save(List<String> data) {
        String s = new Gson().toJson(data);
        SharedPreferences.Editor editor = DemoApplication.getInstance()
                .getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(KEY_LIST, s);
        editor.apply();
    }
}
