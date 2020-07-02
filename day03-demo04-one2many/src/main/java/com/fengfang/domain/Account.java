package com.fengfang.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/1 15:50
 **/
public class Account implements Serializable {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    //用户的账户信息，一个用户可以有多个账户信息
    public List<FundInfo> getFundInfos() {
        return fundInfos;
    }

    public void setFundInfos(List<FundInfo> fundInfos) {
        this.fundInfos = fundInfos;
    }

    private List<FundInfo> fundInfos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +'\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
