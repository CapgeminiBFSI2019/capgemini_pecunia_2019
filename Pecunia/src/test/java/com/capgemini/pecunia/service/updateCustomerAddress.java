package com.capgemini.pecunia.service;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

class updateCustomerAddress {

	@Test
	void updateCustomerAddress_addresscityValidityNull() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().updateCustomerAddress("20190001000001","GH1syhe","GH1syhe",null,"UP","India","211006");
			
		    });		
	}
	
	@Test
	void updateCustomerAddress_addresscityValidity1() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().updateCustomerAddress("20190001000001","GH1syhe","GH1syhe","Alld.","UP","India","211006");
			
		    });		
	}
	
	@Test
	void updateCustomerAddress_addresscityValidity2() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().updateCustomerAddress("20190001000001","GH1syhe","GH1syhe","A11d","UP","India","211006");
			
		    });		
	}
	
	@Test
	void updateCustomerAddress_addressstateValidityNull() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().updateCustomerAddress("20190001000001","GH1syhe","GH1syhe","Alld",null,"India","211006");
			
		    });		
	}
	
	@Test
	void updateCustomerAddress_addressstateValidity1() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().updateCustomerAddress("20190001000001","GH1syhe","GH1syhe","Alld","UP1","India","211006");
			
		    });		
	}
	
	@Test
	void updateCustomerAddress_addressstateValidity2() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().updateCustomerAddress("20190001000001","GH1syhe","GH1syhe","Alld","UP@","India","211006");
			
		    });		
	}
	@Test
	void updateCustomerAddress_addresscountryValidityNull() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().updateCustomerAddress("20190001000001","GH1syhe","GH1syhe","Alld","UP",null,"211006");
			
		    });		
	}
	
	@Test
	void updateCustomerAddress_addresscountryValidity1() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().updateCustomerAddress("20190001000001","GH1syhe","GH1syhe","Alld","UP","Ind1a","211006");
			
		    });		
	}
	
	@Test
	void updateCustomerAddress_addresscountryValidity2() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().updateCustomerAddress("20190001000001","GH1syhe","GH1syhe","Alld","UP","Ind!a","211006");
			
		    });		
	}
	
	@Test
	void updateCustomerAddress_addresszipcodeValidityNull() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().updateCustomerAddress("20190001000001","GH1syhe","GH1syhe","Alld","UP","India",null);
			
		    });		
	}
	
	@Test
	void updateCustomerAddress_addresszipcodeValidity1() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().updateCustomerAddress("20190001000001","GH1syhe","GH1syhe","Alld","UP","India","21106");
			
		    });		
	}
	
	@Test
	void updateCustomerAddress_addresszipcodeValidity2() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().updateCustomerAddress("20190001000001","GH1syhe","GH1syhe","Alld","UP","India","21100#");
			
		    });		
	}


}
