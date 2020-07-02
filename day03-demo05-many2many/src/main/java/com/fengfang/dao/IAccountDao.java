package com.fengfang.dao;

import com.fengfang.domain.Account;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/2 11:33
 **/
public interface IAccountDao {
    /**
     * 查询所有用户信息方法
     * @return
     */
    public List<Account> findAll();
}
