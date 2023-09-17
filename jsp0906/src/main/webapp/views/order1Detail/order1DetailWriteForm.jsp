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
                            <td class="px-5">${order1.custname }(${order1.custcode})</td>
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
                                	<input type="hidden" name="order_date" value="${order1.order_date}">
                                	<input type="hidden" name="item_code" value="${item.item_code}">
                                    <select name="item_name">
                                        <c:forEach var="item" items="${getItemnameList}">
                                            <option value="${item.item_code}">${item.item_name}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td class="px-5"><input type="text"  name="Z`"></td>
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
                            <th class="px-5"> item_code </th>
                            <th class="px-5">custcode</th>
                            <th class="px-5">제품 주문 내용</th>                                                      
                            <th class="px-5">제품수량</th>
                           
                        </tr>
                    </thead>
                    <tbody>
		             
						<c:forEach var="order1detail" items="${order1detailList}">
							<tr>
								
								<td class="px-5">${order1detail.order_date}</td>
								<td class="px-5">${order1detail.item_code}</td>
								<td class="px-5">${order1detail.costcode}</td>
								<td class="px-5">${order1detail.order_item_desc}</td>
								<td class="px-5">${order1detail.item_count}</td>
		
							</tr>
						</c:forEach>
					
                    </tbody>
                </table>
            </div>
        </div>
      
    </div>

    
    
    <jsp:include page="../layout/footer.jsp" />
</body>
</html>
