package com.fengfang.dao;

import com.fengfang.domain.Account;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/2 16:17
 **/
public interface IAccountDao {
    List<Account> findAll();
}
