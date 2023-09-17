package service.item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import dao.SawonDao;
import dto.Item;
import dto.Sawon;
import service.CommandProcess;

public class ItemContentAction implements CommandProcess {

		@Override
		public String requestPro(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// 1. num , pageNum
			// 2. BoardDao bd Instance
			// 4. Board board = bd.select(num);
			// 5. request 객체에 num , pageNum , board
	
		
		try {	
			int item_code = Integer.parseInt(  request.getParameter("item_code"));
			String pageNum = request.getParameter("pageNum");
			
			
			System.out.println("---------------------");
			
			
			ItemDao itemDao = ItemDao.getInstance();
			
			Item item = itemDao.itemDetail(item_code);
			
			
			request.setAttribute("item_code", item_code);
			request.setAttribute("item", item);
			request.setAttribute("pageNum", pageNum);
			
		} catch (Exception e) {
			System.out.println("SawonContentAction e message->"+e.getMessage());
		}
		return "views/item/itemContent.jsp";
		}
}

