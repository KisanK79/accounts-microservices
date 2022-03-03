package com.account_core.app.dto;



public class TransactionDto {
	private int id;
	private String transDate;
	private int transAmmount;
	private String transType;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	public int getTransAmmount() {
		return transAmmount;
	}
	public void setTransAmmount(int transAmmount) {
		this.transAmmount = transAmmount;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	
	
}
