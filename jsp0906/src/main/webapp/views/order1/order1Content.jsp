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
						<td width="50">날짜</td>
						<td>${order1.order_date}</td>
					</tr>
					<tr>
						<td>거래처</td>
						<td>${order1.custname}</td>
					</tr>
					
					<tr>
						<td>내용</td>
						<td>${order1.order_desc}</td>
					</tr>
					
					<tr>
						<td>이름</td>
						<td>${order1.sawon_name}</td>
					</tr>
					
					<tr>
						<td>주문상태</td>
						<td>${order1.order_status}</td>
					</tr>
					
			 
				</table>
		    </div>
		</div>
	</div>
	<div class="d-flex justify-content-center">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<c:choose>
		    <c:when test="${order1.order_status == 0}">
		       <input type="button" value="수정"  class="btn btn-success mx-1"
				onclick="location.href='order1UpdateForm.do?custcode=${order1.custcode}&pageNum=${pageNum}&order_date=${order1.order_date}'">
				 
				<input type="button" value="삭제" class="btn btn-success mx-1" 
				onclick="location.href='order1DeleteForm.do?custcode=${order1.custcode}&pageNum=${pageNum}&order_date=${order1.order_date}'">
				
				<input type="button" value="제품추가" class="btn btn-success mx-1" 
				onclick="location.href='order1DetailWriteForm.do?custcode=${order1.custcode}&pageNum=${pageNum}&order_date=${order1.order_date}'">
				
				
		    </c:when>
		    <c:otherwise>
		        
		    </c:otherwise>
		</c:choose>
				<input type="button" value="목록" class="btn btn-success mx-1"
				onclick="location.href='order1List.do?pageNum=${pageNum}'">
	</div>
	
	<jsp:include page="../layout/footer.jsp"/>
</body>
</html>