package com.capgemini.pecunia.model;

public class Branch 
{
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branchAddress == null) ? 0 : branchAddress.hashCode());
		result = prime * result + ((branchIFSC == null) ? 0 : branchIFSC.hashCode());
		result = prime * result + ((branchId == null) ? 0 : branchId.hashCode());
		result = prime * result + ((branchName == null) ? 0 : branchName.hashCode());
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
		if (branchAddress == null) 
		{
			if (other.branchAddress != null)
				return false;
		} else if (!branchAddress.equals(other.branchAddress))
			return false;
		if (branchIFSC == null) 
		{
			if (other.branchIFSC != null)
				return false;
		} else if (!branchIFSC.equals(other.branchIFSC))
			return false;
		if (branchId == null) 
		{
			if (other.branchId != null)
				return false;
		} else if (!branchId.equals(other.branchId))
			return false;
		if (branchName == null) 
		{
			if (other.branchName != null)
				return false;
		} else if (!branchName.equals(other.branchName))
			return false;
		return true;
	}
	private String branchId;
	private String branchName;
	public Branch(String branchId, String branchName, String branchIFSC, String branchAddress) 
	{
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchIFSC = branchIFSC;
		this.branchAddress = branchAddress;
	}
	private String branchIFSC;
	private String branchAddress;
	public String getBranchId() 
	{
		return branchId;
	}
	public void setBranchId(String branchId) 
	{
		this.branchId = branchId;
	}
	public String getBranchName() 
	{
		return branchName;
	}
	public void setBranchName(String branchName) 
	{
		this.branchName = branchName;
	}
	public String getBranchIFSC() 
	{
		return branchIFSC;
	}
	public void setBranchIFSC(String branchIFSC)
	{
		this.branchIFSC = branchIFSC;
	}
	public String getBranchAddress() 
	{
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) 
	{
		this.branchAddress = branchAddress;
	}

}