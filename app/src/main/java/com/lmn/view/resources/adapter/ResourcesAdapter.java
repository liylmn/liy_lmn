package com.lmn.view.resources.adapter;

import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.lmn.Entity.ResourcesMultiItemEntity0;
import com.lmn.Entity.ResourcesMultiItemEntity1;
import com.lmn.R;

import java.util.List;

/**
 * 作者：liy_lmn
 * 时间：2018/8/16:17:51
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class ResourcesAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    public static final int TYPE_LEVEL_2 = 2;
    public ResourcesAdapter(List<MultiItemEntity> data) {
        super(data);
            addItemType(TYPE_LEVEL_0, R.layout.item_expandable_lv0);
            addItemType(TYPE_LEVEL_1, R.layout.item_expandable_lv1);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final MultiItemEntity item) {
        switch (helper.getItemViewType()){
            case TYPE_LEVEL_0:
                final ResourcesMultiItemEntity0 item0 = (ResourcesMultiItemEntity0) item;
                helper.setText(R.id.title, item0.title)
                        .setImageResource(R.id.iv, item0.isExpanded() ? R.mipmap.arrow_b : R.mipmap.arrow_r);
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = helper.getAdapterPosition();
                        if (item0.isExpanded()){
                            collapse(pos);
//                            ToastUtils.showShortToast("收起：" + item0.getTitle());
                        }else {
                            expand(pos);
//                            ToastUtils.showShortToast("展开：" + item0.getTitle());
                        }
                    }
                });
                break;
            case TYPE_LEVEL_1:
                final ResourcesMultiItemEntity1 item1 = (ResourcesMultiItemEntity1) item;
                helper.setText(R.id.title, item1.title);
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ARouter.getInstance().build("/detailmessage/activity")
                                .withString("message", ((ResourcesMultiItemEntity1) item).getTitle())
                                .navigation();

                    }
                });
                break;
        }

    }

}
