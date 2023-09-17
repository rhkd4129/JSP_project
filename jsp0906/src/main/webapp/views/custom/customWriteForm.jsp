<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	 <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <!-- 회원가입 폼 시작 -->
                <form action = "customWritePro.do" method="post">
                    <div class="mb-3">
                        <label for="custname" class="form-label">custname</label>
                        <input type="text" class="form-control" id="custname" name="custname">
                    </div>
                    <div class="mb-3">
                        <label for="cust_tel" class="form-label">번호</label>
                        <input type="tel" class="form-control" id="cust_tel" name="cust_tel">
                    </div>
                    <div class="mb-3">
                        <label for="cust_ceo" class="form-label">ceo</label>
                        <input type="text" class="form-control"  id="cust_ceo" name="cust_ceo">
                    </div>
                    
                      <div class="mb-3">
                        <label for="cust_gubun" class="form-label">구분</label>
                        <input type="text" class="form-control" id="cust_gubun" name="cust_gubun">
                    </div>
                    
                    <button type="submit" class="btn btn-primary">가입하기</button>
                </form>
               
            </div>
        </div>
    </div>
	<jsp:include page="../layout/footer.jsp" />
	</body>
</html>