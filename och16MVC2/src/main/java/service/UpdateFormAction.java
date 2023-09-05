package service;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board;
import dao.BoardDao;

public class UpdateFormAction implements CommandProcess {
		// 1. num , pageNum  GET
	
			// 2. BoardDao bd Instance
			
			// 4. Board board = bd.select(num);
			
			// 5. request 객체에 pageNum , board
	@Override
	public String reqeuestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		System.out.println("UpdateForm start!");
		
		
		int num = Integer.parseInt(  request.getParameter("num"));
		BoardDao bd = BoardDao.getInstance();
		Board board = new Board();
		System.out.println("ddd");
		try {
			board = bd.select(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("num", request.getParameter("num"));
		request.setAttribute("pageNum", request.getParameter("pageNum"));
		request.setAttribute("board", board);
		
		return "updateForm.jsp";
	}

}
