package com.fengfang.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/6/28 16:39
 **/
public class Account implements Serializable {
    private Integer userId;   //若字段名称和数据库不一样，可以在查询SQL时使用别名与类中字段名称一致就可以解决，对象封装的问题
    private String username;
    private Date birthday;
    private String sex;
    private String userAddress;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}
