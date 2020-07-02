package com.fengfang.domain;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/1 15:50
 **/
public class FundInfo implements Serializable {

    private Integer id;
    private Integer accountid;
    private Double avimoney;
    private Double rechargemoney;
    private Account account;
    //一个账户只会对应一个用户信息
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public Double getAvimoney() {
        return avimoney;
    }

    public void setAvimoney(Double avimoney) {
        this.avimoney = avimoney;
    }

    public Double getRechargemoney() {
        return rechargemoney;
    }

    public void setRechargemoney(Double rechargemoney) {
        this.rechargemoney = rechargemoney;
    }

    @Override
    public String toString() {
        return "FundInfo{" +
                "id=" + id +
                ",accountid=" + accountid +
                ", avimoney=" +String.format("%.2f",avimoney) +
                ", rechargemoney=" + String.format("%.2f",rechargemoney) +
                '}';
    }
}
