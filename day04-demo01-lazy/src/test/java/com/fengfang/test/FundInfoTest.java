package com.fengfang.test;

import com.fengfang.dao.IAccountDao;
import com.fengfang.dao.IFundInfoDao;
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
 * @Date 2020/7/6 10:20
 **/
public class FundInfoTest {
    private InputStream inputStream;
    SqlSession session;
    IFundInfoDao fundInfoDao;
    @Before
    public void  init() throws IOException {
        inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession();
        fundInfoDao = session.getMapper(IFundInfoDao.class);

    }

    @After
    public void destroy() throws IOException {
        session.commit();;
        session.close();
        inputStream.close();
    }

    @Test
    public void testFindAll(){
        List<Fundinfo> fundinfos = fundInfoDao.findAll();

    }

    @Test
    public void testFindByUid(){
        List<Fundinfo> fundinfos = fundInfoDao.findByUid(8);
        for(Fundinfo fundinfo :fundinfos){
            System.out.println(fundinfo);
        }
    }
}
