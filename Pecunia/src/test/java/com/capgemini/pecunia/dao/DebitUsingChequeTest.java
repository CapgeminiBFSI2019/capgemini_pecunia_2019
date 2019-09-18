package com.capgemini.pecunia.dao;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import com.capgemini.pecunia.service.AccountService;
import com.capgemini.pecunia.service.AccountServiceImpl;


class DebitUsingChequeTest {

	
	        AccountService accService= new AccountServiceImpl();
	   
	@Test
    public void validateAccountId_Null() {
       // setup
		 AccountService accService= new AccountServiceImpl();
        String accountId = null;
 
        // execute
        boolean actual = accService.validateAccountId(accountId);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validateAccountId_EmptyString() {
       // setup
        String accountId = "";
        AccountService accService= new AccountServiceImpl();
 
        // execute
        boolean actual = accService.validateAccountId(accountId);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validateAccountId_Missing_Digits() {
       // setup
        String accountId ="201900010000";
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateAccountId(accountId);
 
        // assert
        assertFalse(actual);
    }
    
    @Test
    public void validateAccountId_Excess_Digits() {
       // setup
        String accountId ="2019000100000157";
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateAccountId(accountId);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validateAccountId_UpperCaseLetter() {
       // setup
        String accountId = "201900010000AB";
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateAccountId(accountId);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validateAcoountId_LowerCaseLetter() {
       // setup
        String accountId = "201900010000ab";
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateAccountId(accountId);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validateAccountId_SpecialChar() {
       // setup
        String accountId = "201900010000#!";
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateAccountId(accountId);
 
        // assert
        assertFalse(actual);
    }
 
    
    
    
    
    @Test
    public void validateAccountName_Null() {
    	  // setup
        String accName = null;
      
 
        // assert
        assertThrows(NullPointerException.class, ()->{new AccountServiceImpl().validateAccountName(accName);});
    }
 
    @Test
    public void validateAccountName_EmptyString() {
       // setup
        String accountName = "";
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateAccountName(accountName);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validateAccountName_Digits() {
       // setup
        String accountName ="Darshana Me65a";
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateAccountName(accountName);
 
        // assert
        assertFalse(actual);
    }
    
    @Test
    public void validateAccountName_SpecialChar() {
       // setup
        String accountName = "Darshana Me@%a";
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateAccountName(accountName);
 
        // assert
        assertFalse(actual);
    }
    
   
    

    
    @Test
    public void validateTransAmt_Null() {
       // setup
        Double transAmt = null;
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateTransAmt(transAmt);
 
        // assert
        assertFalse(actual);
    }
 
      
    @Test
    public void validateTransAmt_Negative() {
       // setup
        Double transAmt = -12000.00;
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateTransAmt(transAmt);
 
        // assert
        assertFalse(actual);
    }
    
    @Test
    public void validateTransAmt_Max() {
       // setup
        Double transAmt = 1000001.00;
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateTransAmt(transAmt);
 
        // assert
        assertFalse(actual);
        }
    
    @Test
    public void validateTransAmt_Min() {
       // setup
        Double transAmt = 49.00;
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateTransAmt(transAmt);
 
        // assert
        assertFalse(actual);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Test
    public void validateChequeNum_Less() {
       // setup
        int chequeNum = 12345;
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateChequeNum(chequeNum);
 
        // assert
        assertFalse(actual);  
    }
    
    @Test
    public void validateChequeNum_Excess() {
       // setup
        int chequeNum = 1234567;
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateChequeNum(chequeNum);
 
        // assert
        assertFalse(actual);  
    }
    
    
    
    @Test
    public void validateChequeNum_Null() {
       // setup
        Integer chequeNum = null;
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateChequeNum(chequeNum);
 
        // assert
        assertFalse(actual);  
    }
    
    
    
    
}
