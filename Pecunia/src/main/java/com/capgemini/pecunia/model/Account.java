package com.capgemini.pecunia.model;
import java.sql.Date;

import com.capgemini.pecunia.Utility;


public class Account {
	private String accountId;
	private String accountHolderId;
	private String accountBranchId;
	private String accountType;
	private String accountStatus;
	private double accountBalance;
	private double accountInterest;
	private Date lastUpdated;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((accountBranchId == null) ? 0 : accountBranchId.hashCode());
		result = prime * result + ((accountHolderId == null) ? 0 : accountHolderId.hashCode());
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
		temp = Double.doubleToLongBits(accountInterest);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((accountStatus == null) ? 0 : accountStatus.hashCode());
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + ((lastUpdated == null) ? 0 : lastUpdated.hashCode());
		//hello
		//
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
		Account other = (Account) obj;
		if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
			return false;
		if (accountBranchId == null) {
			if (other.accountBranchId != null)
				return false;
		} else if (!accountBranchId.equals(other.accountBranchId))
			return false;
		if (accountHolderId == null) {
			if (other.accountHolderId != null)
				return false;
		} else if (!accountHolderId.equals(other.accountHolderId))
			return false;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (Double.doubleToLongBits(accountInterest) != Double.doubleToLongBits(other.accountInterest))
			return false;
		if (accountStatus == null) {
			if (other.accountStatus != null)
				return false;
		} else if (!accountStatus.equals(other.accountStatus))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (lastUpdated == null) {
			if (other.lastUpdated != null)
				return false;
		} else if (!lastUpdated.equals(other.lastUpdated))
			return false;
		return true;
	}

		
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountHolderId() {
		return accountHolderId;
	}
	public void setAccountHolderId(String accountHolderId) {
		this.accountHolderId = accountHolderId;
	}
	public String getAccountBranchId() {
		return accountBranchId;
	}
	public void setAccountBranchId(String accountBranchId) {
		this.accountBranchId = accountBranchId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public double getAccountInterest() {
		return accountInterest;
	}
	public void setAccountInterest(double accountInterest) {
		this.accountInterest = accountInterest;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
//	public Account(String accountBranchId, String accountType, Date date){
//		this.accountBranchId = accountBranchId;
//		this.accountType = accountType;
//		this.lastUpdated = date;
//		this.accountBalance = 0.0;
//		//this.accountId = accountBranchId+ (Integer.toString(id));
//		//this.id++;
//		this.accountStatus = "Active";
//		this.accountHolderId = null;
//		if(accountType=="Savings")
//			this.accountInterest = 7.0;
//		else if(accountType=="Current")
//			this.accountInterest = 5.5;
//		else if(accountType=="FD")
//			this.accountInterest = 10.0;
//	}
		
	
		public Account( String accountHolderId, String accountBranchId, String accountType,
			String accountStatus, double accountBalance, double accountInterest, Date lastUpdated) {
		super();
		this.accountId = Utility.getAlphaNumericString();
		this.accountHolderId = accountHolderId;
		this.accountBranchId = accountBranchId;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
		this.accountInterest = accountInterest;
		this.lastUpdated = lastUpdated;
	}
		
}
