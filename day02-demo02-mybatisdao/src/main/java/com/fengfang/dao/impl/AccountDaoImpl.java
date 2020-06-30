package com.fengfang.dao.impl;

import com.fengfang.dao.IAccountDao;
import com.fengfang.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/6/30 15:18
 **/
public class AccountDaoImpl implements IAccountDao {

    private SqlSessionFactory factory;
    private SqlSession session;
    public AccountDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
        session = factory.openSession();
    }
    public List<Account> findAll() {
        //调用SqlSession中的方法实现查询列表
        List<Account> accounts= session.selectList("com.fengfang.dao.IAccountDao.findAll");
        session.close();
        return accounts;
    }

    public void saveAccount(Account account) {
        session.insert("com.fengfang.dao.IAccountDao.saveAccount",account);
        //提交事务
        session.commit();
        //释放资源
        session.close();

    }

    public Integer updateAccount(Account account) {
        session.insert("com.fengfang.dao.IAccountDao.updateAccount",account);
        //提交事务
        session.commit();
        //释放资源
        session.close();
        return 1;
    }

    public void deleteAccount(Integer accountId) {
        session.insert("com.fengfang.dao.IAccountDao.deleteAccount",accountId);
        //提交事务
        session.commit();
        //释放资源
        session.close();
    }

    public Account findById(Integer accountId) {
        Account account = session.selectOne("com.fengfang.dao.IAccountDao.findById",accountId);
        session.close();
        return account;
    }

    public List<Account> findByName(String username) {
        List<Account> accounts = session.selectList("com.fengfang.dao.IAccountDao.findByName", username);
        session.close();
        return accounts;
    }

    public Integer findAccountCount() {
        Integer accountnum = session.selectOne("com.fengfang.dao.IAccountDao.findAccountCount");
        return accountnum;
    }
}
