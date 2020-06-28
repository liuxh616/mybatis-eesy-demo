package com.fengfang.sqlsession;

/**
 * TODO
 * 自定义mybatis中和数据库交互的核心类
 * 它里面可以创建dao接口的代理对象
 * @author liuxh
 * @date 2020/6/28 23:01
 **/
public interface SqlSession {
    <T> T getMapper(Class<T> daoInterFaceClass);
    void close();
}
