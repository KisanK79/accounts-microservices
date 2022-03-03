package com.account_api.app.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_ABSENT )
public class Account {
	private int accountId;
	private String name;
	private String type;
	private String dateOfOpening;
	private int openingBalance;
	private int currentBalance;
	
	private List<Transaction> accountTras;
	
	public int getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}

	

	public List<Transaction> getAccountTras() {
		return accountTras;
	}

	public void setAccountTras(List<Transaction> accountTras) {
		this.accountTras = accountTras;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [accountId=");
		builder.append(accountId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append(", dateOfOpening=");
		builder.append(dateOfOpening);
		builder.append(", openingBalance=");
		builder.append(openingBalance);
		builder.append(", currentBalance=");
		builder.append(currentBalance);
		builder.append(", accountTras=");
		builder.append(accountTras);
		builder.append("]");
		return builder.toString();
	}

	

}

