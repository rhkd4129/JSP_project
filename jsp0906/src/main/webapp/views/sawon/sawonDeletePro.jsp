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
			alert("삭제완료");
			location.href="sawonList.do?pageNum=${pageNum}";
			
		</script>
	</c:if>
	
	<c:if test ="${result == 0}">
		<script type="text/javascript">
			alert("삭제 불가 ");
			location.href="sawonContent.do?sabun=${sabun}&pageNum=${pageNum}";
		</script>
	</c:if>
	
	
	
</body>
</html>