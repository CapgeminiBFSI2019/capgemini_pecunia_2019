package com.capgemini.pecunia.model;

public class Branch 
{
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((ifsc == null) ? 0 : ifsc.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Branch other = (Branch) obj;
		if (address == null) 
		{
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (ifsc == null) 
		{
			if (other.ifsc != null)
				return false;
		} else if (!ifsc.equals(other.ifsc))
			return false;
		if (id == null) 
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) 
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	private String id;
	private String name;
	private String ifsc;
	private String address;
	
	
	
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Branch(String id, String name, String ifsc, String address) {
		super();
		this.id = id;
		this.name = name;
		this.ifsc = ifsc;
		this.address = address;
	}
	public static Branch getBranchObject(String row) {
		String arr[] = row.split(",");
		Branch branch=new Branch(arr[0],arr[1],arr[2],arr[3]);
		return branch;
	}
	
	@Override
	public String toString() {
		return this.id+" "+this.name+" "+this.ifsc+" "+this.address;
	}


}