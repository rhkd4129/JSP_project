package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sound.midi.Soundbank;
import javax.sql.DataSource;
import java.sql.Connection;
import javax.naming.Context;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import java.sql.Connection;
import javax.naming.Context;


public class BoardDao {
	
	private static BoardDao instance;
	
	private BoardDao() {}

	public static BoardDao getInstance(){
		if(instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	

	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context cxt = new InitialContext();
			DataSource ds = (DataSource)cxt.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return conn;
	
	}
	
	
	 
//	select * from board order by ref desc,re_step
//	--ref 댓글의 그룹 
//	--restep 댓글의단 순서 
//	--re level 1 댓글 2 대댓글
//	--  rownum 순서번호 
//	select rownum  , Board.* from board
	public List<Board> boardList(int StartRow, int endRow) throws SQLException{
		
		List<Board> bl = new ArrayList<Board>();
		ResultSet rs = null;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		
		String sql = "select * from (select rownum rn, a.* from "
				+ "(select * from board order by ref desc, re_step) a ) "
				+ "where rn between ? and ?"; // 
  


		
//		String sql = "SELECT * " +
//	             "FROM (SELECT rownum rn, a.* " 
//	             +"FROM (SELECT rownum, board.* FROM board ORDER BY ref desc, re_step) a) " 
//	             +"WHERE rn BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, StartRow);
			pstmt.setInt(2, endRow);
		
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board(); 
				board.setNum(rs.getInt("num"));
				board.setWriter(rs.getString("writer"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setEmail(rs.getString("email"));
				board.setReadcount(rs.getInt("readcount"));
				board.setRef(rs.getInt("ref"));
				board.setRe_step(rs.getInt("re_step"));
				board.setRe_level(rs.getInt("re_level"));
				board.setIp(rs.getString("ip"));
				board.setReg_date(rs.getDate("reg_date"));
			
				bl.add(board);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("select 오류");
		}
		finally {
			if(rs!= null) rs.close();
			if(pstmt!= null) pstmt.close();
			if(conn!= null) conn.close();
		}
		return bl;
	}
	
	
	
	public void readCount(int num) throws SQLException {
		PreparedStatement pstmt = null;
		Connection conn = null; 
		String sql = "update board set readcount = readcount+1 where num=?"; // Add single quotes around id
		int rs = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("select 오류");
		}finally {
			if(pstmt!= null) pstmt.close();
			if(conn!= null) conn.close();
		}
	}
		
	
	
	public int update(Board board) throws SQLException {
		 int result = 0;
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 System.out.println("dao 접근");
		 String sql = "update board set subject=?, writer=?, email=?, passwd=?, content=? where num=?";
		    try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, board.getSubject());
		        pstmt.setString(2, board.getWriter());
		        pstmt.setString(3, board.getEmail());
		        pstmt.setString(4, board.getPasswd());
		        pstmt.setString(5, board.getContent());
		        pstmt.setInt(6, board.getNum());
		        
		        result = pstmt.executeUpdate();
		    } catch (Exception e) {
		        System.out.println("update Exception" + e.getMessage());
		    } finally {
		        if (conn != null) conn.close();
		    
		        if (pstmt != null) pstmt.close();
		    }
		    return result;
		}
	
	
	
	
	public int insert(Board board) throws SQLException {
	    int result = 0;
	    int number=0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    String sql_1 = "select max(num) from board";
	    String sql_2="UPDATE board SET re_step = re_step+1 WHERE ref=? AND re_step >?";
	    String sql_3 ="INSERT INTO board VALUES(?, ?, ?, ?, ?, ?,?,?,?,?,?, sysdate)";
	    int num = board.getNum();
	    try {
	        conn = getConnection();
	        pstmt = conn.prepareStatement(sql_1);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {number = rs.getInt(1) + 1;}
	        
	        if(num != 0) {
	        	System.out.println("board.getRef()->"+board.getRef());
	        	System.out.println("board.getRe_step(->"+board.getRe_step());
	        	pstmt = conn.prepareStatement(sql_2);
	        	pstmt.setInt(1, board.getRef());
	        	pstmt.setInt(2, board.getRe_step());
	        	pstmt.executeUpdate();
	   
	        	
	        	board.setRe_step(board.getRe_step()+1);
	        	board.setRe_level(board.getRe_level()+1);
	        	System.out.println("-----------------------------------");

	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        System.out.println("오류 1");
	    } 
	    try {
	    	if(num ==0)board.setRef(num);
	    	pstmt = conn.prepareStatement(sql_3);
	    	
	        pstmt.setInt(1, number);
	        pstmt.setString(2, board.getWriter());
	        pstmt.setString(3, board.getSubject());
	        pstmt.setString(4, board.getContent());
	        pstmt.setString(5, board.getEmail());
	        pstmt.setInt(6, board.getReadcount());
	        pstmt.setString(7, board.getPasswd());
	        pstmt.setInt(8, board.getRef());
	        pstmt.setInt(9, board.getRe_step());
	        pstmt.setInt(10, board.getRe_level());
	        pstmt.setString(11, board.getIp());
	        
	        result = pstmt.executeUpdate();
	    } catch (Exception e) {
	        System.out.println("create Exception" + e.getMessage());
	    } finally {
	       
	        if (conn != null) conn.close();
	        if (rs != null) rs.close(); // Close ResultSet
	        if (pstmt != null) pstmt.close();
	    }
	    return result;
	}

		

	public Board select(int num) throws SQLException {
		Board board =  new Board();
		
		ResultSet rs = null;
		Connection conn = null; 
		String sql = "select * from board where num=?"; // Add single quotes around id
		PreparedStatement pstmt = null;
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		try {
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board.setNum(rs.getInt("num"));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				board.setReg_date(rs.getDate("reg_date"));
				board.setReadcount(rs.getInt("readcount"));
				board.setIp(rs.getString("ip"));
				board.setEmail(rs.getString("email"));
				board.setContent(rs.getString("content"));
				
				board.setRef(rs.getInt("ref"));
				board.setRe_level(rs.getInt("re_level"));
				board.setRe_step(rs.getInt("re_step"));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("select 오류");
		}
		finally {
			if(rs!= null) rs.close();
			if(pstmt!= null) pstmt.close();
			if(conn!= null) conn.close();
		}
		
		return board;
	}
	
	public int delete(int num, String passwd) throws SQLException {
		int result = 0;
		String pass;
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		try {
			String sql_1="select * from board where num=?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql_1);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			rs.next();
			pass = rs.getString("passwd");
			pstmt.close();
			if(pass.equals(passwd)) {
				String sql = "DELETE FROM board WHERE num=?";
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setInt(1, num);
		         result = pstmt.executeUpdate();
			}
	      }catch (Exception e) {
			e.printStackTrace();
	         System.out.println(e.getMessage());
	         System.out.
	         println("dao delete오류");
		}finally {
			 if(rs!= null) rs.close();
	         if(pstmt!= null) pstmt.close();
	         if(conn!= null) conn.close();
		}
		return result;
		
	}
	
	
	public int getTotalCnt() throws SQLException {
		int toCont=0;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement  pstmt = null;
		String sql = "select count(*) from board";
		try {
			 conn = getConnection();
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	        	 toCont = rs.getInt(1);
	        	 System.out.println(toCont); 
	         }
	         
		}catch (Exception e) {
			e.printStackTrace();
	         System.out.println(e.getMessage());
	         System.out.println("dao getTotal오류");
		}finally {
			 if(rs!= null) rs.close();
	         if(pstmt!= null) pstmt.close();
	         if(conn!= null) conn.close();
		}
		return toCont;
	}


}
