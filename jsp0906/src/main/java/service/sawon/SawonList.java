 package service.sawon;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import dto.Sawon;
import service.CommandProcess;

public class SawonList implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("sawonList start");
		
		SawonDao sawondao = SawonDao.getInstance();
		try {
			
			int totCnt = sawondao.getTotalCnt(); // 38
			String pageNum = request.getParameter("pageNum");	
			if(pageNum == null || pageNum.equals("")) {pageNum = "1";} 
			int currentPage = Integer.parseInt(pageNum);       // 1         현재 페이지
			int pageSize = 10, blockSize = 10; 
			// pageSize -> 한 페이지에 10개만  blockSize -> 밑에 있는 페이지 번호 블록
			int startRow = (currentPage - 1) * pageSize + 1;   // 1    11   시작하는 rownum
			int endRow   = startRow + pageSize - 1;            // 10   20   끝나는 rownum
			int startNum = totCnt - startRow + 1;              // 게시판 내에서 게시물의 순서에 따라 부여하는 번호의 시작 번호
			List<Sawon> sawonList = sawondao.sawonList(startRow,endRow);
			
			
			int pageCnt = (int)Math.ceil((double)totCnt/pageSize); // 4(3.8올린거) 총 페이지 수
			
			int startPage = (int)(currentPage - 1)/blockSize*blockSize + 1; // 1   페이지 번호 블록의 시작
			int endPage   = startPage + blockSize - 1;                      // 10  페이지 번호 블록의 끝
			// 공갈 Page 방지    10 > 4 --> 페이지 넘버를 4(게시물이 존재하는 페이지)까지만 보여주기 위해서
			if(endPage > pageCnt) endPage = pageCnt;
			
			request.setAttribute("sawonList", sawonList);
			request.setAttribute("totCnt", totCnt);
			

			request.setAttribute("pageNum", pageNum);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("startNum", startNum);
			request.setAttribute("blockSize", blockSize);
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("sawonListService catch error");
			
		} 
		
	
		
		
		return "views/sawon/sawonList.jsp";
	}

}
