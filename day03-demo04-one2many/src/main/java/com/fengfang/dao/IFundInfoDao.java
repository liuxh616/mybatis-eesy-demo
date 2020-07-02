package com.fengfang.dao;

import com.fengfang.domain.FundInfo;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/2 10:08
 **/
public interface IFundInfoDao  {
    /**
     * 查找所有账户信息
     * @return
     */
    List<FundInfo> findAll();
}
