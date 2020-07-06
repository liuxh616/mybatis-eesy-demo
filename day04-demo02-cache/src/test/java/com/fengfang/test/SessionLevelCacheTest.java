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
 * @Date 2020/7/6 14:07
 **/
public class SessionLevelCacheTest {
    private InputStream inputStream ;
    private SqlSession session;
    private SqlSessionFactory factory;
    private IAccountDao accountDao;
    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @After
    public void  destroy() throws IOException {
        inputStream.close();
    }

    @Test
    public void  testFirstLevelCache(){
        SqlSession session = factory.openSession();
        IAccountDao accountDao1 = session.getMapper(IAccountDao.class);
        Account account1 = accountDao1.findById(8);
        System.out.println(account1);
        session.close();
        System.out.println("----------------------------------");
        SqlSession session2 = factory.openSession();
        IAccountDao accountDao2 = session2.getMapper(IAccountDao.class);
        Account account2 = accountDao2.findById(8);
        System.out.println(account2);
        session2.close();
        System.out.println(account1==account2);

    }

}
