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


public class ItemDeleteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("deleteProAction");
		request.setCharacterEncoding("utf-8");
		
		int result=0;
        int item_code = Integer.parseInt(request.getParameter("item_code"));
        String pageNum = request.getParameter("pageNum");
        
        
        
        	
       
        ItemDao itemDao = ItemDao.getInstance();
	    Item item = new Item();
        try {
			result = itemDao.delete(item_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("result", result);
        
        
        return "views/item/itemDeletePro.jsp";
	}

}
