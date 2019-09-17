package com.capgemini.pecunia.dao;
<<<<<<< HEAD




=======
>>>>>>> 89dc317358bdd500256f827f770d2444a1d327aa
import java.text.ParseException;

import com.capgemini.pecunia.model.Employee;

<<<<<<< HEAD
 



 

=======
>>>>>>> 89dc317358bdd500256f827f770d2444a1d327aa
public interface EmployeeDAO {
    public void initialiseDatabase() throws ParseException;
    public void register(Employee e) throws ParseException;
    public String login(String username, String password) throws ParseException;
    public String forgotPassword(String username, String securityAnswer, String newPassword, String confirmPassword) throws ParseException;
    public String logout(String username);
}