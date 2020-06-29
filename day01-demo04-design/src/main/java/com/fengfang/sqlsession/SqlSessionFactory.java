package com.fengfang.sqlsession;

/**
 * TODO
 *
 * @author liuxh
 * @date 2020/6/28 23:00
 **/
public interface SqlSessionFactory {
    /**
     * 用于打开一个新的SqlSessiong对象
     * @return
     */
    SqlSession openSession();
}
