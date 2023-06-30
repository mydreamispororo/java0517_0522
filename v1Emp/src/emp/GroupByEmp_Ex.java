package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupByEmp_Ex {

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
			
			//부서별 급여의 합계를 출력
			String query = "select emp_group, sum(emp_salary) from emp group by emp_group";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			
			System.out.println("================================");
			System.out.println("부서명\t\t급여의 총합");
			System.out.println("================================");
			
			if(rs.next()) {
				do {
					System.out.println(rs.getString(1) + "\t\t" + rs.getInt(2));
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
