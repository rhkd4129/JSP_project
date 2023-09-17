package service.order1;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import dao.SawonDao;
import dto.Item;
import dto.Sawon;
import service.CommandProcess;

public class Order1DeleteFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			int item_code =  Integer.parseInt(request.getParameter("item_code"));
			request.setAttribute("item_code",item_code);
	
		 ItemDao itemDao = ItemDao.getInstance();
	     Item item = new Item();
	        try {
	        	item = itemDao.itemDetail(item_code);
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
	        request.setAttribute("pageNum", request.getParameter("pageNum"));
	        request.setAttribute("item", item);
		return "views/item/itemDeleteForm.jsp";
	}

}
