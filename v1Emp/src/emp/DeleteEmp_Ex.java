package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteEmp_Ex {

	public static void main(String[] args) {
//		delete from emp where 컬럼 = 삭제할 값;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dburl = "jdbc:mysql://localhost:3306/employees";
		String dbuser = "employees";
		String dbpwd = "1234";
		
		try {
			conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
			System.out.println("Mysql database 연결");
			System.out.println();
			
			int delID = 19;					;
			String query = "delete from emp where emp_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, delID);
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println(delID + "번 사원의 정보가 삭제 되었습니다.");
				
				//한 페이지에 게시물이 다섯개가 표시되도록
				String sql = "select * from emp order by emp_id desc limit 0, 5";
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
				
			}else {
				System.out.println("관리자에게 문의하세요.");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
