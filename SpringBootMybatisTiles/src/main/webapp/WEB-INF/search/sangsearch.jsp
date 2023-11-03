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
<script type="text/javascript">
	$(function() {
		$("#sangpum").keyup(function() {
			var sangpum = $("#sangpum").val();

			$.ajax({
				type : "get",
				url : "/search/result1",
				dataType : "json",
				data : {
					"sangpum" : sangpum
				},
				success : function(res) {
					//alert("성공")

					var s = "";
					$.each(res, function(i, sangpum) {
						s += "<div class='divsearch' style='width:1200px'><b class='searchadd' style='cursor:pointer;'>" + sangpum + "</b></div>";
						//alert(sangpum)
					})
					if (sangpum == "") {
						$("#print").html("");
					} else
						$("#print").html(s);
				}
			});
		});
		
		$("#sangpum").keypress(function(e){
			//검색어 입력 후 엔터키 입력하면 조회버튼 클릭
			if(e.keyCode && e.keyCode == 13){
				$("#btnsearch").trigger("click");
				return false;
			}
			//엔터키 막기
			if(e.keyCode && e.keyCode == 13){
				  e.preventDefault();	
			}
		});
		$("#btnsearch").click(function(){
			alert("이벤트 감지");
		});
	});

	
	$(document).on("click","div.divsearch", function(event){
		var searchadd = $(this).find(".searchadd").html();
		//alert(searchadd)
		$("#sangpum").val(searchadd);
		$("#print").html("");
	});
	
	$(document).on("mouseover","div.divsearch", function(event){
		$(this).css("background-color", "lightgray");
	});
	
	$(document).on("mouseout","div.divsearch", function(event){
		$(this).css("background-color", "white");
	}); 

</script>
</head>
<body>

	<div class="d-inline-flex">
		<input type="text" class="form-control"
			style="width: 1200px; margin-top: 20px;" id="sangpum"
			placeholder="검색어를 입력하세요">
		<input type="hidden" class="btn btn-info" id="btnsearch">
	</div>
	<div id="print"></div>
</body>
</html>