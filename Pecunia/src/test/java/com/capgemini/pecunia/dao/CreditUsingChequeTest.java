package com.capgemini.pecunia.dao;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import com.capgemini.pecunia.service.AccountService;
import com.capgemini.pecunia.service.AccountServiceImpl;


class CreditUsingChequeTest {

	
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
        String accountId ="56801124";
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateAccountId(accountId);
 
        // assert
        assertFalse(actual);
    }
    
    @Test
    public void validateAccountId_Excess_Digits() {
       // setup
        String accountId ="5680112467";
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateAccountId(accountId);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validateAccountId_UpperCaseLetter() {
       // setup
        String accountId = "568034AB";
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateAccountId(accountId);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validateAcoountId_LowerCaseLetter() {
       // setup
        String accountId = "5680abc34";
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateAccountId(accountId);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validateAccountId_SpecialChar() {
       // setup
        String accountId = "5680#$@%!";
        AccountService accService= new AccountServiceImpl();
        // execute
        boolean actual = accService.validateAccountId(accountId);
 
        // assert
        assertFalse(actual);
    }
 
    //hhhhhh
    //jhwgwyejgewg
    //jhgfuytgfkhk
    
    
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
