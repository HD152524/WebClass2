<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>SignUp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<link rel="stylesheet" href="../css/signin.css">
</head>
<body>
<div class="container">
  <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  <form id="signupForm" class="form-signin" action="${contextPath}/signup.do" method="post">
    <h2 class="form-signin-heading">Please sign up</h2>
    
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="email" name="id" id="inputEmail" class="form-control" placeholder="Email address" value="${param.id}" required autofocus>
    
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" name="pwd" id="inputPassword" class="form-control" placeholder="Password" value="${param.pwd}" required>
	
	<label for="inputName" class="sr-only">Name</label>
    <input type="text" name="name" id="inputName" class="form-control" placeholder="Name" value="${param.name}" required>
	
	<label for="inputNickName" class="sr-only">Nick Name</label>
    <input type="text" name="nickname" id="inputNickName" class="form-control" placeholder="Nickname" value="${param.nickname}" required>
    <br>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
  </form>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

<%@ include file="modal.jsp" %>
<C:if test="${error!=null}">
<script>
    <%-- 로그인이 실패한 경우 처리 추가 --%>

    var myModal = $('#mymodal');
    myModal.find('.modal-title').text('Sign Up Error');
    myModal.find('.modal-body').text('회원가입시 오류가 발생하였습니다.');
    myModal.modal();
</script>
</C:if>

<script>
	<%-- 회원 가입이 실패한 경우 처리 추가 --%>
	<%--
		var myModal = $('#myModal');
		myModal.find('.modal-title').text('Sign Up Error');
		myModal.find('.modal-body').text('회원 가입 시 오류가 발생하였습니다.');
		myModal.modal();
	--%>
</script>

</body>
</html>