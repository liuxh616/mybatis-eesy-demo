package com.fengfang.domain;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/1 17:00
 **/
public class AccountFundInfo extends FundInfo {
    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString()+ " ---AccountFundInfo{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
