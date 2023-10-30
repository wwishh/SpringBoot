<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu:wght@700&family=Nanum+Pen+Script&family=Single+Day&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<c:set var="root" value="<%=request.getContextPath()%>" />
	
	
	<!-- 로그인 안하면 기본사진, 로그인 하면 자기사진으로 변경 -->
	<c:if test="${sessionScope.loginok==null }">
	<a href="${root }/"><img src="${root }/image/logo.png"
		style="width: 200px; height: 150px;"></a>
	</c:if>
	
	<c:if test="${sessionScope.loginok!=null }">
	<a href="${root }/"><img src="${root }/membersave/${sessionScope.loginphoto}"
		style="width: 200px; height: 150px;"></a>
	</c:if>
	

	<c:if test="${sessionScope.loginok==null }">
		<br><br><button type="button" class="btn btn-outline-success"
			onclick="location.href='${root}/login/main'">login</button>
	</c:if>
	
	<c:if test="${sessionScope.loginok!=null }">
		<br><br><b>${sessionScope.myid }님이 로그인 중</b>
		<button type="button" class="btn btn-outline-danger"
			onclick="location.href='${root}/login/logoutprocess'">logout</button>
	</c:if>

</body>
</html>