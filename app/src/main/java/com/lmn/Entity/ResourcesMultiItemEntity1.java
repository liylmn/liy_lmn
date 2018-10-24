package com.lmn.Entity;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.lmn.view.resources.adapter.ResourcesAdapter;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class ResourcesMultiItemEntity1 extends AbstractExpandableItem implements MultiItemEntity {
    public String title;
    public String downloadfilename;
    public String baseurl;
    public String url;
    public String imgurl;

    public String getDownloadfilename() {
        return downloadfilename;
    }

    public void setDownloadfilename(String downloadfilename) {
        this.downloadfilename = downloadfilename;
    }

    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int getItemType() {
        return ResourcesAdapter.TYPE_LEVEL_1;
    }

    @Override
    public int getLevel() {
        return 1;
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
