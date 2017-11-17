<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>숫자 합 계산</title>
</head>
<body>
<form>
    <input type="number" name="num" required>
    <button type="submit">계산</button>
</form>

<%
    String number = request.getParameter("num");
    int input=0;
    int ans = 0;
    if(number!=null)
    {
        input = Integer.parseInt(number);
        ans = input*(input+1)/2;
%>
<%-- 스크립틀릿 tag로 1~입력받은 숫자까지의 합 구하기 --%>
<%-- 결과 출력 시 변수 값은 표현식 tag로 작성하기 (jsp 파일 로딩시에는 보이지 않음) --%>
<h1>1~<%=input%>까지의 합은 <%=ans%>입니다. </h1>
<% }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");

%>
<p>현재 일시는 <%=sdf.format(new Date())%></p>
</body>
</html>