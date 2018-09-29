package com.lmn.view.search;

import com.lmn.Entity.SearchEntity;

/**
 * 作者：liy_lmn
 * 时间：2018/9/7:18:04
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class SearchContract {
    interface View {
        void getdata(SearchEntity searchEntity);
    }

    interface Presenter {
        void searchdate(String name,String resultType);
        void destory();
    }
}
