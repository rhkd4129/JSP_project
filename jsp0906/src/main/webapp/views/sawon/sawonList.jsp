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
<body>
	<jsp:include page="../layout/header.jsp"/>	
	
	<div class="container my-5">
	    <div class="d-flex justify-content-center">
	        <a href="sawonWrtieForm.do">
	            <button type="button" class="btn btn-primary">사원 등록</button>
	        </a>
	    </div>
	</div>
		
		
		

	
		
			<table class="mx-auto my-5 table-bordered table-sm">
				<tr>
					<th class="px-3">사원번호</th><th class="px-3" >이름</th><th class="px-3" >급여</th><th class="px-3">전화번호</th>
				</tr>
	
				<c:forEach var="sawon" items="${sawonList}">
					<tr>			
						<td class="px-3">${sawon.sabun }</td>
						<td class="px-3">${sawon.sawon_name }</td>
						<td class="px-3">${sawon.sal}</td>
						<td class="px-3">${sawon.handphone}</td>
					</tr>
				</c:forEach>

			</table>
	
			
		

	   <jsp:include page="../layout/footer.jsp"/>
</body>
</html>