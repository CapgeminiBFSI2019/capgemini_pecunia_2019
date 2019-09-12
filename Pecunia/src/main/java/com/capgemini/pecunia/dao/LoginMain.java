package com.capgemini.pecunia.dao;

public class LoginMain {
	
	private String username;
	private String password;
	
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

	public LoginMain() {
		
	}

	public LoginMain(String username, String password) {
		
		this.username = username;
		this.password = password;
	}
	
	/*
	 * Method for username validation
	 */
	public static boolean validateLoginUsername(String username) {
		return false;
		
	}
	
	/*
	 * Method for password validation
	 */
	public static boolean validateLoginPassword(String username) {
		return false;
		
	}
	
	
	

	
	
}