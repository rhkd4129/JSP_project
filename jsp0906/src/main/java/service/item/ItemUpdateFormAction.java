package service.item;

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

public class ItemUpdateFormAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("SawonUpdateFormAction start!");
		
		
		String item_code = request.getParameter("item_code");
		String pageNum = request.getParameter("pageNum");

		Item item  = new Item();
		System.out.println("try전");
		try { 
		
			ItemDao itemDao = ItemDao.getInstance();
			item = itemDao.itemDetail(Integer.parseInt(item_code));
			
			request.setAttribute("item_code", item_code);
			request.setAttribute("item", item);
			request.setAttribute("pageNum", pageNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "views/item/itemUpdateForm.jsp";
							
	}

}
