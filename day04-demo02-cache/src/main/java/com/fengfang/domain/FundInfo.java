package com.fengfang.domain;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/6 11:27
 **/
public class FundInfo implements Serializable {
    private Integer id;
    private Integer accountId;
    private Double aviMoney;
    private Double rechargeMoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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
                ", accountId=" + accountId +
                ", aviMoney=" + aviMoney +
                ", rechargeMoney=" + rechargeMoney +
                '}';
    }
}
