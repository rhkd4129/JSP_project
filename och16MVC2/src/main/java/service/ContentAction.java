package service;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.List;
import dao.Board;
import dao.BoardDao;
public class ContentAction implements CommandProcess {

	@Override
	public String reqeuestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		// 1. num , pageNum
				// 2. BoardDao bd Instance
				// 3. num의 readCount 증가 -->void bd.readCount(num); 
				// 4. Board board = bd.select(num);
				// 5. request 객체에 num , pageNum , board
		
		
		try {	
			System.out.println("doprocess시작 try");
			int num = Integer.parseInt(  request.getParameter("num"));
			String pageNum = request.getParameter("pageNum");
			
			
			System.out.println("---------------------");
			
			
			BoardDao bd = BoardDao.getInstance();
			
			bd.readCount(num);
			Board board = bd.select(num);
			
			
			request.setAttribute("num", num);
			request.setAttribute("board", board);
			request.setAttribute("pageNum", pageNum);
			
		} catch (Exception e) {
			System.out.println("Listaction e message->"+e.getMessage());
		}
		return "content.jsp";
	}

}
