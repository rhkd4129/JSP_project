package service;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board;
import dao.BoardDao;

public class AjaxGetDeptNameAction implements CommandProcess {

	@Override
	public String reqeuestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		// 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8 ");
		try {
			int num = Integer.parseInt(  request.getParameter("num"));
			BoardDao bd = BoardDao.getInstance();
			Board board  = bd.select(num);
			request.setAttribute("writer", board.getWriter());
			
		} catch (Exception e) {
		}
		// ajax경우 --> 더이 retrun
		return "ajax";
	}

}
