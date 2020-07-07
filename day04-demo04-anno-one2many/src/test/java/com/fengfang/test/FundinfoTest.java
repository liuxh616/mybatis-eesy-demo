package com.fengfang.test;

import com.fengfang.dao.IAccountDao;
import com.fengfang.dao.IFundInfoDao;
import com.fengfang.domain.Account;
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
 * @Date 2020/7/7 9:19
 **/
public class FundinfoTest {
    private InputStream inputStream;
    private SqlSession session;
    private IFundInfoDao fundInfoDao;

    /**
     * 初始化SqlSessiont和IAccountDao实例
     * @throws IOException
     */
    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession();
        fundInfoDao = session.getMapper(IFundInfoDao.class);
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
        List<FundInfo> fundInfos = fundInfoDao.findAll();
        for(FundInfo fundInfo :fundInfos){
            System.out.println("每个账户的信息：");
            System.out.println(fundInfo);
            System.out.println(fundInfo.getAccount());
        }
    }
}
