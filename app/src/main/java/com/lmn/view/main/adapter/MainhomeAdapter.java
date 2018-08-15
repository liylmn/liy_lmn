package com.lmn.view.main.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lmn.R;

import java.util.List;


/**
 * 作者：liy_lmn
 * 时间：2018/8/12:20:28
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class MainhomeAdapter extends BaseQuickAdapter<String,BaseViewHolder>{
    public MainhomeAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    public MainhomeAdapter(@Nullable List data) {
        super(data);
    }

    public MainhomeAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
     helper.setText(R.id.tv_type,item.toString());
    }

}