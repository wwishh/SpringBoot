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
</head>
<body>
	<div class="alert alert-primary" style="margin:200px 500px; width:450px;">
	<form action="insert" method="post" enctype="multipart/form-data">
	<table class="table table-striped" style="width:400px;">
		<tr align="center" valign="middle">
			<th>영화제목</th>
			<td>
				<input type="text" name="title" required="required" class="form-control" style="width:100px;">
			</td>
		</tr>
		<tr align="center" valign="middle">
			<th>포스터</th>
			<td>
				<input type="file" name="upload" required="required" class="form-control" style="width:100px;">
			</td>
		</tr>
		<tr align="center" valign="middle">
			<th>감독</th>
			<td>
				<input type="text" name="director" required="required" class="form-control" style="width:100px;">
			</td>
		</tr>
		<tr align="center" valign="middle">
			<th>개봉일</th>
			<td>
				<input type="date" name="opendate" required="required" class="form-control" style="width:100px;">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<button type="submit" class="btn btn-outline-danger">등록</button>
			<button type="button" class="btn btn-outline-warning" onclick="location.href='list'">리스트로 이동</button>
			</td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>