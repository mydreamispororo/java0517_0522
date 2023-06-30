package emp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	Connection conn = null;
	
	public Connection getConnection() {
		
		String dburl = "jdbc:mysql://localhost:3306/employees";
		String dbuser = "employees";
		String dbpwd = "1234";
		
		try {
			conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
			System.out.println("디비 연결");
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
