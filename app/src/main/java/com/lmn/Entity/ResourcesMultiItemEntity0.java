package com.lmn.Entity;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.lmn.view.resources.adapter.ResourcesAdapter;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class ResourcesMultiItemEntity0 extends AbstractExpandableItem<ResourcesMultiItemEntity1> implements MultiItemEntity {
    public String title;

    @Override
    public int getItemType() {
        return ResourcesAdapter.TYPE_LEVEL_0;
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
}
