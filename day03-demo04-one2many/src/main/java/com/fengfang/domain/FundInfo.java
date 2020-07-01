package com.fengfang.domain;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/1 15:50
 **/
public class FundInfo {
    private Integer accountid;
    private Double avimoney;
    private Double rechargemoney;

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
                "accountid=" + accountid +
                ", avimoney=" + avimoney +
                ", rechargemoney=" + rechargemoney +
                '}';
    }
}
