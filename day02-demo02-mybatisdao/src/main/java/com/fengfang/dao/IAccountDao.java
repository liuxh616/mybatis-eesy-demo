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

    /**
     * 保存方法
     * @param account
     */
    public void saveAccount(Account account);

    /**
     * 更新用户方法
     * @param account
     * @return
     */
    public Integer updateAccount(Account account);

    /**
     * 根据指定ID删除用户
     * @param accountId
     */
    public void deleteAccount(Integer accountId);

    /**
     * 根据用户ID查询用户信息
     * @param accountId
     * @return
     */
    public Account findById(Integer accountId);

    /**
     * 根据用户名称模糊查询用户信息
     * @param username
     * @return
     */
    public List<Account> findByName(String username);

    /**
     * 获取用户总记录条数
     * @return
     */
    Integer findAccountCount();


}
