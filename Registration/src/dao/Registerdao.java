package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;


public class Registerdao {
	
	public static Bean register(Bean bean) {

		Connection conn=null;
		String url = "jdbc:mysql://localhost:3306/";  
        String dbName="sample";
        String driver="com.mysql.jdbc.Driver";
       
		try {
			 
			Class.forName(driver).newInstance();  
		    conn = DriverManager.getConnection(url+dbName,"root", "admin");
			PreparedStatement ps=null;
			ps=conn.prepareStatement("insert into registration(name,id,age,address,mailid) values(?,?,?,?,?)");
			ps.setString(1, bean.getName());
			ps.setInt(2, bean.getId());
			ps.setInt(3, bean.getAge());
			ps.setString(4, bean.getAddress());
			ps.setString(5, bean.getMailid());
			ps.executeUpdate();
			ps.close();
		} catch (Exception ex) {
			System.out.println( ex);
		} finally {
			
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
				conn = null;
			}
		}
		return bean;
	}
}
