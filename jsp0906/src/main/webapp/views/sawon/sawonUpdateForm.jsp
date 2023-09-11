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
	 <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <!-- 회원가입 폼 시작 -->
                <form action = "sawonUpdatePro.do" method="post">
	                <input type="hidden" name="sabun" value="${sawon.sabun}">
					<input type="hidden" name="pageNum" value="${pageNum}">
					
					<div class="mb-3">
                        <label for="sabun" class="form-label">사번</label>
                        <input type="text" class="form-control" id="sabun" name="sawon_name" value="${sawon.sabun}" readonly>

                    </div>
					
                    <div class="mb-3">
                        <label for="sawon_name" class="form-label">이름</label>
                        <input type="text" class="form-control" id="sawon_name" name="sawon_name" value="${sawon.sawon_name}">
                    </div>
                    <div class="mb-3">
                        <label for="sal" class="form-label">급여</label>
                        <input type="text" class="form-control" id="sal" name="sal" value="${sawon.sal}">
                    </div>
                    <div class="mb-3">
                        <label for="handphone" class="form-label">핸드폰 번호</label>
                        <input type="tel" class="form-control"  id="handphone" name="handphone" value="${sawon.handphone}">
                    </div>
                    <button type="submit" class="btn btn-primary">수정하기</button>
                </form>
                <!-- 회원가입 폼 끝 -->
            </div>
        </div>
    </div>
    
	
	
	
	
	
	<jsp:include page="../layout/footer.jsp" />
	
</body>
</html>