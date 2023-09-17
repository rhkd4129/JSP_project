package service.order1Detail;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
			System.out.println("AAAAAAAAAAAAA");
			
			int custcode = Integer.parseInt(request.getParameter("custcode"));
			String order_date = request.getParameter("order_date");
			if (order_date == null) {System.out.println("널이다");}
			
			
			int itemcode = Integer.parseInt(request.getParameter("item_code"));
			String item_name =request.getParameter("item_name");
			
			String order_item_desc = request.getParameter("order_item_desc");
			int item_count = Integer.parseInt(request.getParameter("item_count"));  
			
			
			System.out.println("-------------------");
			String check = String.format("custcode: %d   item_count : %d  order_date:%s ", custcode, item_count,order_date);
			System.out.println(check);
//			
//		
			Order1Detail order1Detail = new Order1Detail();
			order1Detail.setOrder_date(order_date);
			order1Detail.setItem_code(itemcode);
			order1Detail.setCostcode(custcode);
			order1Detail.setOrder_item_desc(order_item_desc);
			order1Detail.setItem_count(item_count);
			order1Detail.setCancel("0");
//			String formattedString = """
//				    My name is %s
//				    and I am %d years old.
//				    """.formatted(name, age);
			
			
			
			
			OrderDetailDao orderDetailDao = OrderDetailDao.getInstance();
			int result = orderDetailDao.order1DetailJoin(order1Detail);
			request.setAttribute("result", result);
//			response.setContentType("text/html;charset=UTF-8");
//			PrintWriter out = response.getWriter();
	    
		} catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println(e.getMessage());
	        System.out.println("SQL 오류: order1DetailJoin");
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println(e.getMessage());
	        System.out.println("일반 오류: order1DetailJoin");
	    }
		return "views/order1Detail/order1DetailWritePro.jsp";
	}

}
