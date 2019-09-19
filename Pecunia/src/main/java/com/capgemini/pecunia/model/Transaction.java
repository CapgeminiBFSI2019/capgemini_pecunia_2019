package com.capgemini.pecunia.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.capgemini.pecunia.Values;

public class Transaction {
	String id;
	String accountId;
	String type;
	Double amount;
	String option;
	Date transDate;
	String chequeId;
	String transFrom;
	String transTo;
	Double closingBalance;

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((chequeId == null) ? 0 : chequeId.hashCode());
		result = prime * result + ((closingBalance == null) ? 0 : closingBalance.hashCode());
		result = prime * result + ((transDate == null) ? 0 : transDate.hashCode());
		result = prime * result + ((transFrom == null) ? 0 : transFrom.hashCode());
		result = prime * result + ((option == null) ? 0 : option.hashCode());
		result = prime * result + ((transTo == null) ? 0 : transTo.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (chequeId == null) {
			if (other.chequeId != null)
				return false;
		} else if (!chequeId.equals(other.chequeId))
			return false;
		if (closingBalance == null) {
			if (other.closingBalance != null)
				return false;
		} else if (!closingBalance.equals(other.closingBalance))
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
		if (option == null) {
			if (other.option != null)
				return false;
		} else if (!option.equals(other.option))
			return false;
		if (transTo == null) {
			if (other.transTo != null)
				return false;
		} else if (!transTo.equals(other.transTo))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	
	public String getId() {
		return id;
	}


	public String getAccountId() {
		return accountId;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public String getChequeId() {
		return chequeId;
	}

	public void setChequeId(String chequeId) {
		this.chequeId = chequeId;
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

	public Double getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(Double closingBalance) {
		this.closingBalance = closingBalance;
	}

	public Transaction(String id, String accountId, String type, Double amount, String option, Date transDate,
			String chequeId, String transFrom, String transTo, Double closingBalance) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.type = type;
		this.amount = amount;
		this.option = option;
		this.transDate = transDate;
		this.chequeId = chequeId;
		this.transFrom = transFrom;
		this.transTo = transTo;
		this.closingBalance = closingBalance;
	}

	public String getTransactionString()
	{
		DateFormat dateFormat = new SimpleDateFormat(Values.DATE_FORMAT);
		return (this.id + "," + this.accountId + "," + this.type + "," + this.amount + "," + this.option + "," +dateFormat.format(this.transDate)  + "," + this.chequeId + "," + this.transFrom + "," + this.transTo + "," + this.closingBalance );
	}
	
	public static Transaction getTransactionObject(String row) {
		// TODO Auto-generated method stub
		String arr[] = row.split(",");
		Date date;
		Transaction transaction;
		try {
			date = new SimpleDateFormat(Values.DATE_FORMAT).parse(arr[5]);
			transaction = new Transaction(arr[0],arr[1],arr[2],Double.parseDouble(arr[3]),arr[4],date,arr[6],arr[7],arr[8],Double.parseDouble(arr[9]));
			return transaction;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	

}
