package emp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import emp.db.DBConnect;
import emp.domain.Employee;

public class EmployeeDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//입력
	public void insertEmp(Employee emp) {
		String query = "insert into emp values(?,?,?)";
		
		try {
			pstmt = DBConnect.createConnection().prepareStatement(query);
			pstmt.setInt(1, emp.getEmpID());
			pstmt.setString(2, emp.getEmpPWD());
			pstmt.setString(3, emp.getEmpBuseoCode());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("사원 등록완료");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//출력
	public void selectEmp() {
		String query = "select * from emp order by emp_id asc";
		try {
			pstmt = DBConnect.createConnection().prepareStatement(query);
			rs = pstmt.executeQuery();
			
			System.out.println("사원 목록을 출력합니다.");
			System.out.println("------------------------------");
			
			
			if(rs.next()) {
				
				do {
					System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
				
				}while(rs.next());
			
			}else {
				System.out.println("사원을 등록해주세요.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//삭제
	public void deleteEmp(int del) {
		String query = "delete from emp where emp_id = ?";
		
		try {
			pstmt = DBConnect.createConnection().prepareStatement(query);
			pstmt.setInt(1, del);
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//수정
	public void updateEmp(Employee emp) {
		String query = "update emp set emp_pwd = ?, emp_buseo_code = ? where emp_id = ?";
		try {
			pstmt = DBConnect.createConnection().prepareStatement(query);
			pstmt.setString(1, emp.getEmpPWD());
			pstmt.setString(2, emp.getEmpBuseoCode());
			pstmt.setInt(3, emp.getEmpID());
			pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
