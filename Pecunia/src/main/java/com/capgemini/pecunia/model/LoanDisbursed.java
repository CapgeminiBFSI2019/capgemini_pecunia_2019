package com.capgemini.pecunia.model;
import java.text.SimpleDateFormat;
import java.util.*;

import com.capgemini.pecunia.Values;
public class LoanDisbursed {

	

	String requestId;
	String customerId;
	double amount;
	String type;
	int tenure;
	double roi;
	String status;
	double emi;
	int creditScore;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + creditScore;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		temp = Double.doubleToLongBits(emi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		temp = Double.doubleToLongBits(roi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (Double.doubleToLongBits(emi) != Double.doubleToLongBits(other.emi))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		if (Double.doubleToLongBits(roi) != Double.doubleToLongBits(other.roi))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (tenure != other.tenure)
			return false;
		return true;
	}
	public LoanDisbursed(String requestId, String customerId, double amount, String type, int tenure, double roi,
			String status, double emi, int creditScore) {
		super();
		this.requestId = requestId;
		this.customerId = customerId;
		this.amount = amount;
		this.type = type;
		this.tenure = tenure;
		this.roi = roi;
		this.status = status;
		this.emi = emi;
		this.creditScore = creditScore;
	}
	
	
	public String getRequestId() {
		return requestId;
	}

	public String getCustomerId() {
		return customerId;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	
	
	
	
	
}
