package service;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board;
import dao.BoardDao;

public class DeleteProAction implements CommandProcess {

	@Override
	public String reqeuestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		
		System.out.println("deleteProAction");
		request.setCharacterEncoding("utf-8");
		
		int result=0;
        int num = Integer.parseInt(request.getParameter("num"));
        String pageNum = request.getParameter("pageNum");
        
        
        
        	
       
        BoardDao bd = BoardDao.getInstance();
        try {
			result = bd.delete(num,request.getParameter("passwd"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("result", result);
        
        
		 return "deletePro.jsp";
	}

}
