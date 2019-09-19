package com.capgemini.pecunia.model;
import java.sql.Date;
import java.text.ParseException;
//import java.util.*;
import java.text.SimpleDateFormat;

import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.Values;

public class Customer {
	
	private String id;
	private String name;
	private String addressId;
	private String aadhar;
	private String pan;
	private String contact;
	private String gender;
	private Date dob;

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((aadhar == null) ? 0 : aadhar.hashCode());
	result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
	result = prime * result + ((contact == null) ? 0 : contact.hashCode());
	result = prime * result + ((dob == null) ? 0 : dob.hashCode());
	result = prime * result + ((gender == null) ? 0 : gender.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((pan == null) ? 0 : pan.hashCode());
	return result;
}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (aadhar == null) {
			if (other.aadhar != null)
				return false;
		} else if (!aadhar.equals(other.aadhar))
			return false;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pan == null) {
			if (other.pan != null)
				return false;
		} else if (!pan.equals(other.pan))
			return false;
		return true;
	}


	
		
	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressId() {
		return addressId;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Customer(String id, String name, String addressId, String aadhar, String pan, String contact, String gender,
			Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.addressId = addressId;
		this.aadhar = aadhar;
		this.pan = pan;
		this.contact = contact;
		this.gender = gender;
		this.dob = dob;
	}

	public static Customer getCustomerObject(String row) {
		String arr[] = row.split(",");
		Date date;
		try {
			date = (Date) new SimpleDateFormat(Values.DATE_FORMAT).parse(arr[7]);
			Customer cust= new Customer(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],date);
		}
		 catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}
	
	@Override
	public String toString() {
		return this.name+" "+this.addressId+" "+this.aadhar+" "+this.pan+" "+this.contact+
				" "+this.contact+" -"+this.dob;
	}
}
