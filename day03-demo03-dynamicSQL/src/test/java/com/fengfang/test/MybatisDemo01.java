package com.fengfang.test;

import com.fengfang.dao.IAccountDao;
import com.fengfang.domain.Account;
import com.fengfang.domain.QueryVo;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/1 9:55
 **/
public class MybatisDemo01 {
    private IAccountDao accountDao ;
    private SqlSession session;
    private InputStream inputStream;
    @Before
    public void init() throws IOException {
        //读取配置文件
        inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession
        session = factory.openSession();
        //创建代理类
        accountDao = session.getMapper(IAccountDao.class);

    }
    @After
    public void closeMethod() throws IOException{
        session.commit();
        //释放资源
        session.close();
        inputStream.close();
    }
    /**
     * 入门案例测试
     */
    @Test
    public void testFindAll() {
        //调用方法查询数据
        List<Account> accounts = accountDao.findAll();
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
        Date birthday = formatter.parse("1981-12-18", pos);
        Account account = new Account();
        account.setUsername("李先生");
        account.setBirthday(birthday);
        account.setSex("男");
        account.setAddress("东莞万江");
        System.out.println("保存操作之前："+account);
        //调用保存方法保存数据
        accountDao.saveAccount(account);
        System.out.println("保存操作之后："+account);



    }

    @Test
    public void updateAccount(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date birthday = formatter.parse("1987-12-17", pos);
        Account account = new Account();
        account.setId(12);
        account.setUsername("张小妹update");
        account.setBirthday(birthday);
        account.setSex("女");
        account.setAddress("北京通州update");
        //调用保存方法保存数据
        accountDao.updateAccount(account);
    }

    /**
     * 测试删除用户数据
     */
    @Test
    public void testDeleteAccount(){
        //执行删除方法
        accountDao.deleteAccount(9);
    }

    /**
     * 根据用户ID查询用户数据
     */
    @Test
    public void testFindAccountById(){
        Account account = accountDao.findById(9);
        System.out.println(account);
    }

    /**
     * 获取模糊查询用户
     */
    @Test
    public void testFindByName(){
        List<Account> accounts = accountDao.findByName("%张%");
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
        Integer count = accountDao.findAccountCount();
        System.out.println("Account总记录数为："+count.toString());
    }

    /**
     * 根据QueryVO对象来作为条件查询用户数据
     */
    @Test
    public void testFindByVO(){
        QueryVo queryVo = new QueryVo();
        Account account = new Account();
        account.setUsername("%张%");
        queryVo.setAccount(account);
        List<Account> accounts = accountDao.findAccountByVO(queryVo);
//        List<Account> accounts = accountDao.findByName("王");
        for(Account tempAccount :accounts){
            System.out.println(tempAccount);
        }
    }

    @Test
    public void testFindAccountBycon(){
        Account account = new Account();
//        account.setAddress("%广州%");
        account.setUsername("%张%");
        List<Account> accounts = accountDao.findAccountByCondition(account);
        for(Account tempAccount :accounts){
            System.out.println(tempAccount);
        }
    }

    @Test
    public void testFindAccountByIds(){
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(6);
//        vo.setIds(new List<Integer>(){1,2,3});
        vo.setIds(list);
        List<Account> accounts = accountDao.findAccountInIds(vo);
        for(Account tempAccount :accounts){
            System.out.println(tempAccount);
        }

    }
}
