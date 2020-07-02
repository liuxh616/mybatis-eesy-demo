package com.fengfang.test;

import com.fengfang.dao.IAccountDao;
import com.fengfang.domain.Account;
import com.fengfang.domain.AccountFundInfo;
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
import java.text.DecimalFormat;
import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/1 16:10
 **/
public class MybatisDemo {
    private InputStream inputStream;
    private SqlSession session;
    private IAccountDao accountDao;
    @Before
    public void  init() throws IOException {
        inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession();
        accountDao = session.getMapper(IAccountDao.class);
    }

    @After
    public void close() throws IOException {
        session.commit();
        inputStream.close();
        session.close();
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for(Account account :accounts){
            System.out.println(account);
            for(FundInfo fundInfo :account.getFundInfos()){
                System.out.println(fundInfo);
            }
            System.out.println("---------------------------");
        }
    }

    /**
     * 连表查询，返回自定义封装对象
     */
    @Test
    public void testFindAccountInfo(){
        List<AccountFundInfo> accounts = accountDao.findAccountInfo();
        DecimalFormat format = new DecimalFormat("##,##0.00");
        for(AccountFundInfo account :accounts){
            System.out.println(account);
            System.out.println("---------------------------");
            System.out.println(format.format(account.getAvimoney()));
            System.out.println("---------------------------");
            System.out.println(String.format("%.2f",account.getAvimoney()));
        }
    }


}
