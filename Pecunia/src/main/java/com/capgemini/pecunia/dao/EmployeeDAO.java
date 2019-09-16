package com.capgemini.pecunia.dao;




import java.text.ParseException;

import com.capgemini.pecunia.model.Employee;

 



 

public interface EmployeeDAO {
    public void initialiseDatabase() throws ParseException;
    public void register(Employee e) throws ParseException;
    public String login(String username, String password) throws ParseException;
    public String forgotPassword(String username, String securityAnswer, String newPassword, String confirmPassword) throws ParseException;
    public String logout(String username);
}