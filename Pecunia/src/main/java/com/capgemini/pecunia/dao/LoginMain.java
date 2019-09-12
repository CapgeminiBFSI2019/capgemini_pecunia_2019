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
		super();
		this.username = username;
		this.password = password;
	}
	
	
	public boolean validateLogin() {
		if(username.equals("capgemini") && password.equals("123")) {
			return true;
		}else return false;
	}

	
	
}