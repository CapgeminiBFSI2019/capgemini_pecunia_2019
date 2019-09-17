package com.capgemini.pecunia.model;
import java.text.SimpleDateFormat;
import java.util.*;

import com.capgemini.pecunia.Values;
public class LoanDisbursed {

	

	String loanRequestId;
	String loanCustomerId;
	double loanAmount;
	String loanType;
	int tenure;
	double loanRoi;
	String loanStatus;
	double loanEmi;
	int creditScore;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + creditScore;
		long temp;
		temp = Double.doubleToLongBits(loanAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((loanCustomerId == null) ? 0 : loanCustomerId.hashCode());
		temp = Double.doubleToLongBits(loanEmi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((loanRequestId == null) ? 0 : loanRequestId.hashCode());
		temp = Double.doubleToLongBits(loanRoi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((loanStatus == null) ? 0 : loanStatus.hashCode());
		result = prime * result + ((loanType == null) ? 0 : loanType.hashCode());
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
		LoanDisbursed other = (LoanDisbursed) obj;
		if (creditScore != other.creditScore)
			return false;
		if (Double.doubleToLongBits(loanAmount) != Double.doubleToLongBits(other.loanAmount))
			return false;
		if (loanCustomerId == null) {
			if (other.loanCustomerId != null)
				return false;
		} else if (!loanCustomerId.equals(other.loanCustomerId))
			return false;
		if (Double.doubleToLongBits(loanEmi) != Double.doubleToLongBits(other.loanEmi))
			return false;
		if (loanRequestId == null) {
			if (other.loanRequestId != null)
				return false;
		} else if (!loanRequestId.equals(other.loanRequestId))
			return false;
		if (Double.doubleToLongBits(loanRoi) != Double.doubleToLongBits(other.loanRoi))
			return false;
		if (loanStatus == null) {
			if (other.loanStatus != null)
				return false;
		} else if (!loanStatus.equals(other.loanStatus))
			return false;
		if (loanType == null) {
			if (other.loanType != null)
				return false;
		} else if (!loanType.equals(other.loanType))
			return false;
		if (tenure != other.tenure)
			return false;
		return true;
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
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	public LoanDisbursed(String loanRequestId, String loanCustomerId, double loanAmount, String loanType, int tenure,
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
	
	
	
}
