<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gaegu:wght@300&family=Nanum+Pen+Script&family=Sunflower:wght@300&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
h3{
position: absolute;
top:100px;
left:180px;
width:600px;
}

.add{
position: absolute;
top:200px;
left:200px;
}
a{
text-decoration: none;
color: white;
}
</style>
</head>
<body>
<h3 class="alert alert-info">${totalcount }개의 영화가 있습니다</h3>

<button type="button" class="btn btn-outline-success add" 
				onclick="location.href='writeform'">영화추가</button>
				
<div style="margin:200px 200px;">

	<table class="table table-dark" style="width:400px;">
		<tr align="center" valign="middle">
			<th>번호</th>
			<th>제목</th>
			<th>포스터</th>
			<th>감독</th>
			<th>개봉일</th>
		</tr>
		<c:forEach var="dto" items="${list }" varStatus="i">
			<tr align="center" valign="middle">
				<td>${i.count }</td>
				<td>
				<a href="detail?num=${dto.num }">${dto.title }</a>
				</td>
				<td><img src="../moviephoto/${dto.poster }" style="width:100px; height:100px;"></td>
				<td>${dto.director }</td>
				<td>${dto.opendate }</td>
			</tr>
		</c:forEach>
		
		
		
	</table>
	
</div>
</body>
</html>