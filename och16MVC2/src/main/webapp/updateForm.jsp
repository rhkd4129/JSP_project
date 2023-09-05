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
	<form action="updatePro.do" method="post">
		<input type="hidden" name="num" value="${board.num}">
		<input type="hidden" name="pageNum" value="${pageNum}">

		<table>
			<caption>  게시판수정 </caption>
			<tr>  <td>번호</td> <td>${board.num}</td> </tr>
			<tr>
				<td>제목</td>
				<td>  <input type="text" name="subject" value="${board.subject}"> </td>
			</tr>
				
				<tr> <td>작성자</td>  <td>  <input type="text" name="writer" value="${board.writer}"> </td></tr>
				<tr> <td>이메일</td>  <td>  <input type="text" name="email" value="${board.email}"> </td></tr>
				
						
				
				<tr>
				 	<td>암호</td> 
				 	 <td><input type="password" name="passwd" value="${board.passwd}"></td>
				</tr>
			
				
				
				<tr> <td>내용</td>  <td> <textarea rows = "10" cols="30" name="content">${board.content}</textarea></td></tr>
		
				<tr> 
					<td><input type="submit" value="수정완료"></td> 
					<td><input type="reset" value="다시작성"></td>	
				</tr>
		
		
		</table>
		
	
	
	
	
	</form>



</body>
</html>