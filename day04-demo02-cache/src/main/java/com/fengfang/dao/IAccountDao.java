package com.fengfang.dao;

import com.fengfang.domain.Account;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/6 11:28
 **/
public interface IAccountDao {
    /**
     * 查询所有用户数据
     * @return
     */
    public List<Account> findAll();

    /**
     * 根据用户id查询用户信息
     *
     * @param accountid
     * @return
     */
    public Account findById(Integer accountid);

    /**
     * 更新用户信息
     * @param account
     */
    public void updateAccount(Account account);
}
