package com.ibs.project;

public class Employee {
	private String empId;
	private String empName;
	private int depId;
	private String status;
	private String salary;

	public Employee(String empId, String empName, int depId, String status, String salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.depId = depId;
		this.status = status;
		this.salary = salary;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSalary() {
		return Integer.parseInt(salary);
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", depId=" + depId + ", status=" + status
				+ ", salary=" + salary + "]";
	}

}