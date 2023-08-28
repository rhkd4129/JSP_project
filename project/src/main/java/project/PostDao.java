package project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	
	public ArrayList<Post> selectAll() throws SQLException{
		ArrayList<Post> pl = new ArrayList<Post>();
		String sql ="select title,content,reg_date from post";
		Statement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			do {
				Post post = new Post();
				post.setTitle(rs.getString(1));
				post.setContent(rs.getString(2));
				post.setRegDate(rs.getDate(3));
				pl.add(post);
			}while(rs.next());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("select 오류");
		}
		return pl;
		
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
