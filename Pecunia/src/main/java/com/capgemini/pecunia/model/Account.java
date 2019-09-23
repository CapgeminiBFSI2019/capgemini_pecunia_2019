package com.capgemini.pecunia.model;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.Values;


public class Account {
	private String id;
	private String holderId;
	private String branchId;
	private String accountType;
	private String status;
	private double balance;
	private double interest;
	private Date lastUpdated;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((branchId == null) ? 0 : branchId.hashCode());
		result = prime * result + ((holderId == null) ? 0 : holderId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		temp = Double.doubleToLongBits(interest);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (branchId == null) {
			if (other.branchId != null)
				return false;
		} else if (!branchId.equals(other.branchId))
			return false;
		if (holderId == null) {
			if (other.holderId != null)
				return false;
		} else if (!holderId.equals(other.holderId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(interest) != Double.doubleToLongBits(other.interest))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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

		
	
		
	public Account(String id, String holderId, String branchId, String accountType, String status, double balance,
			double interest, Date lastUpdated) {
		super();
		this.id = id;
		this.holderId = holderId;
		this.branchId = branchId;
		this.accountType = accountType;
		this.status = status;
		this.balance = balance;
		this.interest = interest;
		this.lastUpdated = lastUpdated;
	}
	public String getId() {
		return id;
	}
	
	public String getHolderId() {
		return holderId;
	}
	
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
		public static Account getAccountObject(String row) {
			String arr[] = row.split(",");
			Date date;
			try {
//				System.out.println("Row : "+row);
				date =  (Date) new SimpleDateFormat(Values.DATE_FORMAT).parse(arr[7]);
				Account acc= new Account(arr[0],arr[1],arr[2],arr[3],arr[4],Double.parseDouble(arr[5]),Double.parseDouble(arr[6]),date);
				return acc;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public String getAccountString() {
			DateFormat dateFormat = new SimpleDateFormat(Values.DATE_FORMAT);
			return (this.id+","+this.holderId + "," + this.branchId + "," + this.accountType + "," + this.status + "," + this.balance + "," + this.interest + "," +dateFormat.format(this.lastUpdated) );
		}
		
		
}
