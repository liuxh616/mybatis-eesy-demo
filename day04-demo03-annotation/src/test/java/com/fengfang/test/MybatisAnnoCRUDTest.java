package com.fengfang.test;

import com.fengfang.dao.IAccountDao;
import com.fengfang.domain.Account;
import javafx.scene.input.DataFormat;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.helpers.DateTimeDateFormat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/6 15:18
 **/
public class MybatisAnnoCRUDTest {

     private InputStream inputStream;
     private SqlSession session;
     private IAccountDao accountDao;

    /**
     * 初始化SqlSessiont和IAccountDao实例
     * @throws IOException
     */
     @Before
    public void init() throws IOException {
         inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
         SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
         session = factory.openSession();
         accountDao = session.getMapper(IAccountDao.class);
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
         List<Account> accounts = accountDao.findAll();
         for(Account account :accounts){
             System.out.println(account);
         }
     }

     @Test
    public void testSaveAccount(){
         Account account = new Account();
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
         ParsePosition pos = new ParsePosition(0);
         Date birthday = formatter.parse("1987-12-18", pos);
         account.setBirthday(birthday);
         account.setUsername("lxhannotation");
         account.setSex("男");
         account.setAddress("北京昌平区");
         accountDao.saveAccount(account);

     }

     @Test
    public void testUpdateAccount(){

         Account account = new Account();
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
         ParsePosition pos = new ParsePosition(0);
         Date birthday = formatter.parse("1983-01-28", pos);
         account.setId(14);
         account.setBirthday(birthday);
         account.setUsername("lxhannotation---update");
         account.setSex("男");
         account.setAddress("北京海淀区");
         accountDao.updateAccount(account);
     }

     @Test
    public void testDeleteAccount(){
         accountDao.deleteAccount(14);

     }

    /**
     * 测试根据ID查询用户数据
     */
    @Test
    public void testFindByID(){
        Account account =  accountDao.findById(13);
        System.out.println(account);
    }
}
