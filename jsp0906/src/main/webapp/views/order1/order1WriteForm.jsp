<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<body>

	<jsp:include page="../layout/header.jsp" />

	
	 <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <!-- 회원가입 폼 시작 -->
                
                
                <p>현재 날짜: <fmt:formatDate value="${time }" pattern="yyyy-MM-dd" /></p>
                <form action = "order1WritePro.do" method="post">
                
                	
                
                
                	<div class="mb-3">
                		<input type="hidden"  name="sabun" value="${sabun}" readonly>
                    	<label for="sabun" >이름 : ${name}</label>
                         
                    </div>
             		
    				<select name="customCode">
					    <c:forEach var="key" items="${fkCustomLists.keySet()}">
					    	<option value="${key}">${fkCustomLists[key]}</option>
					    </c:forEach>
					</select>
					
                    <div class="mb-3">
                        <label for="order_desc" class="form-label">거래요청내역 </label>
                        <input type="text" class="form-control" id="order_desc" name="order_desc">
                    </div>
                    <div class="mb-3">
                        <label for="order_status" class="form-label">order_status</label>
                        <input type="text" class="form-control" id="order_status" name="order_status">
                    </div>
                
                    <button type="submit" class="btn btn-primary">가입하기</button>
                </form>
                <!-- 회원가입 폼 끝 -->
            </div>
        </div>
    </div>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>