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
import dto.Sawon;
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
		ResultSet rs = null;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		String sql_2 = "INSERT INTO Item VALUES(ITEM_CODE_SEQ.nextval, ?, ?, ?, ?, SYSDATE)";
		
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql_2);
			
//			pstmt.setInt(1, number);
			pstmt.setString(1, Item.getItem_name());
			pstmt.setInt(2, Item.getItem_price());
			pstmt.setString(3, Item.getItem_kind());
			pstmt.setString(4, Item.getItem_desc());
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
		
	
	public Item itemDetail(int item_code) throws SQLException {
		Item item =  new Item();
		
		ResultSet rs = null;
		Connection conn = null; 
		String sql = "select * from item where item_code=?"; 
		PreparedStatement pstmt = null;
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,item_code);
		try {
			rs = pstmt.executeQuery();
			if(rs.next()) {
				item.setItem_code(item_code);
				item.setItem_name(rs.getString("item_name"));
				item.setItem_price(rs.getInt("item_price"));
				item.setItem_kind(rs.getString("item_kind"));
				item.setItem_desc(rs.getString("item_desc"));
				item.setItem_birth(rs.getDate("item_birth"));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("itemDetail dao 오류");
		}
		finally {
			if(rs!= null) rs.close();
			if(pstmt!= null) pstmt.close();
			if(conn!= null) conn.close();
		}
		
		return item;
	}
		
	public int update(Item item) throws SQLException {
		 int result = 0;
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 String sql = "UPDATE item SET item_name=?, item_kind=?, item_desc=?, "
		 		+ "item_price=?, item_birth=sysdate WHERE item_code=?";

		    try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
		        
		        pstmt.setString(1, item.getItem_name());
		        pstmt.setString(2, item.getItem_kind());
		        pstmt.setString(3, item.getItem_desc());
		        pstmt.setInt(4, item.getItem_price());
		        pstmt.setInt(5, item.getItem_code());
	
		        result = pstmt.executeUpdate();
		    } catch (Exception e) {
		        System.out.println("update Exception" + e.getMessage());
		    } finally {
		        if (conn != null) conn.close();
		        if (pstmt != null) pstmt.close();
		    }
		    return result;
		}
		
	public int delete(int item_code) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		try {
//			String sql_1="select * from sawon where sabun=?";
			String sql_2 = "DELETE FROM item WHERE item_code=?";
			conn = getConnection();
//			pstmt = conn.prepareStatement(sql_1);
//			pstmt.setInt(1, num);
//			rs = pstmt.executeQuery();
//			rs.next();
		    pstmt = conn.prepareStatement(sql_2);
		    pstmt.setInt(1, item_code);
		    result = pstmt.executeUpdate();
			
	      }catch (Exception e) {
			e.printStackTrace();
	         System.out.println(e.getMessage());
	         System.out.
	         println("itemdao delete오류");
		}finally {
			 if(rs!= null) rs.close();
	         if(pstmt!= null) pstmt.close();
	         if(conn!= null) conn.close();
		}
		return result;
		
	}
	
	
	public ArrayList<Item> getItemnames() throws SQLException {
		ArrayList<Item> getItemnameList = new ArrayList<>();
		int result = 0;
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null; 
		String sql = "select item_name,item_code from item";

		
	try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);	
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Item Item = new Item(); 
			Item.setItem_code(rs.getInt("item_code"));
			Item.setItem_name(rs.getString("item_name"));
			getItemnameList.add(Item);
		}
	}catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		System.out.println("getItemnames 오류");
	}
	finally {
		if(rs!= null) rs.close();
		if(pstmt!= null) pstmt.close();
		if(conn!= null) conn.close();
	}
	
		return getItemnameList;
		}
	}
	