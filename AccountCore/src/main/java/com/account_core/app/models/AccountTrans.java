package com.account_core.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="account_trans")
public class AccountTrans {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String transDate;
	private int transAmmount;
	private String transType;
	
	@Transient
	private int accountId;
	
	
	@ManyToOne
	private Account account;
	
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
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
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountTrans [id=");
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
