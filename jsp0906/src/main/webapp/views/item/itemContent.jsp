<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
	
	td{
		font-weight: bold;
		font-size: 18px;
	}
	input{
		font-weight: bold;
		font-size: 18px;
	}
	</style>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<body>
	<jsp:include page="../layout/header.jsp"/>
	
	
	<div class="container my-5">
	    <div class="d-flex justify-content-center">
		        <div class="border border-success border-3 px-5 py-5" style="border-radius: 30px;">
				    <table >
					
					<tr >
						<td width="50">번호</td>
						<td>${item.item_code}</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>${item.item_name}</td>
					</tr>
					
					<tr>
						<td>종류</td>
						<td>${item.item_kind}</td>
					</tr>
					
					<tr>
						<td>설명</td>
						<td>${item.item_desc}</td>
					</tr>
					
					<tr>
						<td>가격</td>
						<td>${item.item_price}</td>
					</tr>
					
					<tr>
						<td>날짜</td>
						<td>${item.item_birth}</td>
					</tr>
					
					
					
					
				</table>
		    </div>
		</div>
	</div>
	
	<div class="d-flex justify-content-center">
		<input type="button" value="수정"  class="btn btn-success mx-1"
				onclick="location.href='itemUpdateForm.do?item_code=${item.item_code}&pageNum=${pageNum}'">
				 
				<input type="button" value="삭제" class="btn btn-success mx-1" 
				onclick="location.href='itemDeleteForm.do?item_code=${item.item_code}&pageNum=${pageNum}'">
				
				<input type="button" value="목록" class="btn btn-success mx-1"
				onclick="location.href='itemList.do?pageNum=${pageNum}'">
	</div>
	<jsp:include page="../layout/footer.jsp"/>
</body>
</html>