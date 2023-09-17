package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.Item;
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
		
		Connection conn = null; 
		PreparedStatement pstmt = null;		
	
        String sql = "INSERT INTO ORDER1_DETAIL (ORDER_DATE,CUSTCODE,ITEM_CODE,ITEM_ORDER_DESC,CANCEL,ITEMCOUNT) VALUES (?, ?, ?,?, ?, ?)";
         		
		try {
			conn = getConnection();
		   
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, order1Detail.getOrder_date());
			pstmt.setInt(2, order1Detail.getCostcode());
			pstmt.setInt(3, order1Detail.getItem_code());
			pstmt.setString(4, order1Detail.getOrder_item_desc());
			pstmt.setString(5, order1Detail.getCancel());
			pstmt.setInt(6, order1Detail.getItem_count());
		
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("order1DeatilJoin 오류");
		}
		finally {
			if(pstmt!= null) pstmt.close();
			if(conn!= null) conn.close();
		}
		return result;

	}
	
	public ArrayList<Order1Detail> order1DetailList(int StartRow, int endRow) throws SQLException{
		
		ArrayList<Order1Detail> order1detailList = new ArrayList<Order1Detail>();
		ResultSet rs = null;
		Connection conn = null; 
		PreparedStatement pstmt = null;

		  
		  String sql = "SELECT * FROM (SELECT rownum rn, a.*"
		  		+ "    FROM (SELECT * FROM order1_detail ORDER BY item_code DESC) a)"
		  		+ "	   WHERE rn BETWEEN ? AND ?";


		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, StartRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Order1Detail order1Detail = new Order1Detail();
				order1Detail.setCostcode(rs.getInt("custcode"));
				order1Detail.setItem_code(rs.getInt("item_code"));
				order1Detail.setOrder_date(rs.getString("order_date"));
				order1Detail.setOrder_item_desc(rs.getString("item_order_desc"));
				order1Detail.setCancel(rs.getString("cancel"));
				order1Detail.setItem_count(rs.getInt("item_count"));
				
//				Item.setItem_code(rs.getInt("item_code"));
				
				order1detailList.add(order1Detail);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("order1detailList  오류");
		}
		finally {
			if(rs!= null) rs.close();
			if(pstmt!= null) pstmt.close();
			if(conn!= null) conn.close();
		}
		return order1detailList;
	}
	
	
	
	
}
