package com.capgemini.pecunia.model;
import java.sql.Date;


public class Account {
	private String accountId;
	private String accountHolderId;
	private String accountBranchId;
	private String accountType;
	private String accountStatus;
	private double accountBalance;
	private double accountInterest;
	private Date lastUpdated;
	private int id = 001;
	
	
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
	
	public Account(String accountBranchId, String accountType, Date date){
		this.accountBranchId = accountBranchId;
		this.accountType = accountType;
		this.lastUpdated = date;
		this.accountBalance = 0.0;
		this.accountId = accountBranchId+ (Integer.toString(id)); 
		this.accountStatus = "Active";
		this.accountHolderId = null;
		if(accountType=="Savings")
			this.accountInterest = 7.0;
		else if(accountType=="Current")
			this.accountInterest = 5.5;
		else if(accountType=="FD")
			this.accountInterest = 10.0;
	}
	
}
