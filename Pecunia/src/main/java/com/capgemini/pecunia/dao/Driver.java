package com.capgemini.pecunia.dao;



	 

	import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.model.*;
	import java.util.*;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;

	 

	public class Driver {

	 

	    public static void main(String[] args) throws ParseException {
	        Scanner sc=new Scanner(System.in);
	        EmployeeDAOimpl edi=new EmployeeDAOimpl();
	        edi.initialiseDatabase();
	        while(true) {
	            System.out.println("Pecunia Login/Register Page ----------------------");
	            System.out.println("Press 1 for register");
	            System.out.println("Press 2 for login");
	            System.out.println("Press 3 in case you have forgotten password and want to change password");
	            System.out.println("Press 4 to display database");
	            System.out.println("Press 5 for logout");
	            System.out.println("Press 6 to see the logged in persons");
	            System.out.println("Press 0 to exit");
	            int choice=Integer.parseInt(sc.nextLine());
	            if(choice==0) {
	                System.out.println("bye");
	                break;
	            }else if(choice==1) {
	                System.out.println("Type empId, empName, designation, gender, dob, emailId, phoneNo, "
	                        + "username, password, "
	                        + "securityQuestion, securityAnswer");
	                
	                String empId=sc.nextLine();
	                System.out.println("entered = "+empId);
	                String empName=sc.nextLine();
	                System.out.println("entered = "+empName);
	                String designation=sc.nextLine();
	                System.out.println("entered = "+designation);
	                String gender=sc.nextLine();
	                System.out.println("entered = "+gender);
	                String dob=sc.nextLine();
	                System.out.println("entered = "+dob);
	                String emailId=sc.nextLine();
	                System.out.println("entered = "+emailId);
	                String phoneNo=sc.nextLine(); 
	                System.out.println("entered = "+phoneNo);
	                String username=sc.nextLine();
	                System.out.println("entered = "+username);
	                String password=sc.nextLine();
	                System.out.println("entered = "+password);
	                String securityQuestion=sc.nextLine();
	                System.out.println("entered = "+securityQuestion);
	                String securityAnswer=sc.nextLine();
	                System.out.println("entered = "+securityAnswer);
	                SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
	                
	                Employee e=new Employee(empId, empName, designation, gender, sdf.parse(dob), emailId, phoneNo, username, Utility.getAlphaNumericString(),password, securityQuestion, securityAnswer);
	                //Employee e=new Employee("E6","Ramesh","Analyst","Male",null,"ramesh46@gmail.com","9112345678","ramesh45","1234","Your nickname?","Ramu");
	                edi.register(e);
	            }
	            else if(choice==2) 
	            {
	                System.out.println("Enter username and password");
	                String username=sc.nextLine();
	                String password=sc.nextLine();
	                System.out.println(edi.login(username,password));
	            }
	            else if(choice==3) 
	            {
	                System.out.println("Enter username");
	                String username=sc.nextLine();
	                int positionInDB=0;
	                List<Employee> employees=Database.getEmployees();
	                boolean foundinDB=false;
	                for(int i=0;i<employees.size();i++) {
	                    if(employees.get(i).getUsername().equals(username)) {
	                        positionInDB=i;
	                        foundinDB=true;
	                        break;
	                    }
	                }
	                if(!foundinDB) 
	                {
	                    System.out.println("Username does not exist");
	                    continue;
	                }
	                System.out.println("Security Question: "+employees.get(positionInDB).getSecurityQuestion());
	                String securityAnswer=sc.nextLine();
	                System.out.println("Type new password:");
	                String newPassword=sc.nextLine();
	                System.out.println("Re-type password:");
	                String confirmPassword=sc.nextLine();
	                System.out.println(edi.forgotPassword(username,securityAnswer,newPassword,confirmPassword));
	            }
	            else if(choice==4) 
	            {
	                List<Employee> employees=Database.getEmployees();
	                for(int i=0;i<employees.size();i++)
	                    System.out.println(employees.get(i));
	            }else if(choice==5) {
	                System.out.println("Enter username");
	                String username=sc.nextLine();
	                System.out.println(edi.logout(username));
	            }else if(choice==6) {
	                List<String> loggedInUsernames=Database.getLoggedInPersons();
	                System.out.print("Logged in Usernames are:");
	                for(int i=0;i<loggedInUsernames.size();i++)
	                    System.out.print(loggedInUsernames.get(i)+" ");
	                System.out.println();
	            }else{
	                System.out.println("Wrong choice!!!");
	            }
	        }
	        sc.close();
	    }

	 

	}

