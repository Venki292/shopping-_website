package com.shopNest.dbHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shopNest.product.Product;

public class DataFetcher {

	public static String fetchPassword(String uname) {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="venki292";
		String sql="SELECT pass FROM customer WHERE uname=?";
		String dbPass="";
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			rs.next();
			dbPass=rs.getString(1);
		}catch(Exception e) {
			System.out.println("Login issues");
			e.printStackTrace();
		}
		return dbPass;
	}
	
	
	public static List<String> fetchUsersInfo() {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="venki292";
		String sql="SELECT uname,mail,gender,address FROM customer";
		List<String> ulist=new ArrayList<String>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, user, password);
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				String temp=rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4);
				ulist.add(temp);
			}
			
		}catch(Exception e){
			System.out.println("Problem in Login");
		}			
		return ulist;
	}
	
	
	
	
	public static List<String> fetchProductsInfo() {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="venki292";
		String sql="SELECT pid,pname,pdesc,price,pimg FROM products";
		List<String> ilist=new ArrayList<String>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, user, password);
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				String temp=""+rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getInt(4)+":"+rs.getString(5);
				ilist.add(temp);
			}
			
		}catch(Exception e){
			System.out.println("Problem in fetching product");
			e.printStackTrace();
		}			
		return ilist;
	}
	
	@SuppressWarnings("finally")
	public static Product getProductById(int pid) {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="venki292";
		String sql="SELECT pname,price FROM products WHERE pid=?";
		Product p=null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String pname=rs.getString(1);
			int price=rs.getInt(2);
			
			p=new Product(pid,pname,price);
		}catch(Exception e){
			System.out.println("Problem in fetching product by id");
			e.printStackTrace();
		}			
		finally {
			return p;
		}
	}

}
