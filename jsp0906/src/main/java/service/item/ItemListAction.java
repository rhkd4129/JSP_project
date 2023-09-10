package service.item;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import dto.Sawon;
import service.CommandProcess;

public class ItemListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ItemListAction start");
		
		SawonDao sawondao = SawonDao.getInstance();
//		try {
//		
//			
//			
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//			
//			
//		} 
//		
//	
		
		
		return "views/item/itemList.jsp";
	}

}
