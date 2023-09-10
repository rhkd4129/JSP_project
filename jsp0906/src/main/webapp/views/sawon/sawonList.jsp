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
<body>
	<jsp:include page="../layout/header.jsp"/>	
	
			<a href="sawonList.do"></a>
			<table>
				<tr>
					<th>사원번호</th><th>이름</th><th>급여</th><th>전화번호</th>
				</tr>
	
				<c:forEach var="sawon" items="${sawonList}">
					<tr>			
						<td>${sawon.sabun }</td>
						<td>${sawon.sawon_name }</td>
						<td>${sawon.sal}</td>
						<td>${sawon.handphone}</td>
					</tr>
				</c:forEach>

			</table>
			

	   
	   <jsp:include page="../layout/footer.jsp"/>
</body>
</html>