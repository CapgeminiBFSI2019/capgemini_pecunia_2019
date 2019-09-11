package com.capgemini.pecunia.model;

public class Address {

	private String addressId;
	private String addressLine;
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
	
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	
	public String getAddressLine() {
		return addressLine;
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

}
