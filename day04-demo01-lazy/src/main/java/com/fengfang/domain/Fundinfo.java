package com.fengfang.domain;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/6 10:15
 **/
public class Fundinfo implements Serializable {
    private Integer id;
    private Integer accountid;
    private Double avimoney;
    private Double rechargemoney;
    private Account account;

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Fundinfo{" +
                "id=" + id +
                ", accountid=" + accountid +
                ", avimoney=" + avimoney +
                ", rechargemoney=" + rechargemoney +
                ", account=" + account +
                '}';
    }
}
