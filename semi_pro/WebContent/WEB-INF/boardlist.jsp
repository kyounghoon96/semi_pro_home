<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
</head>
<body>
	<h1>게시글</h1>
	<table>
		<tr>
			<td>글번호</td>
			<td>글제목</td>
			<td>작성자</td>
			<td>작성시간</td>	
		</tr>	
		<c:forEach items="${boardlist }" var="vo" >
			<tr>
				<td>${vo.boardNum }</td>
				<td><a href="<%=request.getContextPath() %>/boardtext">${vo.boardTitle }</a></td>
				<td>${vo.boardWriter }</td>
				<td>${vo.boardDate }</td>
			</tr>
		</c:forEach>		
	</table>
	<button onclick="location.href='<%=request.getContextPath()%>/boardadd'">글 추가하기</button>
	<br>
	<button onclick="location.href='<%=request.getContextPath()%>/boardupdate'">글 수정하기</button>			
	<script>
	$(".btn.add").on("click", btnadd)
	function btnadd(){
		alert("글작성 페이지로 이동합니다.");
		location.href="<%=request.getContextPath() %>/boardadd";	
	}	
	</script>
	
	
</body>
</html>