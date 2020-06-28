package com.fengfang.test;

import com.fengfang.dao.IAccountDao;
import com.fengfang.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/6/28 16:45
 **/
public class MybatisDemo02 {
    /**
     * 入门案例测试
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
        //创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession
        SqlSession session = factory.openSession();
        //创建代理理
        IAccountDao accountDao = session.getMapper(IAccountDao.class);
        //调用方法查询数据
        List<Account> accounts = accountDao.findAll();
        for(Account account :accounts){
            System.out.println(account);
        }
        //释放资源
        session.close();
        inputStream.close();
    }
}
