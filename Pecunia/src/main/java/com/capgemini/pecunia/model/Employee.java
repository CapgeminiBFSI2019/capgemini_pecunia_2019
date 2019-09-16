package com.capgemini.pecunia.model;


	import java.util.Date;

	 

	public class Employee {
	    private String empId;
	    private String empName;
	    private String designation; //enum later
	    private String gender; //enum later
	    private Date dob;
	    private String emailId;
	    private String phoneNo;
	    
	    private String username;
	    private String password;
	    private String salt; 
	    public String getSalt() {
			return salt;
		}

		public void setSalt(String salt) {
			this.salt = salt;
		}



		private String securityQuestion;
	    private String securityAnswer;
	    
	    public Employee(String empId, String empName, String designation, String gender, Date dob, String emailId,
	            String phoneNo, String username,String salt, String password, String securityQuestion, String securityAnswer) {
	        this.empId = empId;
	        this.empName = empName;
	        this.designation = designation;
	        this.gender = gender;
	        this.dob = dob;
	        this.emailId = emailId;
	        this.phoneNo = phoneNo;
	        this.username=username;
	        this.salt=salt;
	        this.password=password;
	        this.securityQuestion=securityQuestion;
	        this.securityAnswer=securityAnswer;
	    }
	    
	    
	    public String getSecurityQuestion() {
	        return securityQuestion;
	    }

	 

	    public void setSecurityQuestion(String securityQuestion) {
	        this.securityQuestion = securityQuestion;
	    }

	 

	    public String getSecurityAnswer() {
	        return securityAnswer;
	    }

	 

	    public void setSecurityAnswer(String securityAnswer) {
	        this.securityAnswer = securityAnswer;
	    }

	 

	 

	    public String getUsername() {
	        return username;
	    }

	 

	    public void setUsername(String username) {
	        this.username = username;
	    }

	 

	    public String getPassword() {
	        return password;
	    }

	 

	    public void setPassword(String password) {
	        this.password = password;
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

	 

	    public String getDesignation() {
	        return designation;
	    }

	 

	    public void setDesignation(String designation) {
	        this.designation = designation;
	    }

	 

	    public String getGender() {
	        return gender;
	    }

	 

	    public void setGender(String gender) {
	        this.gender = gender;
	    }

	 

	    public Date getDob() {
	        return dob;
	    }

	 

	    public void setDob(Date dob) {
	        this.dob = dob;
	    }

	 

	    public String getEmailId() {
	        return emailId;
	    }

	 

	    public void setEmailId(String emailId) {
	        this.emailId = emailId;
	    }

	 

	    public String getPhoneNo() {
	        return phoneNo;
	    }

	 

	    public void setPhoneNo(String phoneNo) {
	        this.phoneNo = phoneNo;
	    }

	 

	    @Override
	    public String toString() {
	        return "Employee [empId=" + empId + ", empName=" + empName + ", designation=" + designation + ", gender="
	                + gender + ", dob=" + dob + ", emailId=" + emailId + ", phoneNo=" + phoneNo + ", username=" + username
	                + ", password=" + password + ", securityQuestion=" + securityQuestion + ", securityAnswer="
	                + securityAnswer + "]";
	    }
	}


