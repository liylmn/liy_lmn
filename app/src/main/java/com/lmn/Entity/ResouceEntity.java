package com.lmn.Entity;

import java.util.List;

/**
 * 作者：liy_lmn
 * 时间：2018/9/6:15:55
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class ResouceEntity {

    /**
     * code : 1
     * data : {"basePath":"http://localhost:8087/","page":{"pageNum":1,"pageSize":10,"size":3,"orderBy":null,"startRow":1,"endRow":3,"total":3,"pages":1,"list":[{"faultResources":[{"faultResources":null,"id":3,"name":"故障资源12","url":"fault/resource/files/1535783986525_3_完美学员花名册总表.xls","type":"完美学员花名册总表.xls","status":1,"deleteFlag":1,"createTime":1535782246000,"updateTime":1535783987000,"createUser":3,"createDate":"2018-09-01"},{"faultResources":null,"id":4,"name":"故障资源333","url":null,"type":null,"status":1,"deleteFlag":1,"createTime":1535782246000,"updateTime":1535782488000,"createUser":null,"createDate":"2018-09-01"}],"id":null,"name":null,"url":null,"type":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"createUser":null,"createDate":"2018-09-01"},{"faultResources":[{"faultResources":null,"id":2,"name":"故障资源444","url":"fault/resource/files/1535782813471_2_完美学员花名册总表.xls","type":"完美学员花名册总表.xls","status":1,"deleteFlag":1,"createTime":1535644800000,"updateTime":1535782813000,"createUser":3,"createDate":"2018-08-31"}],"id":null,"name":null,"url":null,"type":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"createUser":null,"createDate":"2018-08-31"},{"faultResources":[{"faultResources":null,"id":1,"name":"故障资源1","url":"fault/resource/files/1535781377962_1_Hydrangeas.jpg","type":null,"status":1,"deleteFlag":1,"createTime":1535472000000,"updateTime":1535781379000,"createUser":3,"createDate":"2018-08-29"}],"id":null,"name":null,"url":null,"type":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"createUser":null,"createDate":"2018-08-29"}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}}
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
         * page : {"pageNum":1,"pageSize":10,"size":3,"orderBy":null,"startRow":1,"endRow":3,"total":3,"pages":1,"list":[{"faultResources":[{"faultResources":null,"id":3,"name":"故障资源12","url":"fault/resource/files/1535783986525_3_完美学员花名册总表.xls","type":"完美学员花名册总表.xls","status":1,"deleteFlag":1,"createTime":1535782246000,"updateTime":1535783987000,"createUser":3,"createDate":"2018-09-01"},{"faultResources":null,"id":4,"name":"故障资源333","url":null,"type":null,"status":1,"deleteFlag":1,"createTime":1535782246000,"updateTime":1535782488000,"createUser":null,"createDate":"2018-09-01"}],"id":null,"name":null,"url":null,"type":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"createUser":null,"createDate":"2018-09-01"},{"faultResources":[{"faultResources":null,"id":2,"name":"故障资源444","url":"fault/resource/files/1535782813471_2_完美学员花名册总表.xls","type":"完美学员花名册总表.xls","status":1,"deleteFlag":1,"createTime":1535644800000,"updateTime":1535782813000,"createUser":3,"createDate":"2018-08-31"}],"id":null,"name":null,"url":null,"type":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"createUser":null,"createDate":"2018-08-31"},{"faultResources":[{"faultResources":null,"id":1,"name":"故障资源1","url":"fault/resource/files/1535781377962_1_Hydrangeas.jpg","type":null,"status":1,"deleteFlag":1,"createTime":1535472000000,"updateTime":1535781379000,"createUser":3,"createDate":"2018-08-29"}],"id":null,"name":null,"url":null,"type":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"createUser":null,"createDate":"2018-08-29"}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
         */

        private String basePath;
        private PageBean page;

        public String getBasePath() {
            return basePath;
        }

        public void setBasePath(String basePath) {
            this.basePath = basePath;
        }

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public static class PageBean {
            /**
             * pageNum : 1
             * pageSize : 10
             * size : 3
             * orderBy : null
             * startRow : 1
             * endRow : 3
             * total : 3
             * pages : 1
             * list : [{"faultResources":[{"faultResources":null,"id":3,"name":"故障资源12","url":"fault/resource/files/1535783986525_3_完美学员花名册总表.xls","type":"完美学员花名册总表.xls","status":1,"deleteFlag":1,"createTime":1535782246000,"updateTime":1535783987000,"createUser":3,"createDate":"2018-09-01"},{"faultResources":null,"id":4,"name":"故障资源333","url":null,"type":null,"status":1,"deleteFlag":1,"createTime":1535782246000,"updateTime":1535782488000,"createUser":null,"createDate":"2018-09-01"}],"id":null,"name":null,"url":null,"type":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"createUser":null,"createDate":"2018-09-01"},{"faultResources":[{"faultResources":null,"id":2,"name":"故障资源444","url":"fault/resource/files/1535782813471_2_完美学员花名册总表.xls","type":"完美学员花名册总表.xls","status":1,"deleteFlag":1,"createTime":1535644800000,"updateTime":1535782813000,"createUser":3,"createDate":"2018-08-31"}],"id":null,"name":null,"url":null,"type":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"createUser":null,"createDate":"2018-08-31"},{"faultResources":[{"faultResources":null,"id":1,"name":"故障资源1","url":"fault/resource/files/1535781377962_1_Hydrangeas.jpg","type":null,"status":1,"deleteFlag":1,"createTime":1535472000000,"updateTime":1535781379000,"createUser":3,"createDate":"2018-08-29"}],"id":null,"name":null,"url":null,"type":null,"status":null,"deleteFlag":null,"createTime":null,"updateTime":null,"createUser":null,"createDate":"2018-08-29"}]
             * firstPage : 1
             * prePage : 0
             * nextPage : 0
             * lastPage : 1
             * isFirstPage : true
             * isLastPage : true
             * hasPreviousPage : false
             * hasNextPage : false
             * navigatePages : 8
             * navigatepageNums : [1]
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
                 * faultResources : [{"faultResources":null,"id":3,"name":"故障资源12","url":"fault/resource/files/1535783986525_3_完美学员花名册总表.xls","type":"完美学员花名册总表.xls","status":1,"deleteFlag":1,"createTime":1535782246000,"updateTime":1535783987000,"createUser":3,"createDate":"2018-09-01"},{"faultResources":null,"id":4,"name":"故障资源333","url":null,"type":null,"status":1,"deleteFlag":1,"createTime":1535782246000,"updateTime":1535782488000,"createUser":null,"createDate":"2018-09-01"}]
                 * id : null
                 * name : null
                 * url : null
                 * type : null
                 * status : null
                 * deleteFlag : null
                 * createTime : null
                 * updateTime : null
                 * createUser : null
                 * createDate : 2018-09-01
                 */

                private Object id;
                private Object name;
                private Object url;
                private Object type;
                private Object status;
                private Object deleteFlag;
                private Object createTime;
                private Object updateTime;
                private Object createUser;
                private String createDate;
                private List<FaultResourcesBean> faultResources;

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

                public Object getUrl() {
                    return url;
                }

                public void setUrl(Object url) {
                    this.url = url;
                }

                public Object getType() {
                    return type;
                }

                public void setType(Object type) {
                    this.type = type;
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

                public Object getCreateUser() {
                    return createUser;
                }

                public void setCreateUser(Object createUser) {
                    this.createUser = createUser;
                }

                public String getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(String createDate) {
                    this.createDate = createDate;
                }

                public List<FaultResourcesBean> getFaultResources() {
                    return faultResources;
                }

                public void setFaultResources(List<FaultResourcesBean> faultResources) {
                    this.faultResources = faultResources;
                }

                public static class FaultResourcesBean {
                    /**
                     * faultResources : null
                     * id : 3
                     * name : 故障资源12
                     * url : fault/resource/files/1535783986525_3_完美学员花名册总表.xls
                     * type : 完美学员花名册总表.xls
                     * status : 1
                     * deleteFlag : 1
                     * createTime : 1535782246000
                     * updateTime : 1535783987000
                     * createUser : 3
                     * createDate : 2018-09-01
                     */

                    private Object faultResources;
                    private int id;
                    private String name;
                    private String url;
                    private String type;
                    private int status;
                    private int deleteFlag;
                    private long createTime;
                    private long updateTime;
                    private int createUser;
                    private String createDate;

                    public Object getFaultResources() {
                        return faultResources;
                    }

                    public void setFaultResources(Object faultResources) {
                        this.faultResources = faultResources;
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

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
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

                    public long getUpdateTime() {
                        return updateTime;
                    }

                    public void setUpdateTime(long updateTime) {
                        this.updateTime = updateTime;
                    }

                    public int getCreateUser() {
                        return createUser;
                    }

                    public void setCreateUser(int createUser) {
                        this.createUser = createUser;
                    }

                    public String getCreateDate() {
                        return createDate;
                    }

                    public void setCreateDate(String createDate) {
                        this.createDate = createDate;
                    }
                }
            }
        }
    }
}
