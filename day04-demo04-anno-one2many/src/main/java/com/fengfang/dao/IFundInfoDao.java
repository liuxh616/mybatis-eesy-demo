package com.fengfang.dao;

import com.fengfang.domain.FundInfo;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/7 9:18
 **/
public interface IFundInfoDao {

    /**
     * 查询所有账户，并获取每个账户的用户信息
     * @return
     */
    @Select("select * from fundinfo")
    @Results(id="fundInfoMap", value={
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "accountid",column = "accountid"),
            @Result(property = "aviMoney",column = "aviMoney"),
            @Result(property = "rechargeMoney",column = "rechargeMoney"),
            @Result(property = "account",column = "accountid",one=@One(select="com.fengfang.dao.IAccountDao.findById",fetchType = FetchType.EAGER))
    })
    public List<FundInfo> findAll();

    /**
     * 根据用户ID获取账户信息
     * @param accountid
     * @return
     */
    @Select("select * from fundInfo where accountid=#{id}")
    public List<FundInfo> findByAccountId(Integer accountid);

}
