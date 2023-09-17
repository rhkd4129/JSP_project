package service.order1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomDao;
import dao.SawonDao;
import dto.Sawon;
import service.CommandProcess;

public class Order1WriteFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Date date  = new Date();
		request.setAttribute("time",date);
		int sabun = Integer.parseInt(request.getParameter("sabun")); 
		String name="";
		
		
		HashMap<Integer,String> fkCustomLists = new HashMap<Integer,String>();
		try {
			SawonDao sawonDao = SawonDao.getInstance();
			CustomDao customDao = CustomDao.getInstance();
			fkCustomLists = customDao.getCustomCode();
			name = sawonDao.getName(sabun);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
//		System.out.println(CustomCodeList);
		request.setAttribute("fkCustomLists", fkCustomLists);
		request.setAttribute("name", name);
		request.setAttribute("sabun", sabun);
		return "views/order1/order1WriteForm.jsp";
	}

}
