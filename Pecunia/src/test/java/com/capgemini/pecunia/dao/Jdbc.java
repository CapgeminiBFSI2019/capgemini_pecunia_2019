package com.capgemini.pecunia.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 

public class Jdbc {
    public static void main(String[] args) {
        Connection con = getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Persons");
            while(rs.next()) {
                rs.getString(1);
                System.out.println("Data from tbl_employee ");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        private static Connection getConnection() {
    String mysqlDriverFQCN="com.mysql.jdbc.Driver";
    
    try {
        Class.forName(mysqlDriverFQCN);
        
    }catch (ClassNotFoundException e) {
        e.printStackTrace();
        System.exit(1);
    }
    String url = "jdbc:mysql://remotemysql.com:3306/kF8xCmHSJV";
    String uname = "kF8xCmHSJV";
    String pwd = "ONg17UDxGi";
    Connection conn = null;
    try {
          conn = DriverManager.getConnection(url, uname, pwd);
         if(conn!=null) {
             System.out.println("Connected!");
             }
     }
     catch(Exception e) {
         e.printStackTrace();
     }
     return conn;
        }
}
