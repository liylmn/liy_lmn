package com.lmn.Entity;

import java.util.List;

/**
 * 作者：liy_lmn
 * 时间：2018/9/6:10:03
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class DetailMessageEntity {

    /**
     * code : 1
     * data : {"basePath":"http://localhost:8087/","fault":{"url":null,"resultType":null,"subFault":null,"faultImgs":[{"id":5,"faultId":1,"img":"fault/fault/images/1535706118625_1.png","createTime":1535706119000}],"reasons":["werwer","qweqwe"],"id":1,"name":"故障现象12","typeId":1,"typeName":"韶系列","categoryId":1,"categoryName":"故障类型1","status":1,"deleteFlag":1,"createTime":null,"updateTime":1535686836000,"reasonName":"werwer|qweqwe"}}
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
         * fault : {"url":null,"resultType":null,"subFault":null,"faultImgs":[{"id":5,"faultId":1,"img":"fault/fault/images/1535706118625_1.png","createTime":1535706119000}],"reasons":["werwer","qweqwe"],"id":1,"name":"故障现象12","typeId":1,"typeName":"韶系列","categoryId":1,"categoryName":"故障类型1","status":1,"deleteFlag":1,"createTime":null,"updateTime":1535686836000,"reasonName":"werwer|qweqwe"}
         */

        private String basePath;
        private FaultBean fault;
        public String getBasePath() {
            return basePath;
        }

        public void setBasePath(String basePath) {
            this.basePath = basePath;
        }

        public FaultBean getFault() {
            return fault;
        }

        public void setFault(FaultBean fault) {
            this.fault = fault;
        }

        public static class FaultBean {
            /**
             * url : null
             * resultType : null
             * subFault : null
             * faultImgs : [{"id":5,"faultId":1,"img":"fault/fault/images/1535706118625_1.png","createTime":1535706119000}]
             * reasons : ["werwer","qweqwe"]
             * id : 1
             * name : 故障现象12
             * typeId : 1
             * typeName : 韶系列
             * categoryId : 1
             * categoryName : 故障类型1
             * status : 1
             * deleteFlag : 1
             * createTime : null
             * updateTime : 1535686836000
             * reasonName : werwer|qweqwe
             */

            private Object url;
            private Object resultType;
            private Object subFault;
            private int id;
            private String name;
            private int typeId;
            private String typeName;
            private int categoryId;
            private String categoryName;
            private int status;
            private int deleteFlag;
            private Object createTime;
            private long updateTime;
            private String reasonName;
            private List<FaultImgsBean> faultImgs;
            private List<String> reasons;
            private String imgSize;

            public String getImgSize() {
                return imgSize;
            }

            public void setImgSize(String imgSize) {
                this.imgSize = imgSize;
            }

            public Object getUrl() {
                return url;
            }

            public void setUrl(Object url) {
                this.url = url;
            }

            public Object getResultType() {
                return resultType;
            }

            public void setResultType(Object resultType) {
                this.resultType = resultType;
            }

            public Object getSubFault() {
                return subFault;
            }

            public void setSubFault(Object subFault) {
                this.subFault = subFault;
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

            public int getTypeId() {
                return typeId;
            }

            public void setTypeId(int typeId) {
                this.typeId = typeId;
            }

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
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

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public String getReasonName() {
                return reasonName;
            }

            public void setReasonName(String reasonName) {
                this.reasonName = reasonName;
            }

            public List<FaultImgsBean> getFaultImgs() {
                return faultImgs;
            }

            public void setFaultImgs(List<FaultImgsBean> faultImgs) {
                this.faultImgs = faultImgs;
            }

            public List<String> getReasons() {
                return reasons;
            }

            public void setReasons(List<String> reasons) {
                this.reasons = reasons;
            }

            public static class FaultImgsBean {
                /**
                 * id : 5
                 * faultId : 1
                 * img : fault/fault/images/1535706118625_1.png
                 * createTime : 1535706119000
                 */

                private int id;
                private int faultId;
                private String img;
                private long createTime;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getFaultId() {
                    return faultId;
                }

                public void setFaultId(int faultId) {
                    this.faultId = faultId;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public long getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(long createTime) {
                    this.createTime = createTime;
                }
            }
        }
    }
}
