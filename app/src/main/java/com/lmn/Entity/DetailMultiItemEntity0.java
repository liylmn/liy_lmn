package com.lmn.Entity;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.lmn.view.main.detail.adapter.DetailAdapter;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class DetailMultiItemEntity0 extends AbstractExpandableItem<DetailMultiItemEntity1> implements MultiItemEntity {
    public String title;
    public String imgurl;

    @Override
    public int getItemType() {
        return DetailAdapter.TYPE_LEVEL_0;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
