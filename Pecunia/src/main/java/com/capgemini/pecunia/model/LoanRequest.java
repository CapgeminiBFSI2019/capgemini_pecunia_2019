package com.capgemini.pecunia.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.capgemini.pecunia.Values;

public class LoanRequest {
	String requestId;
	String customerId;
	double amount;
	String type;
	int tenure;
	double roi;
	String loanStatus;
	double emi;
	int creditScore;

	
	
	public String getRequestId() {
		return requestId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double loanAmount) {
		this.amount = loanAmount;
	}

	public String getType() {
		return type;
	}

	public void setType(String loanType) {
		this.type = loanType;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public double getRoi() {
		return roi;
	}

	public void setRoi(double loanRoi) {
		this.roi = loanRoi;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double loanEmi) {
		this.emi = loanEmi;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public LoanRequest(String requestId, String customerId, double loanAmount, String loanType, int tenure,
			double loanRoi, String loanStatus, double loanEmi, int creditScore) {
		super();
		this.requestId = requestId;
		this.customerId = customerId;
		this.amount = loanAmount;
		this.type = loanType;
		this.tenure = tenure;
		this.roi = loanRoi;
		this.loanStatus = loanStatus;
		this.emi = loanEmi;
		this.creditScore = creditScore;
	}

	public String getLoanRequestData() {
		return (this.requestId + "," + this.customerId + "," + this.amount + "," + this.type + ","
				+ this.tenure + "," + this.roi + "," + this.loanStatus + "," + this.emi + ","
				+ this.creditScore);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		temp = Double.doubleToLongBits(roi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + tenure;
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
		LoanRequest other = (LoanRequest) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (Double.doubleToLongBits(roi) != Double.doubleToLongBits(other.roi))
			return false;
		if (tenure != other.tenure)
			return false;
		return true;
	}

	public static LoanRequest getLoanRequestObject(String row) {
		String arr[] = row.split(",");

		LoanRequest loanreq= new LoanRequest(arr[0],arr[1],Double.parseDouble(arr[2]),arr[3],Integer.parseInt(arr[4]),Double.parseDouble(arr[5]),arr[6],Double.parseDouble(arr[7]),Integer.parseInt(arr[8]));

		return loanreq;
	}

	@Override
	public String toString() {

		return this.requestId+" "+this.customerId+" "+this.amount+" "+this.type+" "+this.tenure+
				" "+this.roi+" "+this.loanStatus+" "+this.emi + " "+ this.creditScore;

	}

}
