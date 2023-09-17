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
		        <div class="border border-primary border-3 px-5 py-5" style="border-radius: 30px;">
				    <table >
					
					<tr >
						<td width="50">번호</td>
						<td>${sawon.sabun}</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>${sawon.sawon_name}</td>
					</tr>
					
					<tr>
						<td>급여</td>
						<td>${sawon.sal}</td>
					</tr>
					
					<tr>
						<td>폰번호</td>
						<td>${sawon.handphone}</td>
					</tr>
				</table>
		    </div>
		</div>
	</div>
	
	<div class="d-flex justify-content-center">
		<input type="button" value="수정"  class="btn btn-primary mx-1"
				onclick="location.href='sawonUpdateForm.do?sabun=${sawon.sabun}&pageNum=${pageNum}'">
				 
				<input type="button" value="삭제" class="btn btn-primary mx-1" 
				onclick="location.href='sawonDeleteForm.do?sabun=${sawon.sabun}&pageNum=${pageNum}'">
				
				<input type="button" value="주문등록" class="btn btn-primary mx-1" 
				onclick="location.href='order1WriteForm.do?sabun=${sawon.sabun}&pageNum=${pageNum}'">
				
				
				<input type="button" value="목록" class="btn btn-primary mx-1"
				onclick="location.href='sawonList.do?pageNum=${pageNum}'">
	</div>
	<jsp:include page="../layout/footer.jsp"/>
</body>
</html>