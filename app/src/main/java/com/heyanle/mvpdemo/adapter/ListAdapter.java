package com.heyanle.mvpdemo.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.heyanle.mvpdemo.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by HeYanLe on 2020/8/8 0008 19:50.
 * https://github.com/heyanLE
 */
public class ListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public ListAdapter( @Nullable List<String> data) {
        super(R.layout.item_main_list, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.tv, s);
    }
}
