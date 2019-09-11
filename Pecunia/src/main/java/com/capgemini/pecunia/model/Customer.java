package com.capgemini.pecunia.model;
import java.sql.Date;
//import java.util.*;

public class Customer {
private String customerId;
private String customerName;
private String customerAadhar;
private String customerPan;
private String customerContact;
private String customerGender;
private Date customerDob;

//private int id = 101;





	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerAadhar(String  customerAadhar) {
		this. customerAadhar =  customerAadhar;
	}
	
	public String getCustomerAadhar() {
		return customerAadhar;
	}
	
	public void setCustomerPan(String customerPan) {
		this.customerPan = customerPan;
	}
	
	public String getCustomerPan() {
		return customerPan;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerDob(Date customerDob) {
		this.customerDob = customerDob;
	}
	
	public Date getCustomerDob() {
		return customerDob;
	}


	public Customer(String customerName, String customerAadhar, String customerPan, String customerContact,
			String customerGender, Date customerDob) {
		super();
		this.customerName = customerName;
		this.customerAadhar = customerAadhar;
		this.customerPan = customerPan;
		this.customerContact = customerContact;
		this.customerGender = customerGender;
		this.customerDob = customerDob;
//		this.customerId = Integer.toString(this.id);
//		this.id++;

}
}
