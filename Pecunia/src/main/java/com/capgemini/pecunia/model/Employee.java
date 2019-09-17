package com.capgemini.pecunia.model;

public class Employee {
	
	private String employeeId;
	private String employeeName;
	private String employeeBranchId;
	private String employeeDesignation;
	private String employeeUsername;
	private String employeePassword;
	private String employeeSalt;
	
	
	
	
	
	public Employee(String employeeId, String employeeName, String employeeBranchId, String employeeDesignation,
			String employeeUsername, String employeePassword, String employeeSalt) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeBranchId = employeeBranchId;
		this.employeeDesignation = employeeDesignation;
		this.employeeUsername = employeeUsername;
		this.employeePassword = employeePassword;
		this.employeeSalt = employeeSalt;
	}



	public String getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}



	public String getEmployeeName() {
		return employeeName;
	}



	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}



	public String getEmployeeBranchId() {
		return employeeBranchId;
	}



	public void setEmployeeBranchId(String employeeBranchId) {
		this.employeeBranchId = employeeBranchId;
	}



	public String getEmployeeDesignation() {
		return employeeDesignation;
	}



	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}



	public String getUsername() {
		return employeeUsername;
	}



	public void setUsername(String username) {
		this.employeeUsername = username;
	}



	public String getEmployeePassword() {
		return employeePassword;
	}



	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}



	public String getEmployeeSalt() {
		return employeeSalt;
	}



	public void setEmployeeSalt(String employeeSalt) {
		this.employeeSalt = employeeSalt;
	}



	public static Employee getEmployeeObject(String row) {
		// TODO Auto-generated method stub
		String arr[] = row.split(",");
		Employee emp = new Employee(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
		return emp;
	}
	
	
}