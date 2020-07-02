<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.fengfang.dao.IAccountDao" %>
<%@ page import="com.fengfang.domain.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pc7
  Date: 2020/7/2
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Hello world</h3>
<%
    //读取配置文件
    InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    //创建SqlSessionFactory
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
    //创建SqlSession
    SqlSession session1 = factory.openSession();
    //创建代理理
    IAccountDao accountDao = session1.getMapper(IAccountDao.class);
    //调用方法查询数据
    List<Account> accounts = accountDao.findAll();
    for(Account account :accounts){
        System.out.println(account);
    }
    //释放资源
    session1.close();
    inputStream.close();
%>
</body>
</html>
