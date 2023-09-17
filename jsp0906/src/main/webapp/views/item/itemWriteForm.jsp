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
	<h2> itemWriteForm</h2>
	 <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <!-- 회원가입 폼 시작 -->
                
                <form action = "itemWritePro.do" method="post">
                    <div class="mb-3">
                        <label for="item_name" class="form-label">이름</label>
                        <input type="text" class="form-control" id="item_name" name="item_name">
                    </div>
                    <div class="mb-3">
                        <label for="item_kind" class="form-label">구분</label>
                        <input type="text" class="form-control" id="item_kind" name="item_kind">
                    </div>
                    <div class="mb-3">
                        <label for="item_desc" class="form-label">설명</label>
                        <input type="text" class="form-control"  id="item_desc" name="item_desc">
                    </div>
                    
                      <div class="mb-3">
                        <label for="item_price" class="form-label">가격</label>
                        <input type="text" class="form-control"  id="item_price" name="item_price">
                    </div>
        			
        			
        			
                    <button type="submit" class="btn btn-primary">가입하기</button>
                </form>
                <!-- 회원가입 폼 끝 -->
            </div>
        </div>
    </div>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>