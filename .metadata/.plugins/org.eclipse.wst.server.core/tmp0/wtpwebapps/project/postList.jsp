<%@page import="project.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	
	<h2>List</h2>
	
	
	
<body>

	<table border = "1" >
		<tr>   <th>제목</th>    <th>내용</th>  <th>작성시간<th> </tr>
		<c:forEach var = "post" items="${pl}">
			<tr>
				<td> ${post.title}</td>
				<td>${post.content}</td>
				<td>${post.regDate}</td>
			</tr>
		</c:forEach>
	</table>

	<a href="post_insert">업로드</a>
</body>
</html>