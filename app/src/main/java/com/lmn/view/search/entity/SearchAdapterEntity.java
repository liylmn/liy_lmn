package com.lmn.view.search.entity;

/**
 * 作者：liy_lmn
 * 时间：2018/10/26:11:34
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class SearchAdapterEntity {
    String name;
    String id;
    String baseurl;
    String imgurl;
    String resulttype;

    public String getResulttype() {
        return resulttype;
    }

    public void setResulttype(String resulttype) {
        this.resulttype = resulttype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
