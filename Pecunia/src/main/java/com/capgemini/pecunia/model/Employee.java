package com.capgemini.pecunia.model;

public class Employee {
	private String employeeId;
	private String employeeName;
	private String employeeBranchId;
	private String employeeDesignation;
	private String employeeSalt;
	private String employeePassword;
	private String transId;
	public Employee(String employeeId, String employeeName, String employeeBranchId, String employeeDesignation,
			String employeeSalt, String employeePassword, String transId) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeBranchId = employeeBranchId;
		this.employeeDesignation = employeeDesignation;
		this.employeeSalt = employeeSalt;
		this.employeePassword = employeePassword;
		this.transId = transId;
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
	public String getEmployeeSalt() {
		return employeeSalt;
	}
	public void setEmployeeSalt(String employeeSalt) {
		this.employeeSalt = employeeSalt;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	
	
}
