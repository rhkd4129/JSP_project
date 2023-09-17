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

public class ItemUpdateProAction implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {

       
        try {
            
            request.setCharacterEncoding("utf-8");
            int item_code = Integer.parseInt(request.getParameter("item_code"));
            int pageNum = Integer.parseInt(request.getParameter("pageNum"));
            int Item_price = Integer.parseInt(request.getParameter("item_price"));
            String item_name = request.getParameter("item_name");
			String item_kind = request.getParameter("item_kind");
			String item_desc = request.getParameter("item_desc");
			
			
			Item item = new Item();
			item.setItem_code(item_code);
			item.setItem_name(item_name);
			item.setItem_kind(item_kind);
			item.setItem_desc(item_desc);
			item.setItem_price(Item_price);
			
			
			ItemDao itemDao = ItemDao.getInstance();
			int result = itemDao.update(item);
		
			
            request.setAttribute("item_code", item_code);
            request.setAttribute("pageNum", pageNum);
            request.setAttribute("result", result);
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        return "views/item/itemUpdatePro.jsp";
    }
}
