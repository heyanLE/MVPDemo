package com.heyanle.mvpdemo.model;

import java.util.List;

/**
 * Created by HeYanLe on 2020/8/8 0008 19:17.
 * https://github.com/heyanLE
 */
public interface StringListModel {

    List<String> load();

    void save(List<String> data);
}
