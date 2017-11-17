<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2017-10-23
  Time: 오후 2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/WebClass/scope" method="post">
        <input type="text" name="id">
        <input type="hidden" name="pwd" value="test">
        <button type="submit">전송</button>
    </form>
    <script>
        <%
        String error = (String) request.getAttribute("error");
        if(error!=null){
        %>
        alert('<%=error%>');
        <%
        }
        %>
    </script>
    <h1>id: <%= request.getParameter("id")%></h1>
    <h1>pwd: <%=request.getParameter("pwd")%></h1>
    <h1>get_attribute: <%=request.getAttribute("key")%></h1>
    <h1>sess_get_attribute: <%=session.getAttribute("key")%></h1>
    <h1>application_get_attribute: <%=application.getAttribute("key")%></h1>

    <h1>id: ${param.id}</h1>
    <h1>pwd: ${param.pwd}</h1>
    <h1>get_attribute: ${requestScope.key}</h1> <!-- 그냥 key도 가능}-->
    <h1>sess_get_attribute: ${sessionScope.key}</h1>
    <h1>application_get_attribute: ${applicationScope.key}</h1>


<hr>

<form action="/WebClass/jsp/scope2.jsp" method="post">
    <button type="submit">전송</button>
</form>
</body>
</html>
