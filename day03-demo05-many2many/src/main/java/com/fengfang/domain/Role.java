package com.fengfang.domain;

import sun.management.counter.AbstractCounter;

import java.io.Serializable;
import java.util.List;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/7/2 11:47
 **/
public class Role implements Serializable {
    private Integer roleId;
    private String  roleName;
    private String roleDesc;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    //多对多的关系映射，一个角色可以有多个用户
    private List<Account> accounts;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}
