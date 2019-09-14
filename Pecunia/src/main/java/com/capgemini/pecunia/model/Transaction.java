package com.capgemini.pecunia.model;

import java.util.*;

public class Transaction {
	String transId;
	String transAccountId;
	String transType;
	Double transAmount;
	String transOption;
	Date transDate;
	String transChequeId;
	String transFrom;
	String transTo;
	Double transClosingBalance;

	public Transaction(String transId, String transAccountId, String transType, Double transAmount, String transOption,
			Date transDate, String transChequeId, String transFrom, String transTo, Double transClosingBalance) {
		super();
		this.transId = transId;
		this.transAccountId = transAccountId;
		this.transType = transType;
		this.transAmount = transAmount;
		this.transOption = transOption;
		this.transDate = transDate;
		this.transChequeId = transChequeId;
		this.transFrom = transFrom;
		this.transTo = transTo;
		this.transClosingBalance = transClosingBalance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transAccountId == null) ? 0 : transAccountId.hashCode());
		result = prime * result + ((transAmount == null) ? 0 : transAmount.hashCode());
		result = prime * result + ((transChequeId == null) ? 0 : transChequeId.hashCode());
		result = prime * result + ((transClosingBalance == null) ? 0 : transClosingBalance.hashCode());
		result = prime * result + ((transDate == null) ? 0 : transDate.hashCode());
		result = prime * result + ((transFrom == null) ? 0 : transFrom.hashCode());
		result = prime * result + ((transOption == null) ? 0 : transOption.hashCode());
		result = prime * result + ((transTo == null) ? 0 : transTo.hashCode());
		result = prime * result + ((transType == null) ? 0 : transType.hashCode());
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
		Transaction other = (Transaction) obj;
		if (transAccountId == null) {
			if (other.transAccountId != null)
				return false;
		} else if (!transAccountId.equals(other.transAccountId))
			return false;
		if (transAmount == null) {
			if (other.transAmount != null)
				return false;
		} else if (!transAmount.equals(other.transAmount))
			return false;
		if (transChequeId == null) {
			if (other.transChequeId != null)
				return false;
		} else if (!transChequeId.equals(other.transChequeId))
			return false;
		if (transClosingBalance == null) {
			if (other.transClosingBalance != null)
				return false;
		} else if (!transClosingBalance.equals(other.transClosingBalance))
			return false;
		if (transDate == null) {
			if (other.transDate != null)
				return false;
		} else if (!transDate.equals(other.transDate))
			return false;
		if (transFrom == null) {
			if (other.transFrom != null)
				return false;
		} else if (!transFrom.equals(other.transFrom))
			return false;
		if (transOption == null) {
			if (other.transOption != null)
				return false;
		} else if (!transOption.equals(other.transOption))
			return false;
		if (transTo == null) {
			if (other.transTo != null)
				return false;
		} else if (!transTo.equals(other.transTo))
			return false;
		if (transType == null) {
			if (other.transType != null)
				return false;
		} else if (!transType.equals(other.transType))
			return false;
		return true;
	}

	public String getTransAccountId() {
		return transAccountId;
	}

	public void setTransAccountId(String transAccountId) {
		this.transAccountId = transAccountId;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public Double getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(Double transAmount) {
		this.transAmount = transAmount;
	}

	public String getTransOption() {
		return transOption;
	}

	public void setTransOption(String transOption) {
		this.transOption = transOption;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public String getTransChequeId() {
		return transChequeId;
	}

	public void setTransChequeId(String transChequeId) {
		this.transChequeId = transChequeId;
	}

	public String getTransFrom() {
		return transFrom;
	}

	public void setTransFrom(String transFrom) {
		this.transFrom = transFrom;
	}

	public String getTransTo() {
		return transTo;
	}

	public void setTransTo(String transTo) {
		this.transTo = transTo;
	}

	public Double getTransClosingBalance() {
		return transClosingBalance;
	}

	public void setTransClosingBalance(Double transClosingBalance) {
		this.transClosingBalance = transClosingBalance;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}
	
	public String getTransactionString()
	{
		return (this.transId + "," + this.transAccountId + "," + this.transType + "," + this.transAmount + "," + this.transOption + "," + this.transDate + "," + this.transChequeId + "," + this.transFrom + "," + this.transTo + "," + this.transClosingBalance );
	}

}
