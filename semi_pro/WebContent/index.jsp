<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link href="<%=request.getContextPath()%>/resources/css/index.css" rel="stylesheet">
</head>
<body>
	<div class="main-div">
	<div class="header-div">	
	<h1>게시판</h1>
	
	
	</div>	
	<jsp:include page="/WEB-INF/header.jsp"/>	
	<c:if test="${not empty lgnss}">
		<button class="btn myinfo">내정보보기</button>
		<br>
		<button class="btn board">게시판으로 이동</button>
	</c:if>
	
	<script>
	$(".btn.login").on("click", BtnLogin);
	$(".btn.logout").on("click", BtnLogout);
	$(".btn.myinfo").on("click", BtnMyinfo);
	$(".btn.board").on("click", BtnBoard);
	
	function BtnLogin(){
		alert("로그인 페이지로 이동")
		location.href="<%=request.getContextPath()%>/login";
	}
	function BtnLogout(){
		alert("로그아웃");
		location.href="<%=request.getContextPath()%>/logout";
	}

	function BtnMyinfo(){
		alert("내정보 페이지로 이동");
		location.href="<%=request.getContextPath()%>/myinfo";
	}
	function BtnBoard(){
		alert("게시판으로 이동");
		location.href="<%=request.getContextPath()%>/boardlist";
	}
	</script>
	</div>
</body>
</html>