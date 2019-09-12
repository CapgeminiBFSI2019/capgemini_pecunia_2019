package com.capgemini.pecunia.model;

public class LoanRequest {
	String loanType;
	double loanAmount;
	int tenure;
	double roi;
	public LoanRequest(String loanType, double loanAmount, int tenure, double roi) {
		super();
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.tenure = tenure;
		this.roi = roi;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
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
	public void setRoi(double roi) {
		this.roi = roi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(loanAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((loanType == null) ? 0 : loanType.hashCode());
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
		if (Double.doubleToLongBits(loanAmount) != Double.doubleToLongBits(other.loanAmount))
			return false;
		if (loanType == null) {
			if (other.loanType != null)
				return false;
		} else if (!loanType.equals(other.loanType))
			return false;
		if (Double.doubleToLongBits(roi) != Double.doubleToLongBits(other.roi))
			return false;
		if (tenure != other.tenure)
			return false;
		return true;
	}
	

}
