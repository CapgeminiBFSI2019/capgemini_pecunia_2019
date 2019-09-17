package com.capgemini.pecunia.dao;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.Values;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;

import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.model.Employee;

public class EmployeeDAOimpl implements EmployeeDAO {

	public static List<Employee> getEmployees() throws IOException {
		Path FILE_PATH = Paths.get(Values.EMPLOYEE_CSV_FILE);
		List<String> fileContent = new ArrayList<>(Files.readAllLines(FILE_PATH, StandardCharsets.UTF_8));
		List<Employee> emplist = new ArrayList<Employee>();
		for (String line : fileContent) {
			Employee emp = Employee.getEmployeeObject(line);
			emplist.add(emp);
		}
		return emplist;
	}

	@Override
	public String login(String username, String password) {
		
	
		
		try {
			if(username==null) {
				throw new Exception(); 
			}
			if(username.equals("")) {
				throw new Exception(); 
			}
			if(password==null) {
				throw new Exception(); 
			}
			if(password.equals("")) {
				throw new Exception(); 
			}
			List<Employee> employees;
			employees = getEmployees();
			for (Employee obj : employees) {
				if (obj.getUsername().equals(username)) {
					String originalhash = obj.getEmployeePassword();
					byte arr[] = Utility.getSHA(password + "" + obj.getEmployeeSalt());
					String hashPassword = Utility.toHexString(arr);
					if (originalhash.equals(hashPassword)) {
						return "Success";
					} else {
						return "Failure";
					}
				}
			}
			return "No emp found";
		} catch (Exception e) {
			
			return null;
		}

	}

	
}
