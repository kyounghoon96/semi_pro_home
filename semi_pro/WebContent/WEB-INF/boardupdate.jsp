<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/boardupdate" method="post">
		제목 : <input type="text" name="title">
		<br>
		작성자: <input type="text" name="writer">
		<br>
		내용: <input type="text" name="content">
		<br>
		<button type="submit">수정하기</button>	
	</form>
</body>
</html>