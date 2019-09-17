package com.capgemini.pecunia.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.pecunia.dao.DbFiles.*;
public class Database {
	static SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
	static List<Employee> empList = new ArrayList<>();   
    static List<String> loggedInEmployees=new ArrayList<>();
   
    public static List<String> getLoggedInPersons() {
        return Database.loggedInEmployees;
    }
   
    public static void addLoggedInPerson(String username) {
        Database.loggedInEmployees.add(username);
    }
   
    public static void setEmployees() throws ParseException {     
<<<<<<< HEAD
        empList.add(new Employee("PPEFqkku8cDl2WBrWaFr","Kumar Saurabh","Manager","Male",sdf.parse("20-03-1975"),"saurabh5881@gmail.com", "1000000000","saurabh5881","JVAbtY04yg","75f3de42d977160d7a08f78fb86588a4a742333bc88fcf6bc0f90d8f3e7b9139","What is your nickname?","Bewra"));
        empList.add(new Employee("c3R7kIDYfBSlrnaFaHjy","Rohit Kumar","Manager","Male",sdf.parse("10-06-1980"),"rohit@gmail.com", "2000000000","rohit","0Kqa3SC2I0","cabbf0cd5a2d958fbaf0e51bd79c452a7f73cb3e17a4321ef3e66edb7583a427","What is your favourite colour","Black"));
        empList.add(new Employee("PhaVIjDHlVqXlqSrc7mI","Rohan","Worker","Male",sdf.parse("07-06-1985"),"rohan@gmail.com", "3000000000","rohan","zu05dWA5Tu","9c91f8f98c9d6bebbdf1f318176782c042faf123052ecc0ddf413808bb3c8568","Which is the best car ever?","Lamborghini"));
        empList.add(new Employee("rWksFD8a9fKXs2feaZhM","Anish","Worker","Female",sdf.parse("24-04-1990") ,"anish@gmail.com", "4000000000","anish","I33fBoQFUc","75295b71d6b19d189032ab271bc0accfb1e10f350f9228ce596576d1ec118100","Which is your favourite brand of handbag?","Gucci"));
        empList.add(new Employee("aajihz6OtMbF9Ci8FO6o","Avishek","Worker","Male",sdf.parse("30-08-1995") ,"avishek@gmail.com", "5000000000","avishek","350DvoE7Pj","c90ddd7aa52d480caf99c1f0211a57f5df0794926eb23aab9c796722c9344f6","Which is your favourite subject?","DSA"));
=======
//        empList.add(new Employee("PPEFqkku8cDl2WBrWaFr","Kumar Saurabh","Manager","Male",sdf.parse("20-03-1975"),"saurabh5881@gmail.com", "1000000000","saurabh5881","JVAbtY04yg","75f3de42d977160d7a08f78fb86588a4a742333bc88fcf6bc0f90d8f3e7b9139","What is your nickname?","Bewra"));
//        empList.add(new Employee("c3R7kIDYfBSlrnaFaHjy","Rohit Kumar","Manager","Male",sdf.parse("10-06-1980"),"rohit@gmail.com", "2000000000","rohit","0Kqa3SC2I0","cabbf0cd5a2d958fbaf0e51bd79c452a7f73cb3e17a4321ef3e66edb7583a427","What is your favourite colour","Black"));
//        empList.add(new Employee("PhaVIjDHlVqXlqSrc7mI","Rohan","Worker","Male",sdf.parse("07-06-1985"),"rohan@gmail.com", "3000000000","rohan","zu05dWA5Tu","9c91f8f98c9d6bebbdf1f318176782c042faf123052ecc0ddf413808bb3c8568","Which is the best car ever?","Lamborghini"));
//        empList.add(new Employee("rWksFD8a9fKXs2feaZhM","Anish","Worker","Female",sdf.parse("24-04-1990") ,"anish@gmail.com", "4000000000","anish","I33fBoQFUc","75295b71d6b19d189032ab271bc0accfb1e10f350f9228ce596576d1ec118100","Which is your favourite brand of handbag?","Gucci"));
//        empList.add(new Employee("aajihz6OtMbF9Ci8FO6o","Avishek","Worker","Male",sdf.parse("30-08-1995") ,"avishek@gmail.com", "5000000000","avishek","350DvoE7Pj","c90ddd7aa52d480caf99c1f0211a57f5df0794926eb23aab9c796722c9344f6","Which is your favourite subject?","DSA"));
>>>>>>> 89dc317358bdd500256f827f770d2444a1d327aa
       
        //String empId, String empName, String designation, String gender, Date dob, String emailId,
        //String phoneNo
    }
    public static void addEmployee(Employee e) {
        empList.add(e);
    }
   
    public static List<Employee> getEmployees(){
        return Database.empList;
    }

}
