<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="../style.css">
</head>

<body>
	<form action="deletePro.do" method="post">
	
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="pageNum" value="${pageNum}">
		암호<input type="text" name="passwd"><p>
		<input type="submit" value="삭제완료"> 
	</form>
</body>
</html>