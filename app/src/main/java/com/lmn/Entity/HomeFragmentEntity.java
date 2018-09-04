package com.lmn.Entity;

import java.util.List;

/**
 * 作者：liy_lmn
 * 时间：2018/9/4:10:09
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class HomeFragmentEntity {

    /**
     * code : 1
     * data : {"basePath":"http://39.106.129.19:8088/","list":[{"id":1,"name":"韶系列","status":1,"deleteFlag":1,"img":"fault/train/images/1535966945607_1.png"},{"id":2,"name":"和谐号","status":1,"deleteFlag":1,"img":"fault/train/images/1535704090599_2.png"}]}
     * msg : 查询成功
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
         * basePath : http://39.106.129.19:8088/
         * list : [{"id":1,"name":"韶系列","status":1,"deleteFlag":1,"img":"fault/train/images/1535966945607_1.png"},{"id":2,"name":"和谐号","status":1,"deleteFlag":1,"img":"fault/train/images/1535704090599_2.png"}]
         */

        private String basePath;
        private List<ListBean> list;

        public String getBasePath() {
            return basePath;
        }

        public void setBasePath(String basePath) {
            this.basePath = basePath;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 1
             * name : 韶系列
             * status : 1
             * deleteFlag : 1
             * img : fault/train/images/1535966945607_1.png
             */

            private int id;
            private String name;
            private int status;
            private int deleteFlag;
            private String img;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getDeleteFlag() {
                return deleteFlag;
            }

            public void setDeleteFlag(int deleteFlag) {
                this.deleteFlag = deleteFlag;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }
}
