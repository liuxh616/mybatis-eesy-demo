package com.fengfang.test;

import com.fengfang.dao.IAccountDao;
import com.fengfang.domain.Account;
import com.fengfang.domain.Fundinfo;
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
 * @Date 2020/7/6 9:49
 **/
public class AccountTest {
    private  InputStream inputStream;
    SqlSession session;
    IAccountDao accountDao;
    @Before
    public void  init() throws IOException {
        inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession();
        accountDao = session.getMapper(IAccountDao.class);

    }

    @After
    public void destroy() throws IOException {
        session.commit();;
        session.close();
        inputStream.close();
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        //若没有获取账户明细时，是不会再查询的，即延迟加载
//        for(Account account :accounts){
//            System.out.println(account);
//            System.out.println(account.getFundinfos());
//        }

    }

    @Test
    public void testFindById(){
        Account account = accountDao.findById(2);
        System.out.println(account);

    }
}
