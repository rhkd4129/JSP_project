package service.custom;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomDao;
import dao.ItemDao;
import dao.SawonDao;
import dto.Custom;
import dto.Item;
import dto.Sawon;
import service.CommandProcess;

public class CustomContentAction implements CommandProcess {

		@Override
		public String requestPro(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// 1. num , pageNum
			// 2. BoardDao bd Instance
			// 4. Board board = bd.select(num);
			// 5. request 객체에 num , pageNum , board
	
		
		try {	
			int custcode = Integer.parseInt(  request.getParameter("custcode"));
			String pageNum = request.getParameter("pageNum");
			
			
			System.out.println("---------------------");
			
			
			ItemDao itemDao = ItemDao.getInstance();
			CustomDao customDao = CustomDao.getInstance();
			Custom custom = customDao.customDetail(custcode);
			
			
			
			request.setAttribute("item_code", custcode);
			request.setAttribute("custom", custom);
			request.setAttribute("pageNum", pageNum);
			
		} catch (Exception e) {
			System.out.println("SawonContentAction e message->"+e.getMessage());
		}
		return "views/custom/customContent.jsp";
		}
}

