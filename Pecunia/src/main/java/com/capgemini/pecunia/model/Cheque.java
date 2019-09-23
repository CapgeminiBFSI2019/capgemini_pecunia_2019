package com.capgemini.pecunia.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.capgemini.pecunia.Values;

public class Cheque {
	private String id;
	private int num;
	private String accountNo;
	private String holderName;
	private String bankName;
	private String ifsc;
	private Date issueDate;
	private String status;
	
	
	
	
	
	public Cheque(String id, int num, String accountNo, String holderName, String bankName, String ifsc, Date issueDate,
			String status) {
		super();
		this.id = id;
		this.num = num;
		this.accountNo = accountNo;
		this.holderName = holderName;
		this.bankName = bankName;
		this.ifsc = ifsc;
		this.issueDate = issueDate;
		this.status = status;
	}


	public String getId() {
		return id;
	}

	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getChequeDetails()
	{
		return (this.id + "," + this.num + "," + this.accountNo + "," + this.holderName + "," + this.bankName + "," + this.ifsc + "," + this.issueDate + "," + this.status );
	}
	
	public static Cheque getChequeObject(String row) {
		String arr[] = row.split(",");
		Date date;
		try {
			date = new SimpleDateFormat(Values.DATE_FORMAT).parse(arr[6]);
		Cheque cheque=new Cheque(arr[0],Integer.parseInt(arr[1]),arr[2],arr[3],arr[4],arr[5],date,arr[7]);
		return cheque;
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	return null;
}
}
