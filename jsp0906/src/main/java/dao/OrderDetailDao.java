package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.Order1;
import dto.Order1Detail;

public class OrderDetailDao {
	private static OrderDetailDao instance;
	
	private OrderDetailDao() {}

	public static OrderDetailDao getInstance(){
		if(instance == null) {
			instance = new OrderDetailDao();
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
	
	
	
	public int order1DetailJoin(Order1Detail order1Detail) throws SQLException, ParseException {
		int result = 0;
		int number = 0;
		ResultSet rs = null;
		Connection conn = null; 
		PreparedStatement pstmt = null;		
	
        String sql = "INSERT INTO ORDER1_DETAIL (ORDER_DATE,CUSTCODE,ITEM_CODE,ORDER_ITEM_DESC) VALUES (?, ?, ?, ?, ?)";
         		
		try {
			conn = getConnection();
		   
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, order1Detail.getOrder_date());
			pstmt.setInt(2, order1Detail.getCostcode());
			pstmt.setInt(3, order1Detail.getItem_code());
			pstmt.setString(4, order1Detail.getOrder_item_desc());
		
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("order1DeatilJoin 오류");
		}
		finally {
			if(pstmt!= null) pstmt.close();
			if (rs != null) rs.close(); // Close ResultSet
			if(conn!= null) conn.close();
		}
		return result;

	}
	
	
}
