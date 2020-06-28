package com.fengfang.dao;

import com.fengfang.domain.Account;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/6/28 16:41
 **/
public interface IAccountDao {
    /**
     * 定义一个查询所有数据接口
     * @return
     */
    public List<Account> findAll();
}
