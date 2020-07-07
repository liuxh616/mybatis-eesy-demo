package com.fengfang.test;

import com.fengfang.dao.IAccountDao;
import com.fengfang.domain.Account;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/7 10:38
 **/
public class SecondLevelCacheTest {
    private InputStream inputStream;
    private SqlSession session;
    private  SqlSessionFactory factory;
    private IAccountDao accountDao;

    /**
     * 初始化SqlSessiont和IAccountDao实例
     * @throws IOException
     */
    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession();
        accountDao = session.getMapper(IAccountDao.class);
    }

    /**
     * 释放资源
     * @throws IOException
     */
    @After
    public  void  destroy() throws IOException {
        inputStream.close();
    }

    /**
     * 测试一级缓存释放
     */
    @Test
    public void testFindById(){
        Account account = accountDao.findById(8);
        System.out.println(account);
        session.close();   //释放一级缓存
//        session.clearCache();  //释放一级缓存另一种写法
        System.out.println("-----------------");
        SqlSession session = factory.openSession();
        accountDao = session.getMapper(IAccountDao.class);
        Account account2 = accountDao.findById(8);
        System.out.println(account2);

        System.out.println(account==account2);
    }

}
