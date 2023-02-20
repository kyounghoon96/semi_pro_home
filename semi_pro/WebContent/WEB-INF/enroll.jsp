<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<section>
	<h1>회원가입</h1>
		<form action="<%=request.getContextPath()%>/enroll" method="post">
			id:<input type="text" name="id"> 
			<br>
			pw:<input type="password" name="pw">
			<br>
			email:<input type="text" name="email">
			<br>
			user_name:<input type="text" name="user_name">
			<br>
			phone:<input type="text" name="phone">
			<br>
			gender:<input type="text" name="gender">
			<br>
			birth:<input type="text" name="birth">
			<br>
			address:<input type="text" name="address">
			<br>
			<button type="submit" class="btn enroll">회원가입</button>
		</form>	
	</section>
</body>
</html>