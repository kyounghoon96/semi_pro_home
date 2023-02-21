<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 추가</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/boardadd" method="post" >
		제목 : <input type="text" name="title">
		<br>
		작성자: <input type="text" name="writer">
		<br>
		내용 : <input type="text" name="content">
		<br>
		<button type="submit">추가하기</button>	
	</form>

</body>
</html>