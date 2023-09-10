<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<!--  -->
		<!--<form action="writePro.do?pageNum=${pageNum}" method="post">
			<input type="hidden" name="ref" value="${ref}">
		 -->
		<form action = "sawonWritePro.do" method="post">
		
		<table>
			<caption> <h2> 사원 등록  </h2></caption>
				<tr> <td>이름</td>  <td> <input type="text" name="sawon_name"></td></tr>
				<tr> <td>급여</td>  <td> <input type="text" name="sal"></td></tr>
				<tr> <td>번호</td>  <td> <input type="tel" name="handphone"></td></tr>
				<tr> 
					<td><input type="submit" value="작성" class="btn btn-primary"></td> 
					<td><input type="reset" value="다시작성" class="btn btn-primary"></td>	
		
		
		</table>
		
	</form>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>