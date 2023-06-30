package v2_1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import emp.db.DBConnect;

public class SelectEmp {
	
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public static void main(String[] args) {
		DBConnect dbc = new DBConnect();
		dbc.getConnection();
		
		String query = "select * from emp order by emp_id desc";
		try {
			pstmt = dbc.getConnection().prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				do {
					System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2));
				}while(rs.next());
				
			}else {
				System.out.println("사원 정보가 존재안한다.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
