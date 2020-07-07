package com.fengfang.dao;

import com.fengfang.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/6 16:01
 **/
@CacheNamespace(blocking = true)    //配置使用二级缓存
public interface IAccountDao {
    /**
     * 查询所有用户数据
     * 若实体的属性名称和数据库字段不一致，方法有两种：
     * 1、在查询SQL语句中使用别名
     * 2、使用@Results注解
     * 3、若有一对多的关系，则在Result里面，使用many属性，如下面代码所示，并建议使用延迟加载
     * @return
     */
//    @Select("select id as userid,username,sex as usersex,birthday as userbirthday,address as useraddress from account")
    @Select("select * from account")
    @Results(id="accountMap",value = {
            @Result(id=true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(column = "address",property = "userAddress"),
            @Result(property = "fundInfos",column = "id",many = @Many(select="com.fengfang.dao.IFundInfoDao.findByAccountId",fetchType = FetchType.LAZY))
    })
    public List<Account> findAll();

    /**
     * 根据用户Id查询用户数据
     * @param id
     * @return
     */
    @ResultMap("accountMap")
    @Select("select * from account where id=#{id}")
    public Account findById(Integer id);

    /**
     * 根据用户名模糊查询数据
     * 使用通过的参数点位符
     * @param username
     * @return
     */
    @Select("select * from account where username like '%${value}%'")
    @ResultMap("accountMap")
    public List<Account> findByName(String username);
}
