<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2017-11-13
  Time: 오후 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JDBC Connection Test</h1>
<%
    Connection conn = null;
    Statement stmt = null;
    try{
        String url="jdbc:mysql://localhost:3306/webclass";
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(url,"root","root");
        stmt = conn.createStatement();
        out.println("Database Successfully opened.");
    }catch(Exception e ){
        out.println(e.getMessage()) ;
    }finally{
        if(stmt!=null) stmt.close();
        if(conn!=null) conn.close();
    }
%>
</body>
</html>
