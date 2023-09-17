package service.order1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import dao.Order1Dao;
import dao.SawonDao;
import dto.Item;
import dto.Order1;
import dto.Sawon;
import service.CommandProcess;

public class Order1ContentAction implements CommandProcess {

		@Override
		public String requestPro(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// 1. num , pageNum
			// 2. BoardDao bd Instance
			// 4. Board board = bd.select(num);
			// 5. request 객체에 num , pageNum , board
	
		
		try {	
			int cust_code = Integer.parseInt(  request.getParameter("cust_code"));
			String pageNum = request.getParameter("pageNum");
			String order_date = request.getParameter("order_date");
			
			
			System.out.println("---------------------");
			
			
			Order1Dao order1Dao = Order1Dao.getInstance();
			Order1 order1 = order1Dao.order1Detail(order_date, cust_code);
			 
			
			
//			request.setAttribute(order1.getSabun(),"sabun");
			request.setAttribute("order1", order1);
			request.setAttribute("pageNum", pageNum);
			
		} catch (Exception e) {
			System.out.println("SawonContentAction e message->"+e.getMessage());
		}
		return "views/order1/order1Content.jsp";
		}
}

