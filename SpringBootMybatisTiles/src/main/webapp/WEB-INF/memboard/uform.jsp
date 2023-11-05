<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gaegu:wght@300&family=Nanum+Pen+Script&family=Sunflower:wght@300&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<div style="margin: 50px 100px">
	<form action="update" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${dto.num }">
		<table class="table table-bordered" style="width: 500px">
			<caption align="top">
				<b>회원전용 글쓰기</b>
			</caption>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" class="form-control"
					required="required" autofocus="autofocus" value="${dto.subject }"></td>
			</tr>

			<tr>
				<th>파일업로드</th>
				<td><input type="file" name="upload" class="form-control">
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
				<textarea style="width:490px; height:150px" name="content" class="form-control" required="required">${dto.content }</textarea>
				</td>
			</tr>
			
			<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-outline-info">수정</button>
				<button type="button" class="btn btn-outline-success" onclick="location.href='list'">목록</button>
			</td>
		</table>
	</form>
	</div>
</body>
</html>