package service.order1Detail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import dao.Order1Dao;
import dao.OrderDetailDao;
import dao.SawonDao;
import dto.Item;
import dto.Order1;
import dto.Order1Detail;
import dto.Sawon;
import service.CommandProcess;

public class Order1DetailWriteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("utf-8");
			

			int custcode = Integer.parseInt(request.getParameter("custcode"));
			int item_count = Integer.parseInt(request.getParameter("item_count"));  
			int itemcode = Integer.parseInt(request.getParameter("item_code"));
			String order_item_desc = request.getParameter("order_item_desc");
			System.out.println("Order1DetailWriteProAction");
			System.out.println(custcode);
			
//		
			Order1Detail order1Detail = new Order1Detail();
			order1Detail.setItem_code(itemcode);
			order1Detail.setCostcode(custcode);
			order1Detail.setOrder_item_desc(order_item_desc);
			order1Detail.setItem_count(item_count);
			
			
			OrderDetailDao orderDetailDao = OrderDetailDao.getInstance();
			int result = orderDetailDao.order1DetailJoin(order1Detail);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
	            if (result > 0) {
	                out.println("데이터 저장이 성공했습니다.");
	            } else {
	                out.println("데이터 저장 실패");
	            }
		}catch (Exception e) {
			e.getMessage();}
		
		
		
		
		
		return "views/order1/order1DetailWritePro.jsp";
	}

}
