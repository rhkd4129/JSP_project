package service;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board;
import dao.BoardDao;

public class WriteFormAction implements CommandProcess {
	///get
	@Override
	public String reqeuestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		System.out.println("WrtieFormAction Start..");
		request.setCharacterEncoding("utf-8");
		
		try {
			//신규 글
			int num = 0,ref=0, re_level=0,re_step=0;
			
			String pageNum = request.getParameter("pageNum");
			if(pageNum== null) pageNum="1";
			
			//댓글일경우 
			if(request.getParameter("num")!=null) {
				num =  Integer.parseInt(  request.getParameter("num"));
				BoardDao bd =  BoardDao.getInstance();
				Board board = bd.select(num);
				ref = board.getRef();
				re_level = board.getRe_level();
				re_step = board.getRe_step();
			}
			request.setAttribute("num", num);
			request.setAttribute("ref", ref);
			request.setAttribute("re_level", re_level);
			request.setAttribute("re_step", re_step);
			request.setAttribute("pageNum", pageNum);
			
			System.out.println("---------------------");		
			}catch (Exception e) {
				System.out.println("writeForm Exception =>"+e.getMessage());
			}
		
		return "writeForm.jsp";
	}

}
