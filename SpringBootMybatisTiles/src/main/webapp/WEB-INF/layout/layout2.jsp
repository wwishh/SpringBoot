<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
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
	div.layout div{
		border: 1px solid black;
	}
	div.layout div.title{
		position: absolute;
		top: 10px;
		left: 450px;
		height: 100px;
	}
	div.layout div.menu{
		position: absolute;
		top: 150px;
		left: 250px;
		height: 100px;
		width: 800px;
	}	
	div.layout div.main{
		position: absolute;
		top: 250px;
		left: 300px;
		height: 500px;
		font-size: 17px;
		width: 1000px;
	}
</style>
</head>
<body>
	<div class="layout">
		<div class="title">
			<tiles:insertAttribute name="title2"/>
		</div>
		<div class="menu">
			<tiles:insertAttribute name="menu2"/>
		</div>
		<div class="main">
			<tiles:insertAttribute name="main"/>
		</div>
	</div>
</body>
</html>