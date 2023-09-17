package service.custom;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomDao;
import dao.SawonDao;
import dto.Custom;
import dto.Sawon;
import service.CommandProcess;

public class CustomWriteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CustomWriteProAction");
		try {
			request.setCharacterEncoding("utf-8");
			
			String custname = request.getParameter("custname");
			
			String cust_tel = request.getParameter("cust_tel");
			String cust_gubun = request.getParameter("cust_gubun");
			String cust_ceo = request.getParameter("cust_ceo");
			
			
			Custom custom = new Custom();
			custom.setCustname(custname);
			custom.setCust_tel(cust_tel);
			custom.setCust_gubun(cust_gubun);
			custom.setCust_ceo(cust_ceo);
			
			
			CustomDao customDao = CustomDao.getInstance();
			int result = customDao.customJoin(custom);
			
			if(result ==0) {
				System.out.println("CustomWriteProAction  오류");
			}
			request.setAttribute("result", result);
			
		}catch (Exception e) {
			e.getMessage();}
		
		
		
		return "views/custom/customWritePro.jsp";
	}

}
