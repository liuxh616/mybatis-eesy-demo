package com.fengfang.dao;

import com.fengfang.domain.Role;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/2 11:49
 **/
public interface IRoleDao {

    public List<Role> findAll();
}
