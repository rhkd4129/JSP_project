package service;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Board;
import dao.BoardDao;

public class UpdateProAction implements CommandProcess {

    @Override
    public String reqeuestPro(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        System.out.println("post!!!!!");
        try {
            System.out.println("try!!!!!");
            request.setCharacterEncoding("utf-8");
            int num = Integer.parseInt(request.getParameter("num"));
            System.out.println(num);

            String pageNum = request.getParameter("pageNum");
            String writer = request.getParameter("writer");
            String email = request.getParameter("email");
            String subject = request.getParameter("subject");
            String passwd = request.getParameter("passwd");
            String content = request.getParameter("content");
            
          
            BoardDao bd = BoardDao.getInstance();
            Board board = new Board();
   
            board.setNum(num);
            board.setWriter(writer);
            board.setEmail(email);
            board.setContent(content);
            board.setSubject(subject);
            board.setPasswd(passwd);
            board.setReadcount(0);
       
            int result = bd.update(board); 
            request.setAttribute("num",board.getNum());
            request.setAttribute("pageNum", pageNum);
            request.setAttribute("result", result);
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        return "updatePro.jsp";
    }
}
