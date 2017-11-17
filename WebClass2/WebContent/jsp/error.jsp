<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2017-10-24
  Time: 오전 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<h1>Exception: ${ error }</h1>
<button onclick="history.back();">뒤로</button>
</body>
</html>
