<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
   
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script>
    
        $(document).ready(function() {
            // 폼 제출을 방지하고 Ajax 요청을 수행
            $("form").submit(function(e) {
                e.preventDefault(); // 폼 제출 방지
                var fromData = $("form").serialize(); // 입력된 값 가져오기
				console.log(fromData);
                $.ajax({
                    type: "POST", // 또는 "GET" 등 요청 메서드 설정
                    url: "/order1DetailWritePro.do", // Ajax 요청을 처리할 서버 측 URL 설정
                    data:fromData, // 전송할 데이터 설정
                    success: function(response) {
                        // Ajax 요청이 성공하면 응답을 받아서 메시지를 출력
                        $("#result").text(response);
                    }
                });
            });
        });
    </script>
    
    
    
</head>
<body>
    <jsp:include page="../layout/header.jsp" />
    
    <div class="container mt-5">
        <div class="row justify-content-center pb-3">
            <div class="border border-3 border-primary p-3" style="border-radius: 30px;">
                <h2 class="py-4">order거래처 내역</h2>
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th class="px-5">주문일자</th>
                            <th class="px-5">거래처(코드)</th>
                            <th class="px-5">order_desc</th>
                            <th class="px-5">sabun_name</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="px-5">${order1.order_date }</td>
                            <td class="px-5">${order1.custname }</td>
                            <td class="px-5">${order1.order_desc }</td>
                            <td class="px-5">${order1.sawon_name }</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            </div>
            <div class="row justify-content-center mt-3">
            <div class="border border-3 border-primary p-3 mt-3"  style="border-radius: 30px;">
                <h2 class="py-4" >제품 상세 등록</h2>
                <form action="order1DetailWritePro.do" method="post">
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                
                                <th class="px-5">제품명(제품코드)</th>
                                <th class="px-5">제품주문내용</th>
                                <th class="px-5">제품수량</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                
                                <td class="px-5">
                                
                                	<input type="hidden" name="custcode" value="${order1.custcode}">
                                    <select name="itemname">
                                        <c:forEach var="item" items="${getItemnameList}">
                                            <option value="${item.item_code}">${item.item_name}(${item.item_code})</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td class="px-5"><input type="text"  name="order_item_desc"></td>
                                <td class="px-5"><input type="text"  name="item_count"></td>
                                <td class="px-5"><button type="submit" class="btn btn-primary">go</button></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>      
  
       
          <div class="row justify-content-center pb-3">
            <div class="border border-3 border-primary p-3" style="border-radius: 30px;">
                <h2 class="py-4">주문 상세 리스트</h2>
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th class="px-5">주문일자</th>
                            <th class="px-5">제품명</th>
                            <th class="px-5">제품 주문 내용</th>
                            <th class="px-5">제품수량</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td id="result" class="px-5"></td>
                            <td class="px-5"></td>
                            <td class="px-5"></td>
                            <td class="px-5"></td>
                            <td class="px-5"></td>
                            
                            
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
      
    </div>

    
    
    <jsp:include page="../layout/footer.jsp" />
</body>
</html>
