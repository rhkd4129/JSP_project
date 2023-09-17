package service.sawon;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.SawonDao;
import dto.Sawon;
import service.CommandProcess;

public class SawonDeleteFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		int sabun = Integer.parseInt(request.getParameter("sabun"));
		request.setAttribute("sabun",sabun);
	
		 SawonDao sawonDao = SawonDao.getInstance();
	     Sawon sawon = new Sawon();
	        try {
	        	sawon = sawonDao.sawonDetail(sabun);
			} catch (SQLException e) {
				System.out.println("sawonDao.sawonDetail(sabun);");
				e.printStackTrace();
			}
	        request.setAttribute("pageNum", request.getParameter("pageNum"));
	        request.setAttribute("sawon", sawon);
		return "views/sawon/sawonDeleteForm.jsp";
	}

}
