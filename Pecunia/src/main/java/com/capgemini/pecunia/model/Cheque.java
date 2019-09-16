package com.capgemini.pecunia.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.capgemini.pecunia.Values;

public class Cheque {
	private String chequeId;
	private int chequeNum;
	private String chequeAccountNo;
	private String chequeHolderName;
	private String chequeBankName;
	private String chequeIFSC;
	private Date chequeIssueDate;
	private String chequeStatus;
	public Cheque(String chequeId, int chequeNum, String chequeAccountNo, String chequeHolderName,
			String chequeBankName, String chequeIFSC, Date chequeIssueDate, String chequeStatus) {
		super();
		this.chequeId = chequeId;
		this.chequeNum = chequeNum;
		this.chequeAccountNo = chequeAccountNo;
		this.chequeHolderName = chequeHolderName;
		this.chequeBankName = chequeBankName;
		this.chequeIFSC = chequeIFSC;
		this.chequeIssueDate = chequeIssueDate;
		this.chequeStatus = chequeStatus;
	}
	public String getChequeId() {
		return chequeId;
	}
	public void setChequeId(String chequeId) {
		this.chequeId = chequeId;
	}
	public int getChequeNum() {
		return chequeNum;
	}
	public void setChequeNum(int chequeNum) {
		this.chequeNum = chequeNum;
	}
	public String getChequeAccountNo() {
		return chequeAccountNo;
	}
	public void setChequeAccountNo(String chequeAccountNo) {
		this.chequeAccountNo = chequeAccountNo;
	}
	public String getChequeHolderName() {
		return chequeHolderName;
	}
	public void setChequeHolderName(String chequeHolderName) {
		this.chequeHolderName = chequeHolderName;
	}
	public String getChequeBankName() {
		return chequeBankName;
	}
	public void setChequeBankName(String chequeBankName) {
		this.chequeBankName = chequeBankName;
	}
	public String getChequeIFSC() {
		return chequeIFSC;
	}
	public void setChequeIFSC(String chequeIFSC) {
		this.chequeIFSC = chequeIFSC;
	}
	public Date getChequeIssueDate() {
		return chequeIssueDate;
	}
	public void setChequeIssueDate(Date chequeIssueDate) {
		this.chequeIssueDate = chequeIssueDate;
	}
	public String getChequeStatus() {
		return chequeStatus;
	}
	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}
	
	public String getChequeDetails()
	{
		return (this.chequeId + "," + this.chequeNum + "," + this.chequeAccountNo + "," + this.chequeHolderName + "," + this.chequeBankName + "," + this.chequeIFSC + "," + this.chequeIssueDate + "," + this.chequeStatus );
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
