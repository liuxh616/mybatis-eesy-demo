package com.fengfang.domain;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/6/30 9:16
 **/
public class QueryVo {
    private Account account;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    private List<Integer> ids;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
