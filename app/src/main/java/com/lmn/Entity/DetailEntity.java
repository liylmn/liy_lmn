package com.lmn.Entity;

import java.util.List;

/**
 * 作者：liy_lmn
 * 时间：2018/9/5:16:16
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class DetailEntity {

    /**
     * code : 1
     * data : {"page":{"pageNum":1,"pageSize":1,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":2,"pages":2,"list":[{"url":null,"resultType":null,"subFault":[{"url":null,"resultType":null,"subFault":null,"faultImgs":null,"reasons":null,"id":3,"name":"门打不开","typeId":2,"typeName":"和谐号","categoryId":2,"categoryName":"故障类型2","status":1,"deleteFlag":1,"createTime":1535681374000,"updateTime":null,"reasonName":null}],"faultImgs":null,"reasons":null,"id":null,"name":null,"typeId":null,"typeName":null,"categoryId":2,"categoryName":"故障类型2","status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"reasonName":null}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2]}}
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
         * page : {"pageNum":1,"pageSize":1,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":2,"pages":2,"list":[{"url":null,"resultType":null,"subFault":[{"url":null,"resultType":null,"subFault":null,"faultImgs":null,"reasons":null,"id":3,"name":"门打不开","typeId":2,"typeName":"和谐号","categoryId":2,"categoryName":"故障类型2","status":1,"deleteFlag":1,"createTime":1535681374000,"updateTime":null,"reasonName":null}],"faultImgs":null,"reasons":null,"id":null,"name":null,"typeId":null,"typeName":null,"categoryId":2,"categoryName":"故障类型2","status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"reasonName":null}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2]}
         */

        private PageBean page;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public static class PageBean {
            /**
             * pageNum : 1
             * pageSize : 1
             * size : 1
             * orderBy : null
             * startRow : 1
             * endRow : 1
             * total : 2
             * pages : 2
             * list : [{"url":null,"resultType":null,"subFault":[{"url":null,"resultType":null,"subFault":null,"faultImgs":null,"reasons":null,"id":3,"name":"门打不开","typeId":2,"typeName":"和谐号","categoryId":2,"categoryName":"故障类型2","status":1,"deleteFlag":1,"createTime":1535681374000,"updateTime":null,"reasonName":null}],"faultImgs":null,"reasons":null,"id":null,"name":null,"typeId":null,"typeName":null,"categoryId":2,"categoryName":"故障类型2","status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"reasonName":null}]
             * firstPage : 1
             * prePage : 0
             * nextPage : 2
             * lastPage : 2
             * isFirstPage : true
             * isLastPage : false
             * hasPreviousPage : false
             * hasNextPage : true
             * navigatePages : 8
             * navigatepageNums : [1,2]
             */

            private int pageNum;
            private int pageSize;
            private int size;
            private Object orderBy;
            private int startRow;
            private int endRow;
            private int total;
            private int pages;
            private int firstPage;
            private int prePage;
            private int nextPage;
            private int lastPage;
            private boolean isFirstPage;
            private boolean isLastPage;
            private boolean hasPreviousPage;
            private boolean hasNextPage;
            private int navigatePages;
            private List<ListBean> list;
            private List<Integer> navigatepageNums;

            public int getPageNum() {
                return pageNum;
            }

            public void setPageNum(int pageNum) {
                this.pageNum = pageNum;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public Object getOrderBy() {
                return orderBy;
            }

            public void setOrderBy(Object orderBy) {
                this.orderBy = orderBy;
            }

            public int getStartRow() {
                return startRow;
            }

            public void setStartRow(int startRow) {
                this.startRow = startRow;
            }

            public int getEndRow() {
                return endRow;
            }

            public void setEndRow(int endRow) {
                this.endRow = endRow;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getFirstPage() {
                return firstPage;
            }

            public void setFirstPage(int firstPage) {
                this.firstPage = firstPage;
            }

            public int getPrePage() {
                return prePage;
            }

            public void setPrePage(int prePage) {
                this.prePage = prePage;
            }

            public int getNextPage() {
                return nextPage;
            }

            public void setNextPage(int nextPage) {
                this.nextPage = nextPage;
            }

            public int getLastPage() {
                return lastPage;
            }

            public void setLastPage(int lastPage) {
                this.lastPage = lastPage;
            }

            public boolean isIsFirstPage() {
                return isFirstPage;
            }

            public void setIsFirstPage(boolean isFirstPage) {
                this.isFirstPage = isFirstPage;
            }

            public boolean isIsLastPage() {
                return isLastPage;
            }

            public void setIsLastPage(boolean isLastPage) {
                this.isLastPage = isLastPage;
            }

            public boolean isHasPreviousPage() {
                return hasPreviousPage;
            }

            public void setHasPreviousPage(boolean hasPreviousPage) {
                this.hasPreviousPage = hasPreviousPage;
            }

            public boolean isHasNextPage() {
                return hasNextPage;
            }

            public void setHasNextPage(boolean hasNextPage) {
                this.hasNextPage = hasNextPage;
            }

            public int getNavigatePages() {
                return navigatePages;
            }

            public void setNavigatePages(int navigatePages) {
                this.navigatePages = navigatePages;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public List<Integer> getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(List<Integer> navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }

            public static class ListBean {
                /**
                 * url : null
                 * resultType : null
                 * subFault : [{"url":null,"resultType":null,"subFault":null,"faultImgs":null,"reasons":null,"id":3,"name":"门打不开","typeId":2,"typeName":"和谐号","categoryId":2,"categoryName":"故障类型2","status":1,"deleteFlag":1,"createTime":1535681374000,"updateTime":null,"reasonName":null}]
                 * faultImgs : null
                 * reasons : null
                 * id : null
                 * name : null
                 * typeId : null
                 * typeName : null
                 * categoryId : 2
                 * categoryName : 故障类型2
                 * status : null
                 * deleteFlag : null
                 * createTime : null
                 * updateTime : null
                 * reasonName : null
                 */

                private Object url;
                private Object resultType;
                private Object faultImgs;
                private Object reasons;
                private Object id;
                private Object name;
                private Object typeId;
                private Object typeName;
                private int categoryId;
                private String categoryName;
                private Object status;
                private Object deleteFlag;
                private Object createTime;
                private Object updateTime;
                private Object reasonName;
                private List<SubFaultBean> subFault;

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

                public Object getId() {
                    return id;
                }

                public void setId(Object id) {
                    this.id = id;
                }

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
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

                public List<SubFaultBean> getSubFault() {
                    return subFault;
                }

                public void setSubFault(List<SubFaultBean> subFault) {
                    this.subFault = subFault;
                }

                public static class SubFaultBean {
                    /**
                     * url : null
                     * resultType : null
                     * subFault : null
                     * faultImgs : null
                     * reasons : null
                     * id : 3
                     * name : 门打不开
                     * typeId : 2
                     * typeName : 和谐号
                     * categoryId : 2
                     * categoryName : 故障类型2
                     * status : 1
                     * deleteFlag : 1
                     * createTime : 1535681374000
                     * updateTime : null
                     * reasonName : null
                     */

                    private Object url;
                    private Object resultType;
                    private Object subFault;
                    private Object faultImgs;
                    private Object reasons;
                    private int id;
                    private String name;
                    private int typeId;
                    private String typeName;
                    private int categoryId;
                    private String categoryName;
                    private int status;
                    private int deleteFlag;
                    private long createTime;
                    private Object updateTime;
                    private Object reasonName;

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

                    public long getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(long createTime) {
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
    }
}
