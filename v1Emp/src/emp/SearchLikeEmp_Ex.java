package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchLikeEmp_Ex {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		String dburl = "jdbc:mysql://localhost:3306/employees";
		String dbuser = "employees";
		String dbpwd = "1234";
		
		try {
			conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
			System.out.println("접속 가능");
			System.out.println();
		
//			String searchword = "2023";
//			String query = "select emp_name, emp_regdate from emp where emp_regdate like '%"+ searchword +"%'";
////			변수 + 글자
//			글자 + 변수
			String searchn = "홍";
			String query = "select emp_name, emp_salary from emp where emp_name like '%"+ searchn +"%'";
			//홍으로 시작하는 사람의 이름과 급여를 검색 : 변수 만들어서
			
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			System.out.println("========================");
			System.out.println("사원명\t\t급여");
			System.out.println("========================");
			
			if(rs.next()) {
				do {
					System.out.println(rs.getString(1) + "\t\t" + rs.getInt(2));
					
				}while(rs.next());
				
				
			}else {
				System.out.println("검색결과가 없습니다.");
				System.out.println("----------------------------------");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		

	}

}
