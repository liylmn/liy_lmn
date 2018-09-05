package com.lmn.Entity;

/**
 * 作者：liy_lmn
 * 时间：2018/9/5:14:43
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class LoginEntity {

    /**
     * code : 1
     * data : {"user":{"id":1,"name":"用户1","status":1,"createTime":null,"studentNumber":"13123","lockedTime":"2018-09-03 18:53:35","userAddress":null,"locked":false}}
     * msg : 登录成功
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
         * user : {"id":1,"name":"用户1","status":1,"createTime":null,"studentNumber":"13123","lockedTime":"2018-09-03 18:53:35","userAddress":null,"locked":false}
         */

        private UserBean user;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * id : 1
             * name : 用户1
             * status : 1
             * createTime : null
             * studentNumber : 13123
             * lockedTime : 2018-09-03 18:53:35
             * userAddress : null
             * locked : false
             */

            private int id;
            private String name;
            private int status;
            private Object createTime;
            private String studentNumber;
            private String lockedTime;
            private Object userAddress;
            private boolean locked;

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

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public String getStudentNumber() {
                return studentNumber;
            }

            public void setStudentNumber(String studentNumber) {
                this.studentNumber = studentNumber;
            }

            public String getLockedTime() {
                return lockedTime;
            }

            public void setLockedTime(String lockedTime) {
                this.lockedTime = lockedTime;
            }

            public Object getUserAddress() {
                return userAddress;
            }

            public void setUserAddress(Object userAddress) {
                this.userAddress = userAddress;
            }

            public boolean isLocked() {
                return locked;
            }

            public void setLocked(boolean locked) {
                this.locked = locked;
            }
        }
    }
}
