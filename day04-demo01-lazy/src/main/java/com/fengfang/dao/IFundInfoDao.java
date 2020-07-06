package com.fengfang.dao;

import com.fengfang.domain.Fundinfo;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/6 10:16
 **/
public interface IFundInfoDao {

    public List<Fundinfo> findAll();

    /**
     * 根据用户Id查询所甩账户列表
     * @param accountid
     * @return
     */
    public List<Fundinfo> findByUid(Integer accountid);
}
