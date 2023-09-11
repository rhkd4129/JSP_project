package service.sawon;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import dto.Sawon;
import service.CommandProcess;

public class SawonWriteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SawonWriteProAction");
		try {
			request.setCharacterEncoding("utf-8");
			
			String sawon_name = request.getParameter("sawon_name");
			int sal = Integer.parseInt(request.getParameter("sal"));
			String handphone = request.getParameter("handphone");
			
			
			Sawon sawon = new Sawon();
			sawon.setSawon_name(sawon_name);
			sawon.setSal(sal);
			sawon.setHandphone(handphone);
			
			
			SawonDao sawonDao = SawonDao.getInstance();
			int result = sawonDao.join(sawon);
			
			if(result ==0) {
				System.out.println("SawonWriteProAction  오류");
			}
			request.setAttribute("result", result);
			
		}catch (Exception e) {
			e.getMessage();}
		
		
		
		return "views/sawon/sawonWritePro.jsp";
	}

}
