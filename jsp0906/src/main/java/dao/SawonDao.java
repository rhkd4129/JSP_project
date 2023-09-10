package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import dto.Sawon;

import javax.naming.Context;
import javax.naming.InitialContext;

import java.util.ArrayList;
import java.util.List;




public class SawonDao {
	
	private static SawonDao instance;
	
	private SawonDao() {}

	public static SawonDao getInstance(){
		if(instance == null) {
			instance = new SawonDao();
		}
		return instance;
	}
	
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context cxt = new InitialContext();
			DataSource ds = (DataSource)cxt.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return conn;
		}
	
	public List<Sawon> sawonList(int StartRow, int endRow) throws SQLException{
			
			List<Sawon> sawonList = new ArrayList<Sawon>();
			ResultSet rs = null;
			Connection conn = null; 
			PreparedStatement pstmt = null;
			String sql = "select * from sawon";
			
	
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Sawon sawon = new Sawon(); 
					sawon.setSabun(rs.getInt("sabun"));
					sawon.setSal(rs.getInt("sal"));
					sawon.setSawon_name(rs.getString("sawon_name"));
					sawon.setHandphone(rs.getString("handphone"));
					
					sawonList.add(sawon);
				}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				System.out.println("sawonListDao 오류");
			}
			finally {
				if(rs!= null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn!= null) conn.close();
			}
			return sawonList;
		}

	public int join(Sawon sawon) throws SQLException {
		int result = 0;
		int number = 0;
		ResultSet rs = null;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		String sql_1 = "select max(sabun) from sawon";
		String sql_2 ="INSERT INTO sawon VALUES(?, ?, ?, ?)";
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql_1);
		    rs = pstmt.executeQuery();
		    if (rs.next()) {number = rs.getInt(1) + 1;}
		    System.out.println(number);
			pstmt = conn.prepareStatement(sql_2);
			pstmt.setInt(1, number);
			pstmt.setString(2, sawon.getSawon_name());
			pstmt.setInt(3, sawon.getSal());
			pstmt.setString(4, sawon.getHandphone());
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("sawondaoJoin 오류");
		}
		finally {
			
			if(pstmt!= null) pstmt.close();
			if (rs != null) rs.close(); // Close ResultSet
			if(conn!= null) conn.close();
		}
		
		
		
		return result;
		
		
	}
		
	
		
		
		
	
	
	
	
	}
	