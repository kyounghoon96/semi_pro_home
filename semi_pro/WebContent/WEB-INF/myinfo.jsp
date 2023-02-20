<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link href="<%=request.getContextPath()%>/resources/css/myinfo.css" rel="stylesheet">
</head>
<body>
<form>
<div class="myinfo-maindiv">
	<fieldset class="field-main">
		<legend class="myinfo-legend">내정보</legend>
			<div>
				<c:if test="${empty myinfo }">
					<script>
					alert("로그인 상태가 아닙니다.");
					location.href="<%=request.getContextPath() %>/login";
					</script>		
				</c:if>
				<c:if test="${not empty myinfo }">
					<div class="myinfo-div1">
						<label class="myinfo-label">아이디</label>
						<br>
						<label class="myinfo-label">비밀번호</label>
						<br> 
						<label class="myinfo-label">이메일</label>
						<br>  
						<label class="myinfo-label">전화번호</label>
						<br>  
						<label class="myinfo-label">이름</label>
						<br>  		
						<label class="myinfo-label">성별</label>
						<br> 
						<label class="myinfo-label">생년월일</label>
						<br>  
						<label class="myinfo-label">주소</label>
					</div>
					<div class="myinfo-div2">
						<input type="text" value="${myinfo.id }"><p></p>
						<input type="text" value="${myinfo.pw }"><p></p>
						<input type="text" value="${myinfo.email }"><p></p>
						<input type="text" value="${myinfo.phone }"><p></p>
						<input type="text" value="${myinfo.user_name }"><p></p>
						<input type="text" value="${myinfo.gender }"><p></p>
						<input type="text" value="${myinfo.birth }"><p></p>
						<input type="text" id="input-address" value="${myinfo.address }">
					</div>		
				</c:if>			
			</div>
		</fieldset>
		<div class="myinfo-href">
			<a href="<%=request.getContextPath() %>/" onclick="gomain()">메인으로 이동</a>
		</div>
	</div>		
</form>
	<script>	
	function gomain(){
		alert("메인페이지로 이동합니다.");
	}
	</script>	
</body>
</html>