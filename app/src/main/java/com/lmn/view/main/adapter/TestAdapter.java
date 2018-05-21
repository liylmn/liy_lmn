package com.lmn.view.main.adapter;

import android.content.Context;

import com.lmn.R;
import com.lmn.databinding.ItemBinding;

import lmn.com.lmnlibrary.base.BaseBindingAdapter;

/**
 * 作者：liy_lmn
 * 时间：2018/5/18:15:56
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class TestAdapter<Beauty> extends BaseBindingAdapter<com.lmn.model.entity.Beauty,ItemBinding> {


    public TestAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.item;
    }

    @Override
    protected void onBindItem(ItemBinding binding, com.lmn.model.entity.Beauty item) {
        binding.setBeauty(item);
        binding.executePendingBindings();
    }
}
