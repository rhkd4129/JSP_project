package project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/post_insert")


public class PostInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public PostInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget!!");
		request.getRequestDispatcher("/post_insert.html").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PostDao pd      = PostDao.getInstance();
		String title 	= request.getParameter("title");
		String content  = request.getParameter("content");
		
		Post post = new Post();
		post.setContent(content);
		post.setTitle(title);
		
		try {
			pd.insert(post);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("insert 중 오류 ");
			response.sendRedirect("/post_insert.html");
		}
		request.getRequestDispatcher("/PostListController").forward(request, response);
		
		
	}

}
