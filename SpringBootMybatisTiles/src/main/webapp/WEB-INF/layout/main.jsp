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
body{
	background-image: url("image/background.png");
	background-repeat: no-repeat;
	background-size: cover;
}
	.mainphoto{
		margin-left:80px;
		margin-top: 50px;
		width: 1300px;
		height: 800px;
	}
</style>
</head>
<c:set var="root" value="<%=request.getContextPath() %>"/>
<body>
	<div class="mainphoto">
		<a href="${root }/ipgo/list"><img src="${root }/image/main1.png" style="width: 250px; height: 400px;"></a>
		<a href="${root }/ipgo/list"><img src="${root }/image/main2.png" style="width: 250px; height: 400px;"></a>
		<a href="${root }/ipgo/list"><img src="${root }/image/오박사.png" style="width: 250px; height: 400px;"></a>
		<a href="${root }/ipgo/list"><img src="${root }/image/main3.png" style="width: 250px; height: 400px;"></a>
		<a href="${root }/ipgo/list"><img src="${root }/image/main4.png" style="width: 250px; height: 400px;"></a>
	</div>
</body>
</html>