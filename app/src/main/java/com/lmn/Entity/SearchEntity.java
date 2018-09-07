package com.lmn.Entity;

import java.util.List;

/**
 * 作者：liy_lmn
 * 时间：2018/9/7:18:12
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class SearchEntity {

    /**
     * code : 1
     * data : {"basePath":"http://localhost:8087/","list":[{"url":null,"resultType":1,"subFault":null,"faultImgs":null,"reasons":null,"id":1,"name":"故障现象12","typeId":null,"typeName":null,"categoryId":null,"categoryName":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"reasonName":null},{"url":null,"resultType":1,"subFault":null,"faultImgs":null,"reasons":null,"id":2,"name":"故障现象1","typeId":null,"typeName":null,"categoryId":null,"categoryName":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"reasonName":null},{"url":null,"resultType":1,"subFault":null,"faultImgs":null,"reasons":null,"id":5,"name":"故障现象3","typeId":null,"typeName":null,"categoryId":null,"categoryName":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"reasonName":null},{"url":"fault/resource/files/1535781377962_1_Hydrangeas.jpg","resultType":2,"subFault":null,"faultImgs":null,"reasons":null,"id":1,"name":"故障资源1","typeId":null,"typeName":null,"categoryId":null,"categoryName":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"reasonName":null},{"url":"fault/resource/files/1535782813471_2_完美学员花名册总表.xls","resultType":2,"subFault":null,"faultImgs":null,"reasons":null,"id":2,"name":"故障资源444","typeId":null,"typeName":null,"categoryId":null,"categoryName":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"reasonName":null},{"url":"fault/resource/files/1535783986525_3_完美学员花名册总表.xls","resultType":2,"subFault":null,"faultImgs":null,"reasons":null,"id":3,"name":"故障资源12","typeId":null,"typeName":null,"categoryId":null,"categoryName":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"reasonName":null},{"url":null,"resultType":2,"subFault":null,"faultImgs":null,"reasons":null,"id":4,"name":"故障资源333","typeId":null,"typeName":null,"categoryId":null,"categoryName":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"reasonName":null}]}
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
         * basePath : http://localhost:8087/
         * list : [{"url":null,"resultType":1,"subFault":null,"faultImgs":null,"reasons":null,"id":1,"name":"故障现象12","typeId":null,"typeName":null,"categoryId":null,"categoryName":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"reasonName":null},{"url":null,"resultType":1,"subFault":null,"faultImgs":null,"reasons":null,"id":2,"name":"故障现象1","typeId":null,"typeName":null,"categoryId":null,"categoryName":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"reasonName":null},{"url":null,"resultType":1,"subFault":null,"faultImgs":null,"reasons":null,"id":5,"name":"故障现象3","typeId":null,"typeName":null,"categoryId":null,"categoryName":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"reasonName":null},{"url":"fault/resource/files/1535781377962_1_Hydrangeas.jpg","resultType":2,"subFault":null,"faultImgs":null,"reasons":null,"id":1,"name":"故障资源1","typeId":null,"typeName":null,"categoryId":null,"categoryName":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"reasonName":null},{"url":"fault/resource/files/1535782813471_2_完美学员花名册总表.xls","resultType":2,"subFault":null,"faultImgs":null,"reasons":null,"id":2,"name":"故障资源444","typeId":null,"typeName":null,"categoryId":null,"categoryName":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"reasonName":null},{"url":"fault/resource/files/1535783986525_3_完美学员花名册总表.xls","resultType":2,"subFault":null,"faultImgs":null,"reasons":null,"id":3,"name":"故障资源12","typeId":null,"typeName":null,"categoryId":null,"categoryName":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"reasonName":null},{"url":null,"resultType":2,"subFault":null,"faultImgs":null,"reasons":null,"id":4,"name":"故障资源333","typeId":null,"typeName":null,"categoryId":null,"categoryName":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"reasonName":null}]
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
             * url : null
             * resultType : 1
             * subFault : null
             * faultImgs : null
             * reasons : null
             * id : 1
             * name : 故障现象12
             * typeId : null
             * typeName : null
             * categoryId : null
             * categoryName : null
             * status : null
             * deleteFlag : null
             * createTime : null
             * updateTime : null
             * reasonName : null
             */

            private Object url;
            private int resultType;
            private Object subFault;
            private Object faultImgs;
            private Object reasons;
            private int id;
            private String name;
            private Object typeId;
            private Object typeName;
            private Object categoryId;
            private Object categoryName;
            private Object status;
            private Object deleteFlag;
            private Object createTime;
            private Object updateTime;
            private Object reasonName;

            public Object getUrl() {
                return url;
            }

            public void setUrl(Object url) {
                this.url = url;
            }

            public int getResultType() {
                return resultType;
            }

            public void setResultType(int resultType) {
                this.resultType = resultType;
            }

            public Object getSubFault() {
                return subFault;
            }

            public void setSubFault(Object subFault) {
                this.subFault = subFault;
            }

            public Object getFaultImgs() {
                return faultImgs;
            }

            public void setFaultImgs(Object faultImgs) {
                this.faultImgs = faultImgs;
            }

            public Object getReasons() {
                return reasons;
            }

            public void setReasons(Object reasons) {
                this.reasons = reasons;
            }

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

            public Object getTypeId() {
                return typeId;
            }

            public void setTypeId(Object typeId) {
                this.typeId = typeId;
            }

            public Object getTypeName() {
                return typeName;
            }

            public void setTypeName(Object typeName) {
                this.typeName = typeName;
            }

            public Object getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(Object categoryId) {
                this.categoryId = categoryId;
            }

            public Object getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(Object categoryName) {
                this.categoryName = categoryName;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Object getDeleteFlag() {
                return deleteFlag;
            }

            public void setDeleteFlag(Object deleteFlag) {
                this.deleteFlag = deleteFlag;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public Object getReasonName() {
                return reasonName;
            }

            public void setReasonName(Object reasonName) {
                this.reasonName = reasonName;
            }
        }
    }
}
