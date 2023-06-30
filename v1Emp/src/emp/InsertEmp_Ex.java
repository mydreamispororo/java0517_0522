package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertEmp_Ex {

	public static void main(String[] args) {
		//INSERT INTO 테이블명(컬럼1, 컬럼2..) VALUES(값1, 값2..);
		
		//INSERT INTO 테이블명 SET 컬럼1 = 값1, 컬럼2 = 값2..
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbURL = "jdbc:mysql://localhost:3306/employees";
		String dbUser = "employees";
		String dbPwd = "1234";
		
		try {
			conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
			System.out.println("Mysql " + dbUser + "에 접속이 가능합니다.");
			System.out.println();
			
			String query = "insert into emp(emp_name, emp_salary, emp_group, emp_regdate) values(?, ?, ?, now());";
			pstmt = conn.prepareStatement(query);
			pstmt.setNString(1, "마동석");
			pstmt.setInt(2, 3500000);
			pstmt.setString(3, "자재과");
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("사원 등록이 완료되었습니다.");
				
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
