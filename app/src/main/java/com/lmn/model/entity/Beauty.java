package com.lmn.model.entity;

import lmn.com.lmnlibrary.base.BaseEntity;

public class Beauty extends BaseEntity{
    public String beautyNum;
    public String imageUrl;

    public String getBeautyNum() {
        return beautyNum;
    }

    public void setBeautyNum(String beautyNum) {
        this.beautyNum = beautyNum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Beauty(String beautyNum, String imageUrl) {
        this.beautyNum = beautyNum;
        this.imageUrl = imageUrl;
    }
}