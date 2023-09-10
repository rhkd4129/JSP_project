package service.custom;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import dto.Sawon;
import service.CommandProcess;

public class CustomListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CustomListAction start");
		
		SawonDao sawondao = SawonDao.getInstance();
//		try {
//			List<Sawon> sawonList = sawondao.sawonList(0,0);
//			request.setAttribute("sawonList", sawonList);
//			
//			
//			
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//			System.out.println("sawonListService catch error");
//			
//		} 
//		
	
		
		
		return "views/custom/customList.jsp";
	}

}
