package emp.domain;

public class Employee {
	private Integer empID;
	private String empPWD;
	private String empBuseoCode;
	
	public Employee() {}
	

	public Integer getEmpID() {
		return empID;
	}

	public void setEmpID(Integer empID) {
		this.empID = empID;
	}

	public String getEmpPWD() {
		return empPWD;
	}

	public void setEmpPWD(String empPWD) {
		this.empPWD = empPWD;
	}

	public String getEmpBuseoCode() {
		return empBuseoCode;
	}

	public void setEmpBuseoCode(String empBuseoCode) {
		this.empBuseoCode = empBuseoCode;
	}
	
	public void disp() {
		System.out.println("===================== 사원 정보 출력 =====================");
		System.out.println("EMPID\t\tEMPPWD\t\tEMPBUSEOCODE");
		System.out.println("------------------------------------------------------");
	};
	
	
	

}
