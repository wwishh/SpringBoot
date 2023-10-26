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
.box{

}
</style>
</head>
<body>
<h3 class="alert alert-primary">등록 영화 정보</h3>
<table class="table table-bordered" style="width:800px;">
<tr>
	<td width="350" rowspan="4">
	<img alt="" src="../moviephoto/${dto.poster }" style="width:400px; height:300px;">
	</td>
<tr>
	<td>
	영화명 : ${dto.title }
	</td>
</tr>
<tr>
	<td>
	감독명 : ${dto.director }
	</td>
<tr>
	<td>
	개봉일: ${dto.opendate }
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<button type="button" class="btn btn-outline-danger" onclick="location.href=''">수정</button>
		<button type="button" class="btn btn-outline-warning" onclick="location.href=''">삭제</button>
		<button type="button" class="btn btn-outline-success" onclick="location.href='writeform'">등록</button>
		<button type="button" class="btn btn-outline-primary" onclick="location.href='list'">목록</button>
	</td>
</tr>


</table>
</body>
</html>