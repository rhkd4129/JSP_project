<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test ="${result>0}">
		<script type="text/javascript">
			alert("입력완료");
			location.href="list.do?pageNum=${pageNum}";
			
		</script>
	</c:if>
	
	<c:if test ="${result == 0}">
		<script type="text/javascript">
			alert("암호틀려 ");
			location.href="deleteForm.do?Num=${num}&pageNum=${pageNum}";
		</script>
	</c:if>
	
	
	
</body>
</html>