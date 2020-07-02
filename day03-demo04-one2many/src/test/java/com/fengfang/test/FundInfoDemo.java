package com.fengfang.test;

import com.fengfang.dao.IFundInfoDao;
import com.fengfang.domain.FundInfo;
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
 * @Date 2020/7/2 10:10
 **/
public class FundInfoDemo {
    private InputStream inputStream;
    private SqlSession session;
    private IFundInfoDao fundInfoDao;
    @Before
    public void  init() throws IOException {
        inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession();
        fundInfoDao = session.getMapper(IFundInfoDao.class);
    }

    @After
    public void close() throws IOException {
        session.commit();
        inputStream.close();
        session.close();
    }

    @Test
    public void testFindAll(){
        List<FundInfo> accounts = fundInfoDao.findAll();
        for(FundInfo account :accounts){
            System.out.println(account);
            System.out.println(account.getAccount());
            System.out.println("---------------------");
        }
    }
}
