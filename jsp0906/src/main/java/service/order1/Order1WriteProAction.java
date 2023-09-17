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

public class Order1WriteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("utf-8");
			

			int customCode = Integer.parseInt(request.getParameter("customCode"));  
			int sabun = Integer.parseInt(request.getParameter("sabun"));
			String order_desc = request.getParameter("order_desc");
			String order_status = request.getParameter("order_status");
			
			
			Order1 order1 = new Order1();
			order1.setCustcode(customCode);
			order1.setSabun(sabun);
			order1.setOrder_status(order_status);
			order1.setOrder_desc(order_desc);
			//데이터 변환
			
			
			
			
			Order1Dao order1Dao = Order1Dao.getInstance();
			int result = order1Dao.order1Join(order1);
			
			if(result ==0) {
				System.out.println("OrderWriteProAction  오류");
			}
			request.setAttribute("result", result);
			
		}catch (Exception e) {
			e.getMessage();}
		
		
		
		return "views/order1/order1WritePro.jsp";
	}

}
