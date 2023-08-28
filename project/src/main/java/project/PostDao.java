package project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PostDao {


	
	Connection conn = null;
	
	private Connection getConnection() throws SQLException {
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
	
	public int insert(Post post) throws SQLException{
		String sql ="INSERT INTO POST (id,title,content,reg_date) values(seq_post_id.NEXTVAL,?,?,sysdate)";
		PreparedStatement pstmt = null;
		int result=0;
	

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getContent());
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("insert 실패");
		}finally {
			if(pstmt != null)pstmt.close();
			if(conn != null)pstmt.close();
		}
		
	
		return result;
	}
}		