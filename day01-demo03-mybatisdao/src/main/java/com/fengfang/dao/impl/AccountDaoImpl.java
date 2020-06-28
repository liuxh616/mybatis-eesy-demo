package com.fengfang.dao.impl;

import com.fengfang.dao.IAccountDao;
import com.fengfang.domain.Account;
import com.mysql.cj.Session;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/6/28 17:16
 **/
public class AccountDaoImpl implements IAccountDao {
    private SqlSessionFactory factory;

    public AccountDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    /**
     *
     * @return
     */
    public List<Account> findAll() {
        SqlSession session =factory.openSession();
        List<Account> accounts = session.selectList("com.fengfang.dao.IAccountDao.findAll");
        session.close();
        return accounts;
    }
}
