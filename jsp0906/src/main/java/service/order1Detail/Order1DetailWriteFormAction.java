package service.order1Detail;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomDao;
import dao.ItemDao;
import dao.Order1Dao;
import dao.SawonDao;
import dto.Custom;
import dto.Item;
import dto.Order1;
import dto.Sawon;
import service.CommandProcess;

public class Order1DetailWriteFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//	
		int custcode = Integer.parseInt(request.getParameter("custcode"));
		String order_date =request.getParameter("order_date"); 
		
//		
//		
//		HashMap<Integer,String> fkCustomLists = new HashMap<Integer,String>();
		try {
			ItemDao itemDao = ItemDao.getInstance();
			Order1Dao order1Dao = Order1Dao.getInstance();
			ArrayList<Item> getItemnameList = itemDao.getItemnames();
			
			Order1 order1 = order1Dao.order1Detail(order_date, custcode);
			
			request.setAttribute("order1", order1);
			request.setAttribute("getItemnameList", getItemnameList);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
//		
////		System.out.println(CustomCodeList);
//		request.setAttribute("fkCustomLists", fkCustomLists);
//		request.setAttribute("name", name);
//		request.setAttribute("sabun", sabun);
		
		
		
		return "views/order1Detail/order1DetailWriteForm.jsp";
	}

}
