<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2017-09-22
  Time: 오후 2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Integer cnt = (Integer)session.getAttribute("cnt");
        if(cnt==null){
            out.println("최초 호출");
            cnt = 0;
        }
        session.setAttribute("cnt", ++cnt);
    %>
<h1>cnt is <%=cnt%></h1>
<br>
<%= request.getHeader("Cookie")%>
</body>
</html>
