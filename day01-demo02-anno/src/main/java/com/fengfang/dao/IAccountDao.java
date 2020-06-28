package com.fengfang.dao;

import com.fengfang.domain.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/6/28 16:55
 **/
public interface IAccountDao {
    @Select("select * from Account")
    public List<Account> findAll();
}
