package com.fengfang.test;

import com.fengfang.dao.IAccountDao;
import com.fengfang.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/6 16:04
 **/
public class AccountTest {
    private InputStream inputStream;
    private SqlSession session;
    private IAccountDao accountDao;

    /**
     * 初始化SqlSessiont和IAccountDao实例
     * @throws IOException
     */
    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession();
        accountDao = session.getMapper(IAccountDao.class);
    }

    /**
     * 释放资源
     * @throws IOException
     */
    @After
    public  void  destroy() throws IOException {
        session.commit();
        session.close();
        inputStream.close();
    }

    @Test
    public  void  testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for(Account account :accounts){
            System.out.println("------------------------------");
            System.out.println(account);
            System.out.println(account.getFundInfos());
        }
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void testFindById(){
        Account account = accountDao.findById(8);
        System.out.println(account);

        Account account2 = accountDao.findById(8);
        System.out.println(account2);

        System.out.println(account==account2);
    }

    @Test
    public void testFindByName(){
        List<Account> accounts = accountDao.findByName("张");
        for(Account account :accounts){
            System.out.println(account);
        }
    }
}
