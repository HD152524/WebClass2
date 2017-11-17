<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2017-09-21
  Time: 오후 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding ="utf-8" language="java" %>
<%
    Calendar c = Calendar.getInstance();
%>
<footer class="footer">
    <div class="container">
        <span class="text-muted">@<%= c.get(Calendar.YEAR)%> mycompany.com</span>
    </div>
</footer>
