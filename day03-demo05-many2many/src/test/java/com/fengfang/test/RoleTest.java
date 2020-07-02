package com.fengfang.test;

import com.fengfang.dao.IAccountDao;
import com.fengfang.dao.IRoleDao;
import com.fengfang.domain.Account;
import com.fengfang.domain.Role;
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
 * @Date 2020/7/2 11:51
 **/
public class RoleTest {
    private InputStream inputStream;
    private SqlSession session;
    private IRoleDao roleDao;
    @Before
    public void  init() throws IOException {
        inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession();
        roleDao = session.getMapper(IRoleDao.class);
    }

    @After
    public void close() throws IOException {
        session.commit();
        inputStream.close();
        session.close();
    }

    @Test
    public void testFindAll(){
        List<Role> roles = roleDao.findAll();
        for(Role role:roles){
            System.out.println("-------每个角色的信息----------");
            System.out.println(role);
            List<Account> accounts = role.getAccounts();
            for(Account account :accounts){
                System.out.println(account);
            }
        }
    }


}
