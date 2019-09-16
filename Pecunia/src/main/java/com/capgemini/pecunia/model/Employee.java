package com.capgemini.pecunia.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.capgemini.pecunia.Values;

public class Employee {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeBranchId == null) ? 0 : employeeBranchId.hashCode());
		result = prime * result + ((employeeDesignation == null) ? 0 : employeeDesignation.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + ((employeePassword == null) ? 0 : employeePassword.hashCode());
		result = prime * result + ((employeeSalt == null) ? 0 : employeeSalt.hashCode());
		result = prime * result + ((transId == null) ? 0 : transId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeBranchId == null) {
			if (other.employeeBranchId != null)
				return false;
		} else if (!employeeBranchId.equals(other.employeeBranchId))
			return false;
		if (employeeDesignation == null) {
			if (other.employeeDesignation != null)
				return false;
		} else if (!employeeDesignation.equals(other.employeeDesignation))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (employeePassword == null) {
			if (other.employeePassword != null)
				return false;
		} else if (!employeePassword.equals(other.employeePassword))
			return false;
		if (employeeSalt == null) {
			if (other.employeeSalt != null)
				return false;
		} else if (!employeeSalt.equals(other.employeeSalt))
			return false;
		if (transId == null) {
			if (other.transId != null)
				return false;
		} else if (!transId.equals(other.transId))
			return false;
		return true;
	}
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
		//hii
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
	
	public static Employee getEmployeeObject(String row) {
		// TODO Auto-generated method stub
		String arr[] = row.split(",");
		Employee empl= new Employee(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
		return empl;
	}
	
	@Override
	public String toString() {
		return this.employeeId+" "+this.employeeName+" "+this.employeeBranchId+" "+this.employeeDesignation+" "+this.employeeSalt+
				" "+this.employeePassword+" -"+this.transId;
	}
	
}