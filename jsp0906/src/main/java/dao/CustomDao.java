package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.Custom;
import dto.Item;
import dto.Sawon;

public class CustomDao {
	private static final int Integer = 0;
	private static CustomDao instance;
	
	private CustomDao() {}

	public static CustomDao getInstance(){
		if(instance == null) {
			instance = new CustomDao();
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
	
	
	
	
	public int getTotalCnt() throws SQLException {
		int toCont=0;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement  pstmt = null;
		String sql = "select count(*) from custom";
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
	
	public HashMap<Integer, String>  getCustomCode() throws SQLException{
		HashMap<Integer, String> fkCustomList = new HashMap<Integer, String>();
		int custcode =0;
		String custname="";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement  pstmt = null;
		String sql ="select custcode,custname from custom";
		
		try {
			 conn = getConnection();
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	        	 custcode = rs.getInt(1);
	        	 custname= rs.getString(2);
	        	 fkCustomList.put(custcode, custname);
	        	 
	         }
		}catch (Exception e) {
			e.printStackTrace();
	         System.out.println(e.getMessage());
	         System.out.println("dao getCustomCode오류");
		}finally {
			 if(rs!= null) rs.close();
	         if(pstmt!= null) pstmt.close();
	         if(conn!= null) conn.close();
		}
		
		return fkCustomList;
	}	
	
	
	public List<Custom> customList(int StartRow, int endRow) throws SQLException{
		
		List<Custom> customList = new ArrayList<Custom>();
		ResultSet rs = null;
		Connection conn = null; 
		PreparedStatement pstmt = null;

		  
		  String sql = "SELECT * FROM (SELECT rownum rn, a.* FROM (SELECT * FROM custom ORDER BY custcode DESC) a) " +
		             "WHERE rn BETWEEN ? AND ?";


		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, StartRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Custom custom = new Custom(); 
				custom.setCustcode(rs.getInt("custcode"));
				custom.setCustname(rs.getString("custname"));
				custom.setCust_tel(rs.getString("cust_tel"));
				custom.setCust_gubun(rs.getString("cust_gubun"));
				custom.setCust_ceo(rs.getString("cust_ceo"));
			
				customList.add(custom);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("customListDao 오류");
		}
		finally {
			if(rs!= null) rs.close();
			if(pstmt!= null) pstmt.close();
			if(conn!= null) conn.close();
		}
		return customList;
	}
	
	public int customJoin(Custom custom) throws SQLException {
		int result = 0;
		int number = 0;
		ResultSet rs = null;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		String sql_1 = "select max(custcode) from custom";
		String sql_2 ="INSERT INTO Custom VALUES(?, ?, ?, ? ,?)";
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql_1);
		    rs = pstmt.executeQuery();
		    if (rs.next()) {number = rs.getInt(1) + 1;}
		    System.out.println(number);
			pstmt = conn.prepareStatement(sql_2);
			pstmt.setInt(1, number);
			pstmt.setString(2, custom.getCustname());
			pstmt.setString(3, custom.getCust_tel());
			pstmt.setString(4, custom.getCust_gubun());
			pstmt.setString(5, custom.getCust_ceo());
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("customJoin 오류");
		}
		finally {
			
			if(pstmt!= null) pstmt.close();
			if (rs != null) rs.close(); // Close ResultSet
			if(conn!= null) conn.close();
		}
		return result;
	}
	
	public Custom customDetail(int custcode) throws SQLException {
		
		Custom custom = new Custom();
		ResultSet rs = null;
		Connection conn = null; 
		String sql = "select * from custom where custcode=?"; 
		PreparedStatement pstmt = null;
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,custcode);
		try {
			rs = pstmt.executeQuery();
			if(rs.next()) {
				custom.setCustcode(custcode);
				custom.setCustname(rs.getString("custname"));
				custom.setCust_tel(rs.getString("cust_tel"));
				custom.setCust_gubun(rs.getString("cust_gubun"));
				custom.setCust_ceo(rs.getString("cust_ceo"));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("customDetail dao 오류");
		}
		finally {
			if(rs!= null) rs.close();
			if(pstmt!= null) pstmt.close();
			if(conn!= null) conn.close();
		}
		
		return custom;
	}
	
}

