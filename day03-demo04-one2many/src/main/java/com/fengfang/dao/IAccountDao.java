package com.fengfang.dao;

import com.fengfang.domain.Account;
import com.fengfang.domain.AccountFundInfo;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/1 15:52
 **/
public interface IAccountDao {
    /**
     * 查询所有用户数据
     * @return
     */
    public List<Account> findAll();

    /**
     * 连表查询，返回自定义封装对象
     * @return
     */
    public List<AccountFundInfo> findAccountInfo();
}
