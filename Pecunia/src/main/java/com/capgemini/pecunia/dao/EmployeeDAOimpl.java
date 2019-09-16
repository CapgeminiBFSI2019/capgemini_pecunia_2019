package com.capgemini.pecunia.dao;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;

import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.model.Database;
import com.capgemini.pecunia.model.Employee;

public class EmployeeDAOimpl implements EmployeeDAO {

	public void initialiseDatabase() throws ParseException {
		Database.setEmployees();
	}

	public void register(Employee e) throws ParseException {
		Database.addEmployee(e);
	}

	public String login(String username, String password) throws ParseException {

		List<Employee> employees = Database.getEmployees();
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getUsername().equals(username)) {
				String usersalt = employees.get(i).getSalt();
				String hashPassword;
				try {
					byte arr[] = Utility.getSHA(password +"" +usersalt);
					hashPassword = Utility.toHexString(arr);
					System.out.println(employees.get(i).getPassword());
					System.out.println(hashPassword);
				
					System.out.println(employees.get(i).getEmpId());
					if (employees.get(i).getPassword().equals(hashPassword)) {
						if (!Database.getLoggedInPersons().contains(username)) {
							Database.addLoggedInPerson(username);
							return "Login Successful";
						} else
							return "You are already logged in.";
					} else
						return "Password is incorrect.";
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		return "Username does not exist. Please Register first!!!";
	}

	public String forgotPassword(String username, String securityAnswer, String newPassword, String confirmPassword)
			throws ParseException {
		List<Employee> employees = Database.getEmployees();
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getUsername().equals(username)) {
				if (employees.get(i).getSecurityAnswer().equals(securityAnswer)) {
					if (newPassword.equals(confirmPassword)) {
						employees.get(i).setPassword(newPassword);
						return "Password changed successfully";
					} else
						return "Passwords do not match!!!";
				} else
					return "Wrong Answer!!! Try again!!!";
			}
		}
		return "Username does not exist. Please Register first!!!";
	}

	public String logout(String username) {
		List<Employee> employees = Database.getEmployees();
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getUsername().equals(username)) {
				if (Database.getLoggedInPersons().contains(username)) {
					Database.getLoggedInPersons().remove(username);
					return "Logged out successfully!!!";
				} else
					return "You have to login first.";
			}
		}
		return "You are not a registered user.";
	}
}
