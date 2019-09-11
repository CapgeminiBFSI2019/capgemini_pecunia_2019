package com.capgemini.pecunia.model;

import java.util.*;
public class Transaction {
	String transAccountId;
	String transType;
	Double transAmount;
	String transOption;
	Date transDate;
	String transChequeId;
	String transFrom;
	String transTo;
	Double transClosingBalance;

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
	}


