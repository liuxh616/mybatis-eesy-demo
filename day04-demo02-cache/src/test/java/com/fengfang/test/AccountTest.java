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
 * @Date 2020/7/6 11:32
 **/
public class AccountTest {
    private InputStream inputStream ;
    private SqlSession session;
    private SqlSessionFactory factory;
    private IAccountDao accountDao;
    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession();
        accountDao = session.getMapper(IAccountDao.class);
    }

    @After
    public void  destroy() throws IOException {
        session.commit();
        session.close();
        inputStream.close();
    }

    @Test
    public void  testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for(Account account :accounts){
            System.out.println(account);
        }
    }

    /**
     * 测试一级缓存的案例，若打开注释代码，则两个实例对象不一致，
     * 若不打开则两个实例是用了缓存的，即是一致的
     */
    @Test
    public void testCache(){
        Account account = accountDao.findById(8);
        System.out.println(account);
//        session.close();
        //此方法也可以清空缓存
//        session.clearCache();
        System.out.println("-------------------------");
        //再次获取session对象
//        session = factory.openSession();
//        accountDao = session.getMapper(IAccountDao.class);
        Account account2 = accountDao.findById(8);
        System.out.println(account2);
        System.out.println("-------------------------");
        System.out.println(account==account2);
    }

    /**
     * 测试一级缓存案例
     * 若使用了更新代码，则会使一级缓存失效，以下两实例即是不一致的
     */
    @Test
    public void  testClearCache(){
        //先根据id去查询用户
        Account account = accountDao.findById(8);
        System.out.println(account);
        //更新用户数据
        account.setUsername("update user cache");
        account.setSex(account.getSex());
        account.setBirthday(account.getBirthday());
        account.setAddress("北京三环");
        accountDao.updateAccount(account);
        System.out.println("---------------------------");

        Account account2 = accountDao.findById(8);
        System.out.println(account2);
        System.out.println(account==account2);
    }
}
