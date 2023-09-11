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

public class ItemWriteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("iTEMWriteProAction");
		try {
			request.setCharacterEncoding("utf-8");
			

			String item_name = request.getParameter("item_name");
			String item_kind = request.getParameter("item_kind");
			String item_desc = request.getParameter("item_desc");
			int item_price = Integer.parseInt(request.getParameter("item_price"));
			
			Item item = new Item();
			item.setItem_name(item_name);
			item.setItem_kind(item_kind);
			item.setItem_desc(item_desc);
			item.setItem_price(item_price);
			
			
			ItemDao itemDao = ItemDao.getInstance();
			int result = itemDao.Itemjoin(item);
			
			if(result ==0) {
				System.out.println("iTEMWriteProAction  오류");
			}
			request.setAttribute("result", result);
			
		}catch (Exception e) {
			e.getMessage();}
		
		
		
		return "views/item/ItemWritePro.jsp";
	}

}
