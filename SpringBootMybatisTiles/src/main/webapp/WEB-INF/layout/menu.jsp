<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
	ul.menu{
		list-style: none;
	}
	ul.menu li{
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
	.season{
		margin-left: 15px;
	}
	ul.menu li a{
		text-decoration: none;
		color: black;
	}
</style>
</head>
<c:set var="root" value="<%=request.getContextPath() %>"/>
<body>
	<ul class="menu">
		
		<li>
		
			<a href="${root }/ipgo/ipgoform"><b style="font-size: 50px; color: blue; margin-left: 15px"><img alt="" src="image/몬스터볼.png" style="width:100px">ADD</b></a>
		</li>
		
		<li>
		
			<a href="${root }/ipgo/list"><b style="font-size: 50px; color: blue; margin-left: 15px"><img alt="" src="image/슈퍼볼.png" style="width:100px">SHOP</b></a>
		</li>
		
		<li>
		
			<a href="${root }/smart/list"><b style="font-size: 50px; color: blue; margin-left: 15px"><img alt="" src="image/하이퍼볼.png" style="width:100px">SMARTSHOP</b></a>
		</li>
		
		<li class="season">
		
			<a href="${root }/reboard/list"><b style="font-size: 50px; color: red; margin-left: 15px"><img alt="" src="image/마스터볼.png" style="width:100px">REBOARD</b></a>
		</li>

	</ul>
</body>
</html>