package com.lmn.Entity;

/**
 * 作者：liy_lmn
 * 时间：2018/9/6:17:01
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class LeaveMessageEntity {

    /**
     * code : 1
     * data : {"count":1}
     * msg : 添加成功
     */

    private int code;
    private DataBean data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * count : 1
         */

        private int count;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
