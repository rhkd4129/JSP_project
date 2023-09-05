package service;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board;
import dao.BoardDao;

public class WriteProAction implements CommandProcess {
	// 1. num , pageNum, writer ,  email , subject , passwd , content   Get
			// 2. Board board 생성하고 Value Setting
			// 3. BoardDao bd Instance
	        // 4 int result = bd.insert(board);
			// ref->num settgin
	        // 5. request 객체에 result, num , pageNum  post
	@Override
	public String reqeuestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
			
		System.out.println("post?");
		try {
			request.setCharacterEncoding("utf-8");
			int num =Integer.parseInt(request.getParameter("num"));
			System.out.println("->"+num);
			int ref = Integer.parseInt(request.getParameter("ref"));
			int re_level = Integer.parseInt(request.getParameter("re_level"));
			int re_step = Integer.parseInt(request.getParameter("re_step"));
			
			String pageNum = request.getParameter("pageNum");
			String writer = request.getParameter("writer");
			String email = request.getParameter("email");
			String subject = request.getParameter("subject");
			String passwd = request.getParameter("passwd");
			String content = request.getParameter("content");
			
		
			
			BoardDao bd = BoardDao.getInstance();
			Board board = new Board();
			
			board.setNum(num);
			board.setRef(ref);
			board.setRe_level(re_level);
			board.setRe_step(re_step);
			board.setWriter(writer);
			board.setEmail(email);
			board.setContent(content);
			board.setSubject(subject);
			board.setPasswd(passwd);
			board.setReadcount(0);
			board.setRef(ref);
			board.setRe_level(re_level);
			board.setRe_step(re_step);
			board.setIp(request.getRemoteAddr());
			
			
			int result = bd.insert(board);
			
			if(result ==0) {
				System.out.println("오류");
			}
			request.setAttribute("result", result);
			
		}catch (Exception e) {
			e.getMessage();}
		
		
		return "writePro.jsp";
	}

}
