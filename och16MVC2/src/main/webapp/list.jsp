// list.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="style.css" type="text/css">
		<style type="text/css">
			table {
				width: 100%;
			}
		</style>
		<%
			String context = request.getContextPath();
		
		%>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript">
			function getDeptName(v_num){
				alert("getDeptName 1");
				
				$.ajax({
					url      : "<%=context%>/ajaxGetDeptName.do",
					data     : {num : v_num},
					dataType : 'text',
					success  : function(writer){
								alert(".ajax Data"+writer);
								/* input Tag는 value로 -> val() 사용 */
								$('#writerName').val(writer);
								
								$('#writerMsg').html(writer);
								alert("getDeptName 2");
							}
				})
                alert("getDeptName 3");
			}
		</script>
	</head>
	<body>
		<h1>게시판 전체Count : ${totCnt }</h1>
			<table>
				<tr>
					<td><a href="writeForm.do">글쓰기</a></td>
				</tr>
			</table>
			<table>
				<tr>
					<th>번호</th><th>제목</th><th>작성자</th><th>이메일</th>
					<th>IP</th><th>작성일</th><th>조회수</th>
				</tr>
				<c:if test="${totCnt > 0}">
					<c:forEach var="board" items="${listBoard}">
						<tr>
							<td>${startNum }</td>
								<td class="left" width=200>
									<c:if test="${board.readcount > 20}">
										<img src='images/hot.gif' onmouseover="getDeptName(${board.num})">
									</c:if>
									<c:if test="${board.re_level > 0}">
										<img src='images/level.gif' width="${board.re_level*10}">
										<img src='images/re.gif'>
									</c:if>
									<a href = 'content.do?num=${board.num}&pageNum=${currentPage}'>
										${board.subject }</a>
								</td>
								<td>${board.writer }</td>
								<td><a href="mailto:${board.email}">${board.email}</a></td>
								<td>${board.ip}</td>
								<td>${board.reg_date}</td>
								<td>${board.readcount}</td>
						</tr>
						<c:set var="startNum" value="${startNum - 1}"/>
					</c:forEach>
				</c:if>
				<c:if test="${totCnt == 0}">
					<tr>
						<td colspan=7>데이터가 없네</td>
					</tr>
				</c:if>
			</table>
			
			<div style="text-align: center;">
				<c:if test="${startPage > blockSize}">
					<a href='list.do?pageNum=${startPage-blockSize}'>[이전Page]</a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<a href='list.do?pageNum=${i}'>[${i}]</a>
				</c:forEach>
				<c:if test="${endPage < pageCnt}">
					<a href='list.do?pageNum=${startPage+blockSize}'>[다음Page]</a>
				</c:if>
			</div>
			<div id="ajaxMessage">
				AJax writerName 결과 : <input type="text" id="writerName" readonly="readonly"><p>
				AJax writerMsg  결과 : <span id="writerMsg"></span><p>
			</div>
	</body>
</html>
