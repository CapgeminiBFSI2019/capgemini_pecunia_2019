package com.capgemini.pecunia.service;

import com.capgemini.pecunia.dao.EmployeeDAOimpl;

public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public void login(String username, String password) {
		// TODO Auto-generated method stub
		EmployeeDAOimpl employeeDAOimpl = new EmployeeDAOimpl();
		employeeDAOimpl.login(username, password);
	}

}
