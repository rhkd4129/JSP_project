package service.sawon;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

public class SawonWriteFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
//		String pageNum = request.getParameter("pageNum");
//		if(pageNum== null) pageNum="1";
//		request.setAttribute("pageNum", pageNum);
		// 
		return "views/sawon/sawonWriteForm.jsp";
	}

}
