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
import java.util.HashMap;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.Item;
import dto.Order1;

public class Order1Dao {
private static Order1Dao instance;
	
	private Order1Dao() {}

	public static Order1Dao getInstance(){
		if(instance == null) {
			instance = new Order1Dao();
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
		String sql = "select count(*) from order1";
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
	
	
	
	public ArrayList<Order1>  order1List(int StartRow, int endRow) throws SQLException{
		
		ArrayList<Order1> order1List = new ArrayList<Order1>();
		ResultSet rs = null;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		
			
//		  String sql = "SELECT * FROM (SELECT rownum rn, a.* FROM (SELECT * FROM Order1 ORDER BY sabun DESC) a) " +
//		             "WHERE rn BETWEEN ? AND ?";
//		  
		  String sql_1 = "SELECT * " +
                  "FROM (SELECT ROWNUM rn, a.* " +
                  "      FROM (SELECT o.order_date, c.custname, o.order_desc, s.sawon_name, o.ORDER_STATUS, c.custcode, s.sabun " +
                  "            FROM order1 o " +
                  "            JOIN sawon s ON o.sabun = s.sabun " +
                  "            JOIN custom c ON o.custcode = c.custcode " +
                  "            ORDER BY o.ORDER_DATE DESC) a) " +
                  "WHERE rn BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql_1);
			pstmt.setInt(1, StartRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Order1 order1 = new Order1(); 
				order1.setCustcode(rs.getInt("custcode"));
				order1.setOrder_date(rs.getString("order_date"));
				order1.setOrder_desc(rs.getString("order_desc"));
				order1.setOrder_status(rs.getString("order_status"));
				order1.setSabun(rs.getInt("sabun"));
				order1.setSawon_name(rs.getString("sawon_name"));
				order1.setCustname("custname");
				order1List.add(order1);
		
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("order1ListDao 오류");
		}
		finally {
			if(rs!= null) rs.close();
			if(pstmt!= null) pstmt.close();
			if(conn!= null) conn.close();
		}
		return order1List;
	}
	
	
	
	public int order1Join(Order1 order1) throws SQLException, ParseException {
		int result = 0;
		int number = 0;
		ResultSet rs = null;
		Connection conn = null; 
		PreparedStatement pstmt = null;		
		
		Date currentDate = new Date();
        Timestamp orderDate = new Timestamp(currentDate.getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
        String orderDateAsString = dateFormat.format(currentDate); // 날짜를 문자열로 변환
        
        String sql = "INSERT INTO order1 (custcode, order_date, order_desc, order_status, sabun)"
         		+ "VALUES (?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
		   
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, order1.getCustcode());
			pstmt.setString(2, orderDateAsString);
			pstmt.setString(3, order1.getOrder_desc());
			pstmt.setString(4, order1.getOrder_status());
			pstmt.setInt(5, order1.getSabun());
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("ItemdaoJoin 오류");
		}
		finally {
			if(pstmt!= null) pstmt.close();
			if (rs != null) rs.close(); // Close ResultSet
			if(conn!= null) conn.close();
		}
		return result;

	}
	
	public Order1 order1Detail(String order1_date, int custcode) throws SQLException {
		
		Order1 order1 =  new Order1();
		ResultSet rs = null;
		Connection conn = null; 
//		String sql = "select * from order1 where custcode=? and order_date = ?";
//		
//		String sql_2="select o.order_date, c.custname, o.order_desc, s.sawon_name,o.sabun ,o.ORDER_STATUS"
//				+ "from order1 o "
//				+ "    join sawon s"
//				+ "        on o.sabun = s.sabun"
//				+ "    join custom c"
//				+ "        on o.custcode = c.custcode"
//				+ "    where o.custcode=? and o.order_date=?";

		String sql_2 = "SELECT o.order_date, c.custname, o.order_desc, s.sawon_name, o.sabun, o.ORDER_STATUS "
	            + "FROM order1 o "
	            + "JOIN sawon s "
	            + "ON o.sabun = s.sabun "
	            + "JOIN custom c "
	            + "ON o.custcode = c.custcode "
	            + "WHERE o.custcode = ? AND o.order_date = ?";

		PreparedStatement pstmt = null;
		conn = getConnection();
		pstmt = conn.prepareStatement(sql_2);
		pstmt.setInt(1,custcode);
		pstmt.setString(2,order1_date);
		try {
			rs = pstmt.executeQuery();
			if(rs.next()) {
				order1.setCustcode(custcode);
				order1.setOrder_date(order1_date);
				order1.setCustname(rs.getString("custname"));
				order1.setOrder_desc(rs.getString("order_desc"));
				order1.setSawon_name(rs.getString("sawon_name"));
				order1.setSabun(rs.getInt("sabun"));
				order1.setOrder_status(rs.getString("order_status"));
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("order1Detail dao 오류");
		}
		finally {
			if(rs!= null) rs.close();
			if(pstmt!= null) pstmt.close();
			if(conn!= null) conn.close();
		}
		
		
		return order1;
		
	}
}
