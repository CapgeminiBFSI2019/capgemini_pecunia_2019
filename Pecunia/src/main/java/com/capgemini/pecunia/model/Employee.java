package com.capgemini.pecunia.model;
//field declaration of class employee
public class Employee {
	
	private String id;
	private String name;
	private String branchId;
	private String designation;
	private String username;
	private String password;
	private String salt;
	
	
	
	
//parametrized constructor	
	public Employee(String id, String name, String branchId, String designation, String username, String password,
			String salt) {
		super();
		this.id = id;
		this.name = name;
		this.branchId = branchId;
		this.designation = designation;
		this.username = username;
		this.password = password;
		this.salt = salt;
	}



//getters and setters
	
	public String getId() {
		return id;
	}



	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBranchId() {
		return branchId;
	}



	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public String getUsername() {
		return username;
	}



	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getSalt() {
		return salt;
	}



	public void setSalt(String salt) {
		this.salt = salt;
	}



	

//function to fetch data from csv file and store in the arraylist, separated by a comma
	public static Employee getEmployeeObject(String row) {
		// TODO Auto-generated method stub
		String arr[] = row.split(",");
		Employee emp = new Employee(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
		return emp;
	}



	
	
	
	
}