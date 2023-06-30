package emp;

import java.util.Scanner;

import emp.dao.EmployeeDao;
import emp.domain.Employee;

public class Main_EX {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeDao dao = new EmployeeDao();
		Employee emp = null;
		
		System.out.print("선택 > ");
		int choice = sc.nextInt();
		
		
		//입력
		if(choice == 1) {
			System.out.println();			
		
		int empID = 800;
		String empPWD = "12345";
		String empBuseoCode = "K100";
		
		//저장
//		dao.insertEmp(empID, empPWD, empBuseoCode);
		emp = new Employee();
		emp.setEmpID(empID);
		emp.setEmpPWD(empPWD);
		emp.setEmpBuseoCode(empBuseoCode);
		
		dao.insertEmp(emp);
		
		dao.selectEmp();
		
		}else if(choice == 2) { //출력
			dao.selectEmp();
		}else if(choice == 3) { //삭제
			System.out.print("번호 > ");
			int del = sc.nextInt();
			
			dao.deleteEmp(del);
			dao.selectEmp();
		}else if(choice == 4) { //수정
			
			int empID = 100;
			String empPWD = "1122";
			String empBuseoCode = "K500";
			
			emp = new Employee();
			emp.setEmpID(empID);
			emp.setEmpPWD(empPWD);
			emp.setEmpBuseoCode(empBuseoCode);
			
			dao.updateEmp(emp); //매개변수 만들지 x
			System.out.println("-----------------------");
			dao.selectEmp();
			
			
		}
		
		//출력
		
		
		
	}

}
