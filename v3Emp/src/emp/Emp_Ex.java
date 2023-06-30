package emp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import emp.db.DBConnect;

public class Emp_Ex {

	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	public static void main(String[] args) {
//		new 객체마다 메모리 생성
//		static 하나 공유
		
//		DBConnect db = new DBConnect();
//		db.createConnection();
		
//		DBConnect.createConnection();
		
		String empID = "100";
		String empPWD = "1234";
		String empBuseoCode = "K100";
		
		String qurey = "insert into emp values(?, ?, ?)";
		
//		연결 -> 쿼리실행 -> 결과
		
		 try {
			pstmt = DBConnect.createConnection().prepareStatement(qurey);
			pstmt.setString(1, empID);
			pstmt.setString(2, empPWD);
			pstmt.setString(3, empBuseoCode);
			int result = pstmt.executeUpdate();
			
			if(result == 0) {
				System.out.println("사원정보를 입력할 수 없습니다. 관리자에게 문의하셈");
			}else {
				System.out.println("사원정보 등록완료");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
