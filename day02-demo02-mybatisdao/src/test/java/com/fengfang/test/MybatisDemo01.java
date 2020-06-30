package com.fengfang.test;

import com.fengfang.dao.IAccountDao;
import com.fengfang.dao.impl.AccountDaoImpl;
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
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/6/28 16:45
 * 1、根据配置文件的信息创建Connection对象，注册驱动
 * 2、获取预处理对象PreparedStatment，此时需要SQL 语句
 * 3、执行查询 ResultSet res = PreparedStatement.executeQuery();
 * 4、遍历结果集用于封装
 * 5、返回封装的list集合
 **/
public class MybatisDemo01 {
    private InputStream inputStream;
    private AccountDaoImpl accountDaoImpl ;
    @Before
    public void init() throws IOException{
        //读取配置文件
        inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
        //创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        accountDaoImpl = new AccountDaoImpl(factory);
        //创建SqlSession
//        session = factory.openSession();
//        //创建代理类
//        accountDao = session.getMapper(IAccountDao.class);

    }
    @After
    public void closeMethod() throws IOException{
//        session.commit();
//        //释放资源
//        session.close();
        inputStream.close();
    }
    /**
     * 入门案例测试
     */
    @Test
    public void testFindAll() {
        //调用方法查询数据
//        AccountDaoImpl accountDao = new AccountDaoImpl()
        List<Account> accounts = accountDaoImpl.findAll();
        for(Account account :accounts){
            System.out.println(account);
        }
    }

    /**
     *保存用户数据测试
     */
    @Test
    public void testSaveAccount(){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date birthday = formatter.parse("1983-12-18", pos);
       Account account = new Account();
       account.setUsername("张小妹dao");
       account.setBirthday(birthday);
       account.setSex("女");
       account.setAddress("北京通州dao");
        System.out.println("保存操作之前："+account);
        //调用保存方法保存数据
        accountDaoImpl.saveAccount(account);
        System.out.println("保存操作之后："+account);



    }

    @Test
    public void updateAccount(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date birthday = formatter.parse("1987-12-17", pos);
        Account account = new Account();
        account.setId(9);
        account.setUsername("张小妹dao");
        account.setBirthday(birthday);
        account.setSex("女");
        account.setAddress("北京通州dao");
        //调用保存方法保存数据
        Integer result = accountDaoImpl.updateAccount(account);
        System.out.println(result);
    }

    /**
     * 测试删除用户数据
     */
    @Test
    public void testDeleteAccount(){
        //执行删除方法
        accountDaoImpl.deleteAccount(10);
    }

    /**
     * 根据用户ID查询用户数据
     */
    @Test
    public void testFindAccountById(){
        Account account = accountDaoImpl.findById(9);
        System.out.println(account);
    }

    /**
     * 获取模糊查询用户
     */
    @Test
    public void testFindByName(){
        List<Account> accounts = accountDaoImpl.findByName("%张%");
//        List<Account> accounts = accountDao.findByName("王");
        for(Account account :accounts){
            System.out.println(account);
        }
    }

    /**
     * 测试获取所有记录行数
     */
    @Test
    public void testFindAllAccount(){
        Integer count = accountDaoImpl.findAccountCount();
        System.out.println("Account总记录数为："+count.toString());
    }



}
