
<%@page import="project.PostDao"%>
<%@page import="project.Post"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
			String chk="";
			String title   = request.getParameter("title");
			String content = request.getParameter("content");
			out.println(title);
			
		
			
			Post post = new Post();
		
			PostDao pd = new PostDao();
			
			post.setContent(content);
			post.setTitle(title);
			
			
			
			
			int result =pd.insert(post);
			if(result >0 ) chk="success";
			else		   chk="fail";
			
			request.setAttribute("chk", chk);
			
			RequestDispatcher rd = request.getRequestDispatcher("insertResult.jsp");
			rd.forward(request, response);
	%>
</body>
</html>
