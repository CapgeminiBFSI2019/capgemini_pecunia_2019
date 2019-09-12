package com.capgemini.pecunia.model;

public class Address {

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
	
	public Address(String addressId, String addressLine1, String addressLine2, String addressCity, String addressState,
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

}
