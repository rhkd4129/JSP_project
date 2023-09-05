<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<style type="text/css">
table {
   width: 100%
}
;

</style>
<%	String context = request.getContextPath();%>
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
	function getDeptName(v_num) {
		alert("dfdff");
		$.ajax({
			
			url: "<%= context %>/ajaxGetDeptName.do", 
			data:{num:v_num},
			dataType: 'text', // 'text' 대신 'json' 또는 다른 데이터 유형을 사용할 수 있습니다.
			success: function(data) { //DATA가 WRITER로
				alert("Ajax Data: " + data);
				$('#writerName').val(data);
				$('#writerMsg').html(data);
				//alert("getDeptName 2");
			}
		});
	}
</script>

</head>
<body>
<div id="header">
 <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" aria-disabled="true">Disabled</a>
        </li>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>

</div>
	<div id="content">
		 <h1>게시판 전체 cnt : ${totCnt}</h1>
	   <table>
	      <tr>
	         <td><a href="writeForm.do">글쓰기</a></td>
	      </tr>
	   </table>
	   <table>
	      <tr>
	         <th>번호</th>
	         <th>제목</th>
	         <th>작성자</th>
	         <th>이메일</th>
	         <th>IP</th>
	         <th>작성일</th>
	         <th>조회수</th>
	      </tr>
	
	
	      <c:if test="${totCnt > 0}">
	         <c:forEach items="${listBoard}" var="board">
	            <tr>
	               <td>${startNum}</td>
	               <td class="left" width=200><c:if
	                     test="${board.readcount > 20}">
	                     <img src='./images/hot.gif' onmouseover="getDeptName(${board.num})">
	
	                  </c:if> <c:if test="${board.re_level > 0}">
	                     <img src="./images/level.gif" width="${board.re_level*10}">
	                     <img src="./images/re.gif">
	                  </c:if> <a href='content.do?num=${board.num}&pageNum=${currentPage}'>
	                     ${board.subject}</a></td>
	               <td>${board.writer}</td>
	               <td><a href="mailto:${board.email}">${board.	email}</a></td>
	               <td>${board.ip}</td>
	               <td>${board.reg_date}</td>
	               <td>${board.readcount}</td>
	            </tr>
	            <c:set var="startNum" value="${startNum-1}"></c:set>
	         </c:forEach>
	      </c:if>
	      <c:if test="${totCnt == 0 }">
	         <tr>
	            <td colspan=7>데이터가 없음.</td>
	         </tr>
	      </c:if>
	   </table>
	   <div style="text-align: center">
	      <c:if test="${startPage > blockSize }">
	         <a href='list.do?pageNum=${startPage-blockSize}'>[이전]</a>
	      </c:if>
	      <c:forEach var="i" begin="${startPage}" end="${endPage }">
	         <a href='list.do?pageNum=${i}'>[${i}]</a>
	      </c:forEach>
	      
	      <c:if test="${endPage < blockSize }">
	         <a href='list.do?pageNum=${startPage+blockSize}'>[다음]</a>
	      </c:if>
	   </div>
	
		<div id="ajaxMessage">
			AJAX deptName<input type="text" id="writerName" readonly="readonly"><p>
			 AJAX Message<span id="writerMsg"></span>
		</div>
	</div>
<div id="fotter">
 	<h5>gjhgjgdfdfefdfdfdfdfdfdfj</h5>
 	<h3>gdfdfdfdfdfdfjhgjgj</h3>
</div>
  
</body>
</html>