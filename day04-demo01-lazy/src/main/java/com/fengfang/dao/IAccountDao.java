package com.fengfang.dao;

import com.fengfang.domain.Account;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/6 9:41
 **/
public interface IAccountDao {

    public List<Account> findAll();

    public Account findById(Integer id);
}
