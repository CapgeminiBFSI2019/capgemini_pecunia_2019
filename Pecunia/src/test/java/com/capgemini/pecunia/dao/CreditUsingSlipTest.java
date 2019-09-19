package com.capgemini.pecunia.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.pecunia.dao.AccountDAOImpl;


class CreditUsingSlipTest {

	
	        AccountDAOImpl accService= new AccountDAOImpl();
	   
	@Test
    public void validateAccountId_Null() {
		// setup
        String accName = null;
      
 
        // assert
        assertThrows(NullPointerException.class, ()->{new AccountDAOImpl().validateAccountName(accName);});
    }
 
    @Test
    public void validateAccountId_EmptyString() {
       // setup
        String accountId = "";
        AccountDAOImpl accService= new AccountDAOImpl();
 
        // execute
        boolean actual = accService.validateAccountId(accountId);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validateAccountId_Missing_Digits() {
       // setup
        String accountId ="56801124";
        AccountDAOImpl accService= new AccountDAOImpl();
        // execute
        boolean actual = accService.validateAccountId(accountId);
 
        // assert
        assertFalse(actual);
    }
    
    @Test
    public void validateAccountId_Excess_Digits() {
       // setup
        String accountId ="5680112467";
        AccountDAOImpl accService= new AccountDAOImpl();
        // execute
        boolean actual = accService.validateAccountId(accountId);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validateAccountId_UpperCaseLetter() {
       // setup
        String accountId = "568034AB";
        AccountDAOImpl accService= new AccountDAOImpl();
        // execute
        boolean actual = accService.validateAccountId(accountId);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validateAcoountId_LowerCaseLetter() {
       // setup
        String accountId = "5680abc34";
        AccountDAOImpl accService= new AccountDAOImpl();
        // execute
        boolean actual = accService.validateAccountId(accountId);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validateAccountId_SpecialChar() {
       // setup
        String accountId = "5680#$@%!";
        AccountDAOImpl accService= new AccountDAOImpl();
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
        assertThrows(NullPointerException.class, ()->{new AccountDAOImpl().validateAccountName(accName);});
    }
 
    @Test
    public void validateAccountName_EmptyString() {
       // setup
        String accountName = "";
        AccountDAOImpl accService= new AccountDAOImpl();
        // execute
        boolean actual = accService.validateAccountName(accountName);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validateAccountName_Digits() {
       // setup
        String accountName ="Darshana Me65a";
        AccountDAOImpl accService= new AccountDAOImpl();
        // execute
        boolean actual = accService.validateAccountName(accountName);
 
        // assert
        assertFalse(actual);
    }
    
   
    

    
    @Test
    public void validateTransAmt_Null() {
       // setup
        Double transAmt = null;
        AccountDAOImpl accService= new AccountDAOImpl();
        // execute
        boolean actual = accService.validateTransAmt(transAmt);
 
        // assert
        assertFalse(actual);
    }
 
      
    @Test
    public void validateTransAmt_Negative() {
       // setup
        Double transAmt = -12000.00;
        AccountDAOImpl accService= new AccountDAOImpl();
        // execute
        boolean actual = accService.validateTransAmt(transAmt);
 
        // assert
        assertFalse(actual);
    }
    
    @Test
    public void validateTransAmt_Max() {
       // setup
        Double transAmt = 1000001.00;
        AccountDAOImpl accService= new AccountDAOImpl();
        // execute
        boolean actual = accService.validateTransAmt(transAmt);
 
        // assert
        assertFalse(actual);
        }
    
    @Test
    public void validateTransAmt_Min() {
       // setup
        Double transAmt = 49.00;
        AccountDAOImpl accService= new AccountDAOImpl();
        // execute
        boolean actual = accService.validateTransAmt(transAmt);
 
        // assert
        assertFalse(actual);
    }
    
    
}
