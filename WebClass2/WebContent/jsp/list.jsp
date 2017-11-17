<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2017-10-27
  Time: 오전 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
        <tr>
            <th>#</th>
            <th>id</th>
            <th>name</th>
            <th>nickname</th>
        </tr>
    </thead>
    <tbody>
    <c:if test="${list!=null}">
        <c:forEach var="item" items="${list}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.nickname}</td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>
