package service.sawon;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ItemDao;
import dao.SawonDao;
import dto.Sawon;
import service.CommandProcess;

public class SawonUpdateFormAction implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("SawonUpdateFormAction start!");
		
		
		String sabun = request.getParameter("sabun");
		String pageNum = request.getParameter("pageNum");
		System.out.println(sabun);
		System.out.println(pageNum);
		Sawon sawon = new Sawon();
		System.out.println("try전");
		try { 
		
			SawonDao sawonDao = SawonDao.getInstance();
			sawon = sawonDao.sawonDetail(Integer.parseInt(sabun));
			
			request.setAttribute("sabun", sabun);
			request.setAttribute("sawon", sawon);
			request.setAttribute("pageNum", pageNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "views/sawon/sawonUpdateForm.jsp";
							
	}

}
