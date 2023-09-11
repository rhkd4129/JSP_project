package service.sawon;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import dto.Sawon;
import service.CommandProcess;

public class SawonUpdateProAction implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {

       
        try {
            
            request.setCharacterEncoding("utf-8");
            int sabun = Integer.parseInt(request.getParameter("sabun"));
            int pageNum = Integer.parseInt(request.getParameter("pageNum"));
            String sawon_name = request.getParameter("sawon_name");
			int sal = Integer.parseInt(request.getParameter("sal"));
			String handphone = request.getParameter("handphone");
			
			
			Sawon sawon = new Sawon();
			sawon.setSabun(sabun);
			sawon.setSawon_name(sawon_name);
			sawon.setSal(sal);
			sawon.setHandphone(handphone);
			
			
			SawonDao sawonDao = SawonDao.getInstance();
			int result = sawonDao.update(sawon);
		
			
            request.setAttribute("sabun", sabun);
            request.setAttribute("pageNum", pageNum);
            request.setAttribute("result", result);
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        return "views/sawon/sawonUpdatePro.jsp";
    }
}
