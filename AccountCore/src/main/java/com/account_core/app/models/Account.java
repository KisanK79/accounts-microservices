package com.account_core.app.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int accountId;
	String name;
	String type;
	String dateOfOpening;
	int openingBalance;
	
	@OneToMany(cascade = CascadeType.PERSIST,mappedBy = "account")
	private List<AccountTrans> accountTras;

	
	public Account() {
		super();
	}

	public Account(int accountId) {
		this.accountId=accountId;
	}


	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDateOfOpening() {
		return dateOfOpening;
	}


	public void setDateOfOpening(String dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}


	public int getOpeningBalance() {
		return openingBalance;
	}


	public void setOpeningBalance(int openingBalance) {
		this.openingBalance = openingBalance;
	}


	public List<AccountTrans> getAccountTras() {
		return accountTras;
	}


	public void setAccountTras(List<AccountTrans> accountTras) {
		this.accountTras = accountTras;
	}

	
}
