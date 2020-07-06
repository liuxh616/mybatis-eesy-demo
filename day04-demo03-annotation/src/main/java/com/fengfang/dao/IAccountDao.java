package com.fengfang.dao;

import com.fengfang.domain.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 在mybatis中针对CRUD，一共有四个注解
 * @Select @Insert @Update @Delete
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/6 14:44
 **/
public interface IAccountDao {
    /**
     * 查询所有用户数据
     * @return
     */
    @Select("select * from account")
    public List<Account> findAll();

    /**
     * 插入用户资料方法
     * @param account
     */
    @Insert("insert into account(username,sex,birthday,address) values(#{username},#{sex},#{birthday},#{address})")
    public void saveAccount(Account account);

    /**
     * 更新用户方法
     * @param account
     */
    @Update("update account set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where id=#{id}")
    public void updateAccount(Account account);

    /**
     * 删除用户数据方法
     * @param id
     */
    @Delete("delete from account where id=#{id}")
    public void deleteAccount(Integer id);

    /**
     * 根据Id 查询用户数据
     * @param id
     * @return
     */
    @Select("select * from account where id=#{id}")
    public Account findById(Integer id);
}
