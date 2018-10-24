package com.lmn.view.main.detail.adapter;

import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.lmn.Entity.DetailMultiItemEntity0;
import com.lmn.Entity.DetailMultiItemEntity1;
import com.lmn.R;

import java.util.List;

import lmn.com.lmnlibrary.imageloader.ILoader;
import lmn.com.lmnlibrary.imageloader.ImageFactory;

/**
 * 作者：liy_lmn
 * 时间：2018/8/16:17:51
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class DetailAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    public static final int TYPE_LEVEL_2 = 2;
    public DetailAdapter(List<MultiItemEntity> data) {
        super(data);
            addItemType(TYPE_LEVEL_0, R.layout.item_expandable_lv0);
            addItemType(TYPE_LEVEL_1, R.layout.item_expandable_lv1);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final MultiItemEntity item) {
        switch (helper.getItemViewType()){
            case TYPE_LEVEL_0:
                final DetailMultiItemEntity0 item0 = (DetailMultiItemEntity0) item;
                helper.setText(R.id.title, item0.title)
                        .setImageResource(R.id.iv, item0.isExpanded() ? R.mipmap.arrow_b : R.mipmap.arrow_r);
                ImageFactory.getLoader().loadNet((ImageView) helper.getView(R.id.iv_head),item0.getImgurl(),new ILoader.Options(R.drawable.loading_img,R.mipmap.head_img));
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
                final DetailMultiItemEntity1 item1 = (DetailMultiItemEntity1) item;
                helper.setText(R.id.title, item1.title);
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ARouter.getInstance().build("/detailmessage/activity")
                                .withString("message", ((DetailMultiItemEntity1) item).getTitle())
                                .withString("id", ((DetailMultiItemEntity1) item).getId()+"")
                                .navigation();

                    }
                });
                break;
        }

    }

}
