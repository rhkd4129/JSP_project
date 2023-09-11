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


public class SawonDeleteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("deleteProAction");
		request.setCharacterEncoding("utf-8");
		
		int result=0;
        int num = Integer.parseInt(request.getParameter("num"));
        String pageNum = request.getParameter("pageNum");
        
        
        
        	
       
        SawonDao sawonDao = SawonDao.getInstance();
	    Sawon sawon = new Sawon();
        try {
			result = sawonDao.delete(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("result", result);
        
        
        return "views/sawon/sawonDeletePro.jsp";
	}

}
