package service;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board;
import dao.BoardDao;

public class DeleteFormAction implements CommandProcess {

	@Override
	public String reqeuestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
	
		request.setAttribute("num", request.getParameter("num"));
	
		 BoardDao bd = BoardDao.getInstance();
	     Board board = new Board();
	        try {
	        	board = bd.select( Integer.parseInt(  request.getParameter("num")));
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
	        request.setAttribute("pageNum", request.getParameter("pageNum"));
	        request.setAttribute("board", board);
		return "deleteForm.jsp";
	}

}
