package com.capgemini.pecunia.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.capgemini.pecunia.Values;

public class LoanRequest {
	String loanRequestId;
	String loanCustomerId;
	double loanAmount;
	String loanType;
	int tenure;
	double loanRoi;
	String loanStatus;
	double loanEmi;
	int creditScore;

	// Default Constructor
	public LoanRequest() {

	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public String getLoanRequestId() {
		return loanRequestId;
	}

	public void setLoanRequestId(String loanRequestId) {
		this.loanRequestId = loanRequestId;
	}

	public String getLoanCustomerId() {
		return loanCustomerId;
	}

	public void setLoanCustomerId(String loanCustomerId) {
		this.loanCustomerId = loanCustomerId;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public double getLoanRoi() {
		return loanRoi;
	}

	public void setLoanRoi(double loanRoi) {
		this.loanRoi = loanRoi;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public double getLoanEmi() {
		return loanEmi;
	}

	public void setLoanEmi(double loanEmi) {
		this.loanEmi = loanEmi;
	}
	
	//Parameterized Constructor for LoanRequest
	public LoanRequest(String loanRequestId, String loanCustomerId, double loanAmount, String loanType, int tenure,
			double loanRoi, String loanStatus, double loanEmi, int creditScore) {
		super();
		this.loanRequestId = loanRequestId;
		this.loanCustomerId = loanCustomerId;
		this.loanAmount = loanAmount;
		this.loanType = loanType;
		this.tenure = tenure;
		this.loanRoi = loanRoi;
		this.loanStatus = loanStatus;
		this.loanEmi = loanEmi;
		this.creditScore = creditScore;
	}
	
	public String getLoanRequestData() {
		return (this.loanRequestId + "," + this.loanCustomerId + "," + this.loanAmount + "," + this.loanType + ","
				+ this.tenure + "," + this.loanRoi + "," + this.loanStatus + "," + this.loanEmi + ","
				+ this.creditScore);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(loanAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((loanType == null) ? 0 : loanType.hashCode());
		temp = Double.doubleToLongBits(loanRoi);
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
		if (Double.doubleToLongBits(loanAmount) != Double.doubleToLongBits(other.loanAmount))
			return false;
		if (loanType == null) {
			if (other.loanType != null)
				return false;
		} else if (!loanType.equals(other.loanType))
			return false;
		if (Double.doubleToLongBits(loanRoi) != Double.doubleToLongBits(other.loanRoi))
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

		return this.loanRequestId+" "+this.loanCustomerId+" "+this.loanAmount+" "+this.loanType+" "+this.tenure+
				" "+this.loanRoi+" "+this.loanStatus+" "+this.loanEmi + " "+ this.creditScore;

	}

}
