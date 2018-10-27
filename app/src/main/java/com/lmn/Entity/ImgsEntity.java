package com.lmn.Entity;

import java.util.List;

/**
 * 作者：liy_lmn
 * 时间：2018/10/27:13:24
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class ImgsEntity {

    /**
     * code : 1
     * data : {"basePath":"http://118.24.8.237:8080/","page":{"pageNum":1,"pageSize":10,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":2,"pages":1,"list":[{"id":14,"faultId":12,"img":"fault/fault/images/1540378826740_12.png","createTime":1540378827000},{"id":15,"faultId":12,"img":"fault/fault/images/1540378980763_12.png","createTime":1540378981000}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}}
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
         * basePath : http://118.24.8.237:8080/
         * page : {"pageNum":1,"pageSize":10,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":2,"pages":1,"list":[{"id":14,"faultId":12,"img":"fault/fault/images/1540378826740_12.png","createTime":1540378827000},{"id":15,"faultId":12,"img":"fault/fault/images/1540378980763_12.png","createTime":1540378981000}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
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
             * size : 2
             * orderBy : null
             * startRow : 1
             * endRow : 2
             * total : 2
             * pages : 1
             * list : [{"id":14,"faultId":12,"img":"fault/fault/images/1540378826740_12.png","createTime":1540378827000},{"id":15,"faultId":12,"img":"fault/fault/images/1540378980763_12.png","createTime":1540378981000}]
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
                 * id : 14
                 * faultId : 12
                 * img : fault/fault/images/1540378826740_12.png
                 * createTime : 1540378827000
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
