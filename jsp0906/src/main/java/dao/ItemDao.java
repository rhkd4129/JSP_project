package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.Item;
import dto.Item;

public class ItemDao {

private static ItemDao instance;
	
	private ItemDao() {}

	public static ItemDao getInstance(){
		if(instance == null) {
			instance = new ItemDao();
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
		String sql = "select count(*) from Item";
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

	public List<Item> ItemList(int StartRow, int endRow) throws SQLException{
			
			List<Item> ItemList = new ArrayList<Item>();
			ResultSet rs = null;
			Connection conn = null; 
			PreparedStatement pstmt = null;

			  
			  String sql = "SELECT * FROM (SELECT rownum rn, a.* FROM (SELECT * FROM Item ORDER BY item_code DESC) a) " +
			             "WHERE rn BETWEEN ? AND ?";

	
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, StartRow);
				pstmt.setInt(2, endRow);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Item Item = new Item(); 
					Item.setItem_code(rs.getInt("item_code"));
					Item.setItem_name(rs.getString("item_name"));
					Item.setItem_price(rs.getInt("item_price"));
					Item.setItem_kind(rs.getString("item_kind"));
					Item.setItem_desc(rs.getString("item_desc"));
					Item.setItem_birth(rs.getDate("item_birth"));
					ItemList.add(Item);
				}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				System.out.println("ItemListDao 오류");
			}
			finally {
				if(rs!= null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn!= null) conn.close();
			}
			return ItemList;
		}

	public int Itemjoin(Item Item) throws SQLException {
		int result = 0;
		int number = 0;
		ResultSet rs = null;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		String sql_1 = "select max(item_code) from Item";
		String sql_2 ="INSERT INTO Item VALUES(?, ?, ?, ?,?,?, sysdata)";
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql_1);
		    rs = pstmt.executeQuery();
		    if (rs.next()) {number = rs.getInt(1) + 1;}
		   
			pstmt = conn.prepareStatement(sql_2);
			
			pstmt.setInt(1, number);
			pstmt.setString(2, Item.getItem_name());
			pstmt.setInt(3, Item.getItem_price());
			pstmt.setString(4, Item.getItem_kind());
			pstmt.setString(5, Item.getItem_desc());
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
		
	
		
		
		
	
	
	
	
	}
	