package com.account_api.app.models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_DEFAULT)
public class Transaction {
	private int id;
	private String transDate;
	private int transAmmount;
	private String transType;
	
	private int accountId;
	private Account account;
	
	
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction [id=");
		builder.append(id);
		builder.append(", transDate=");
		builder.append(transDate);
		builder.append(", transAmmount=");
		builder.append(transAmmount);
		builder.append(", transType=");
		builder.append(transType);
		builder.append(", accountId=");
		builder.append(accountId);
		builder.append(", account=");
		builder.append(account);
		builder.append("]");
		return builder.toString();
	}
}
