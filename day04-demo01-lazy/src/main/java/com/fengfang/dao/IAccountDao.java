package com.fengfang.dao;

import com.fengfang.domain.Account;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/3 17:16
 **/
public interface IAccountDao {
    /**
     * 查询所有用户数据
     * @return
     */
    public List<Account> findAll();
}
