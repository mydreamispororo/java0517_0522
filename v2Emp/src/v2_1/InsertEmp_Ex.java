package v2_1;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import emp.db.DBConnect;

public class InsertEmp_Ex {

	static PreparedStatement pstmt = null;

	public static void main(String[] args) {
		DBConnect dbc = new DBConnect();
		dbc.getConnection();
		
		String query = "insert into emp(emp_name, emp_salary, emp_group, emp_regdate) values(?, ?, ?, now())";
		
		try {
			pstmt = dbc.getConnection().prepareStatement(query);
			pstmt.setString(1, "내월급");
			pstmt.setInt(2, 5000000);
			pstmt.setString(3, "개발팀");
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("사원정보 저장됨ㅇㅇ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
