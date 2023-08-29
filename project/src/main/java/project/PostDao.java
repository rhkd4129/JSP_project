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
	private static PostDao instance;
	 private PostDao() {
		 
	}
	 
	 public static PostDao getInstance(){
			if(instance == null) {
				instance = new PostDao();
			}
		return instance;
	 }
	
	private Connection getConnection() throws SQLException {
		
		Connection conn = null;
		try {
			Context cxt = new InitialContext();
			DataSource ds = (DataSource)cxt.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			System.out.println("DB연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return conn;
	
	}
	
	
	public ArrayList<Post> selectAll() throws SQLException{
		Connection conn = null;
		ArrayList<Post> pl = new ArrayList<Post>();
		String sql ="select title,content,reg_date from post";
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("aa");
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Post post = new Post();
				post.setTitle(rs.getString(1));
				post.setContent(rs.getString(2));
				post.setRegDate(rs.getDate(3));
				pl.add(post);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("dao오류");
		}
		finally {
			if(rs!= null) rs.close();
			if(stmt!= null) stmt.close();
			if(conn!= null) conn.close();
	
	
		}
		return pl;
		
	}
	
	
	public int insert(Post post) throws SQLException{
		Connection conn = null;
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
