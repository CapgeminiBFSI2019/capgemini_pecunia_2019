package com.capgemini.pecunia.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.Values;

public class Address {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressCity == null) ? 0 : addressCity.hashCode());
		result = prime * result + ((addressCountry == null) ? 0 : addressCountry.hashCode());
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((addressLine1 == null) ? 0 : addressLine1.hashCode());
		result = prime * result + ((addressLine2 == null) ? 0 : addressLine2.hashCode());
		result = prime * result + ((addressState == null) ? 0 : addressState.hashCode());
		result = prime * result + ((addressZipcode == null) ? 0 : addressZipcode.hashCode());
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
		Address other = (Address) obj;
		if (addressCity == null) {
			if (other.addressCity != null)
				return false;
		} else if (!addressCity.equals(other.addressCity))
			return false;
		if (addressCountry == null) {
			if (other.addressCountry != null)
				return false;
		} else if (!addressCountry.equals(other.addressCountry))
			return false;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (addressLine1 == null) {
			if (other.addressLine1 != null)
				return false;
		} else if (!addressLine1.equals(other.addressLine1))
			return false;
		if (addressLine2 == null) {
			if (other.addressLine2 != null)
				return false;
		} else if (!addressLine2.equals(other.addressLine2))
			return false;
		if (addressState == null) {
			if (other.addressState != null)
				return false;
		} else if (!addressState.equals(other.addressState))
			return false;
		if (addressZipcode == null) {
			if (other.addressZipcode != null)
				return false;
		} else if (!addressZipcode.equals(other.addressZipcode))
			return false;
		return true;
	}

	private String addressId;
	private String addressLine1;
	private String addressLine2;
	private String addressCity;
	private String addressState;
	private String addressCountry;
	private String addressZipcode;
	
	
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	
	public String getAddressId() {
		return addressId;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	
	public String getAddressCity() {
		return addressCity;
	}
	
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	
	public String getAddressState() {
		return addressState;
	}
	
	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}
	
	public String getAddressCountry() {
		return addressCountry;
	}
	
	public void setAddressZipcode(String addressZipcode) {
		this.addressZipcode = addressZipcode;
	}
	
	public String getAddressZipcode() {
		return addressZipcode;
	}
	
	public Address(String addressId ,String addressLine1, String addressLine2, String addressCity, String addressState,
			String addressCountry, String addressZipcode) {
		super();
		this.addressId = addressId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressCountry = addressCountry;
		this.addressZipcode = addressZipcode;
	}

	@Override
	public String toString() {
		return this.addressLine1+" "+this.addressLine2+" "+this.addressCity+" "+this.addressCountry+" "+this.addressState+
				" "+this.addressCountry+" -"+this.addressZipcode;
	}
	
	public static Address getAddressObject(String row) {
		String arr[] = row.split(",");
			Address address= new Address(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
		return address;
	}

}
