package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountEmp_Ex {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dburl = "jdbc:mysql://localhost:3306/employees";
		String dbuser = "employees";
		String dbpwd = "1234";
		
		try {
			conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
			System.out.println("Mysql Database " + dbuser + "에 접속이 가능합니다.");
			System.out.println();
			
			//사원수 합계를 출력
			String query = "select count(emp_id) from emp";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			
			System.out.println("================================");
			System.out.println("부서명\t\t사원의 총합");
			System.out.println("================================");
			
			if(rs.next()) {
				do {
					System.out.println("사원명 : " + rs.getInt(1));
					System.out.println("-----------------------------");
					
				}while(rs.next());
				
			}else {
				System.out.println("등록된 사원이 없습니다.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
