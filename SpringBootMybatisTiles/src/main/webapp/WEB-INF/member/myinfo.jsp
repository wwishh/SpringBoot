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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
#pho {
	width: 300px;
	height: 300px;
}


</style>

<script type="text/javascript">
	$(function() {
		$("#btnnewphoto").click(function() {
			$("#newphoto").trigger("click");
		});

		$("#newphoto").change(function() {
			var num = $(this).attr("num");
			console.log(num);

			var form = new FormData();
			form.append("photo", $(this)[0].files[0]); //선택한 1개만 추가
			form.append("num", num);

			console.dir(form);

			$.ajax({
				type : "post",
				dataType : "html",
				url : "updatephoto",
				processData : false, //FormData를 사용할 때 설정해주는 거임 (사진을 ajax로 사용할 때)  
				contentType : false,
				data : form,
				success : function() {
					location.reload();
				}
			})
		});
		
		$("#deleteajax").click(function(){
			var num = $(this).attr("num");
			
			$.ajax({
				type:"get",
				dataType:"html",
				url:"deletemyinfo",
				data : {"num":num},
				success:function(){
					var del = confirm("정말 삭제하시겠습니까?");
					if(del)
						location.href = "/member/list";
				}
			});
		});

		$("#btnupdatelogin").click(function() {
			
			var num = $("#loginnum").val();
			var name = $("#loginname").val();
			var addr = $("#loginaddr").val();
			var email = $("#loginemail").val();
			
			$.ajax({
				type:"post",
				dataType:"html",
				url : "updatemyinfo",
				data : {"num":num, "name":name, "addr":addr, "email":email},
				success:function(){
					location.reload();
				}
				
			});
		});
	})
</script>
</head>
<body>
	<table class="table table-bordered" style="width: 800px;">
		<c:if
			test="${sessionScope.loginok!=null and sessionScope.myid==dto.id }">

			<tr>
				<td rowspan="6" align="center"><img
					src="../membersave/${dto.photo }" id="pho"> <br> <input
					type="file" style="display: none" num="${dto.num }" id="newphoto">
					<!-- 사진 수정시 호출 -->
					<button type="button" class="btn btn-outline-secondary"
						id="btnnewphoto">사진수정</button></td>

				<td>이름: ${dto.name }</td>

				<td rowspan="6" align="center" valign="middle">
					<button type="button" class="btn btn-outline-secondary"
						id="updateajax" data-bs-toggle="modal"
						data-bs-target="#updateModal">수정</button>
					<button type="button" class="btn btn-outline-secondary"
						num="${dto.num}" id="deleteajax">삭제</button>
				</td>
			</tr>



			<tr>
				<td>아이디: ${dto.id }</td>
			</tr>

			<tr>
				<td>주소: ${dto.addr }</td>
			</tr>

			<tr>
				<td>이메일: ${dto.email }</td>
			</tr>

			<tr>
				<td>가입일: <fmt:formatDate value="${dto.gaipday }"
						pattern="yyyy-MM-dd HH:mm" /></td>
			</tr>

		</c:if>
	</table>


	<!-- The Modal -->
	<div class="modal" id="updateModal">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">회원 로그인</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<input type="hidden" id="loginnum" value="${dto.num }">
					이름<input type="text" class="form-control" id="loginname" value="${dto.name }">
					주소<input type="text" class="form-control" id="loginaddr" value="${dto.addr }">
					이메일<input type="text" class="form-control" id="loginemail" value="${dto.email }">
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="btnupdatelogin">정보 수정</button>
					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>
</body>
</html>