package com.account_core.app.dto;

import java.util.List;

public class AccountDto {
	int accountId;
	String name;
	String type;
	String dateOfOpening;
	int openingBalance;
	int currentBalance;
	private List<TransactionDto> accountTras;

	public List<TransactionDto> getAccountTras() {
		return accountTras;
	}

	public void setAccountTras(List<TransactionDto> accountTras) {
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

	public int getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		AccountDto a = (AccountDto) obj;
		return this.getName().equals(a.getName()) && this.getType().equals(a.getType())
				&& this.getDateOfOpening().equals(a.getDateOfOpening())
				&& this.getOpeningBalance() == a.getOpeningBalance();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountDto [accountId=");
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
