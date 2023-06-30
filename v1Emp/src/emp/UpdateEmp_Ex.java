package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateEmp_Ex {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dburl = "jdbc:mysql://localhost:3306/employees";
		String dbuser = "employees";
		String dbpwd = "1234";
		
		try {
			conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
			System.out.println("접속완룡");
			System.out.println();
			
			String query = "Update emp set emp_name = ?, emp_salary = ?, emp_group = ?, emp_regdate = now() where emp_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "이동석");
			pstmt.setInt(2, 6000000);
			pstmt.setString(3, "개발부");
			pstmt.setInt(4, 20);
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("사원 정보가 변경되었습니다.");
				
				String sql = "select * from emp order by emp_id desc";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				System.out.println("======================================================================");
				System.out.println("EMP_ID\tEMP_NAME\tEMP_SALARY\tEMP_GROUP\tEMP_REGDATE");
				System.out.println("======================================================================");
				
				if(rs.next()) {
					
					do {
						System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getInt(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getDate(5));
						System.out.println("------------------------------------------------------------------");
					}while(rs.next());
					
				}else {
					System.out.println("등록된 사원이 없습니다.");
				}
			
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		

	}

}
