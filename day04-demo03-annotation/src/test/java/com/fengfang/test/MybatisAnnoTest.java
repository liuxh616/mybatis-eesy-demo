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
 * @Date 2020/7/6 14:56
 **/
public class MybatisAnnoTest {
    /**
     * 测试基于注解的mybatis的使用
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //1、获取输入字节流
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2、根据字节流获取一个SqlSession
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //3、使用SsqlSession获取Dao的代理对象
        IAccountDao accountDao = session.getMapper(IAccountDao.class);
        //4、执行Dao的方法
        List<Account> accounts = accountDao.findAll();
        for(Account account :accounts){
            System.out.println(account);
        }
        //5、释放资源
        session.close();
        inputStream.close();
    }
}
