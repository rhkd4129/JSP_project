<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body  >
	<jsp:include page="../layout/header.jsp"/>	
	
	<div class="container my-5">
	    <div class="d-flex justify-content-center">
	        <a href="itemWriteForm.do">
	            <button type="button" class="btn btn-primary">item 등록</button>
	        </a>
	    </div>
	</div>
		
		
		

			<h3 class="text-center">게시판 전체Count : ${totCnt }</h3>
		
			<table class="mx-auto my-5 table-bordered table-sm">
				<tr>
					<th class="px-5">번호</th> <th class="px-5">item 코드</th> <th class="px-5">item name</th><th class="px-5" >price</th><th class="px-5" >kind</th><th class="px-5">설명</th> <th class="px-5">등록일자</th>
				</tr>
				<c:if test="${totCnt > 0}">
					<c:forEach var="item" items="${itemList}">
						<tr>
								<td>${startNum }</td>
								<td class="px-5">${item.item_code }</td>

								<td><a href = 'itemContent.do?item_code=${item.item_code}&pageNum=${currentPage}'>${item.item_name }</a></td>
								<td class="px-5">${item.item_price}</td>
								<td class="px-5">${item.item_kind}</td>
								<td class="px-5">${item.item_desc}</td>
								<td class="px-5">${item.item_birth}</td>
						</tr>
						<c:set var="startNum" value="${startNum - 1}"/>
					</c:forEach>
				</c:if>
				<c:if test="${totCnt == 0}">
					<tr>
						<td colspan=7>데이터가 없네</td>
					</tr>
				</c:if>
			</table>
				

			
			<div style="text-align: center;">
				<c:if test="${startPage > blockSize}">
					<a href='itemList.do?pageNum=${startPage-blockSize}'>[이전Page]</a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<a href='itemList.do?pageNum=${i}'>[${i}]</a>
				</c:forEach>
				<c:if test="${endPage < pageCnt}">
					<a href='itemList.do?pageNum=${startPage+blockSize}'>[다음Page]</a>
				</c:if>
			</div>
			
		

	   <jsp:include page="../layout/footer.jsp"/>
</body>
</html>