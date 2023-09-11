package service.sawon;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import dto.Sawon;
import service.CommandProcess;

public class SawonContentAction implements CommandProcess {

		@Override
		public String requestPro(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// 1. num , pageNum
			// 2. BoardDao bd Instance
			// 4. Board board = bd.select(num);
			// 5. request 객체에 num , pageNum , board
	
		
		try {	
			int num = Integer.parseInt(  request.getParameter("num"));
			String pageNum = request.getParameter("pageNum");
			
			
			System.out.println("---------------------");
			
			
			SawonDao sawonDao = SawonDao.getInstance();
			
			
			Sawon sawon = sawonDao.sawonDetail(num);
			
			
			request.setAttribute("num", num);
			request.setAttribute("sawon", sawon);
			request.setAttribute("pageNum", pageNum);
			
		} catch (Exception e) {
			System.out.println("SawonContentAction e message->"+e.getMessage());
		}
		return "views/sawon/sawonContent.jsp";
		}
}

