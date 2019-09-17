package com.capgemini.pecunia.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeDAOTest {

	

	@Test
	public void loginUernameNull_Test() {
		
	String username = null;
	assertNull(new EmployeeDAOimpl().login(username, "12345"));
	
	}
	//this is test

	@Test
	public void loginUsernameEmpty_Test() {
		
	String username = "";
	assertNull(new EmployeeDAOimpl().login(username, "12345"));
	
	}
	
	@Test
	public void loginPasswordNull_Test() {
		
	String passwString = null;
	assertNull(new EmployeeDAOimpl().login("rohan", passwString));
	
	}
	
	@Test
	public void loginPasswordEmpty_Test() {
		
	String passString = "";
	assertNull(new EmployeeDAOimpl().login("avishek", passString));
	
	}
	
	
	@Test
	public void loginAllEmpty_Test() {
		
	assertNull(new EmployeeDAOimpl().login("", ""));
	
	}
	
	@Test
	public void loginAllNull_Test() {
		
	assertNull(new EmployeeDAOimpl().login(null, null));
	
	}
	
	
	
	
	
	
	
	
	
	
	
}
