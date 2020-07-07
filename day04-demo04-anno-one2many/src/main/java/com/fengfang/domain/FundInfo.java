package com.fengfang.domain;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/6 15:57
 **/
public class FundInfo implements Serializable {
    private Integer id;
    private Integer accountid;
    private Double aviMoney;
    private Double rechargeMoney;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    //多对一，在mybatis是一对一关系，即一个账户只能属于一个用户
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

    public Double getAviMoney() {
        return aviMoney;
    }

    public void setAviMoney(Double aviMoney) {
        this.aviMoney = aviMoney;
    }

    public Double getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(Double rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    @Override
    public String toString() {
        return "FundInfo{" +
                "id=" + id +
                ", accountid=" + accountid +
                ", aviMoney=" + aviMoney +
                ", rechargeMoney=" + rechargeMoney +
                '}';
    }
}
