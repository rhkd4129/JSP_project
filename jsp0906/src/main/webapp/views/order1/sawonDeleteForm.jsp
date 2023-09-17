<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>

<body>
	<form action=sawonDeletePro.do method="post">
		<input type="hidden" name="sabun" value="${sabun}">
		<input type="hidden" name="pageNum" value="${pageNum}">
		<input type="submit" value="삭제완료"> 
	</form>
</body>
</html>