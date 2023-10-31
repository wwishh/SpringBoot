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
<style type="text/css">
ul.menu {
	list-style: none;
}

ul.menu li {
	width: 80px;
	height: 30px;
	float: left;
	line-height: 60px;
	text-align: center;
	margin-right: 10px;
	font-size: 22px;
	font-family: 'Dongle';
	cursor: pointer;
}

ul.menu li a {
	text-decoration: none;
	color: black;
}
</style>
</head>
<c:set var="root" value="<%=request.getContextPath()%>" />
<body>
	<ul class="menu">

		<c:if test="${sessionScope.loginok!=null }">
			<li>
			<img alt="" src="image/마스터볼.png" style="width:100px">
			<a href="${root }/member/myinfo?id=${sessionScope.myid}"><b style="font-size: 50px; color: white; margin-right: 15px">MYINFO</b></a>
			</li>
		</c:if>
		
		<c:if test="${sessionScope.loginok==null }">
			<li>
			<img alt="" src="image/마스터볼.png" style="width:100px">
			<a href="${root }/login/main"><b style="font-size: 50px; color: white; margin-right: 15px">MYINFO</b></a>
			</li>
		</c:if>


		<li>
		<img alt="" src="image/하이퍼볼.png" style="width:100px">
		<a href="${root }/member/list"><b style="font-size: 50px; color: white; margin-right: 15px">MEMBER</b></a></li>

		<li>
		<img alt="" src="image/슈퍼볼.png" style="width:100px">
		<a href="${root }/login/gaip"><b style="font-size: 50px; color: white; margin-right: 15px">SIGN UP</b></a></li>

		<li>
		<img alt="" src="image/몬스터볼.png" style="width:100px">
		<a href="${root }/login/main"><b style="font-size: 50px; color: white; margin-right: 15px">SIGN IN</b></a></li>

	</ul>
</body>
</html>