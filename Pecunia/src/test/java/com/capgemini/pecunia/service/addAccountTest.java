package com.capgemini.pecunia.service;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import javax.activity.InvalidActivityException;

import org.junit.jupiter.api.Test;

class addAccountTest {

	@Test
	void addAccount_NullTest1() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount(null, null, null, null, null, null, null, null, null, null, null, null, null, -1.4, -1.0, null, null);
			
		    });		
	}
	
	@Test
	void addAccount_AadharValidity() {
		
		String line="1234567g*+9871";
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount(null, line, null, null, null, null, null, null, null, null, null, null, null, -1.4, -1.0, null, null);
			
		    });		
	}
	
	
	@Test
	void addAccount_PanValidity() {
		
		String line="123456789876543211dD^&_+";
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount(null, null,line, null, null, null, null, null, null, null, null, null, null, -1.4, -1.0, null, null);
			
		    });		
	}
	@Test
	void addAccount_customernameValidity() {
		
		String line="123";
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount(line, null,null, null, null, null, null, null, null, null, null, null, null, -1.4, -1.0, null, null);
			
		    });		
	}
	@Test
	void addAccount_customerContactValidity() {
		
		String line="ab123456789";
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount(null,null,null,line, null, null, null, null, null, null, null, null, null, -1.4, -1.0, null, null);
			
		    });		
	}
	@Test
	void addAccount_customerGenderValidity() {
		
		String line="NO";
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount(null,null,null,null,line, null, null, null, null, null, null, null, null, -1.4, -1.0, null, null);
			
		    });		
	}
	@Test
	void addAccount_addresscityValidity() {
		
		String line="123city@";
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount(null,null,null,null,null, null, null, null, line, null, null, null, null, -1.4, -1.0, null, null);
			
		    });		
	}
	
	@Test
	void addAccount_addressstateValidity() {
		
		String line="123state@";
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount(null,null,null,null,null, null, null, null, null, line, null, null, null, -1.4, -1.0, null, null);
			
		    });		
	}
	@Test
	void addAccount_addresscountryValidity() {
		
		String line="123country@";
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount(null,null,null,null,null, null, null, null, null, null, line, null, null, -1.4, -1.0, null, null);
			
		    });		
	}
	@Test
	void addAccount_addresszipcodeValidity() {
		
		String line="yesnoy@1";
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount(null,null,null,null,null, null, null, null, null, null,null,line, null, -1.4, -1.0, null, null);
			
		    });		
	}
	@Test
	void addAccount_accounttypeValidity() {
		
		String line="WHATISIT";
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount(null,null,null,null,null, null, null, null, null, null,null,null,line, -1.4, -1.0, null, null);
			
		    });		
	}
	@Test
	void addAccount_accountbalanceValidity() {
		
		double line= -15;
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount(null,null,null,null,null, null, null, null, null, null,null,null,null,line, -1.0, null, null);
			
		    });		
	}
	@Test
	void addAccount_accountinterestValidity() {
		
		double line= -15;
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount(null,null,null,null,null, null, null, null, null, null,null,null,null,-1.6,line, null, null);
			
		    });		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
