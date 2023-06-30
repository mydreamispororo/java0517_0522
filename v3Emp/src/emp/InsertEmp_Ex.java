package emp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import emp.db.DBConnect;
import emp.domain.Employee;

public class InsertEmp_Ex {

	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
//	rs.set타입(db)
//	객체명.set필드명(domain)
	
	public static void main(String[] args) {
		//getter, setter 이용
//		필드, 생성자, getter, setter, 메소드
//		domain -> Employee.java
		
//		DBConnect.createConnection();
		
		int empID = 600;
		String empPWD = "1111";
		String empBuseoCode = "K200";
		
//		캡슐화 + interface + 상속
//		setter에 변수값을 저장 : 객체 생성 -> setter 안에 저장
//		객체명.set필드명(변수명);
		
		Employee emp = new Employee();
		emp.setEmpID(empID);
		emp.setEmpPWD(empPWD);
		emp.setEmpBuseoCode(empBuseoCode);
		
		//사용할 때 : 객체 생성 -> getter
		//객체명.get필드명();
		
		String query = "insert into emp values(?,?,?);";
		try {
			pstmt = DBConnect.createConnection().prepareStatement(query);
			pstmt.setInt(1, emp.getEmpID());
			pstmt.setString(2, emp.getEmpPWD());
			pstmt.setString(3, emp.getEmpBuseoCode());
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("저장");
				
				
				
			}else {
				System.out.println("실패");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
