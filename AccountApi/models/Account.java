package com.account_core.app.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","accountTras"})
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int accountId;
	String name;
	String type;
	String dateOfOpening;
	String balance;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="account_id")
	private List<AccountTrans> accountTras;

	public List<AccountTrans> getAccountTras() {
		return accountTras;
	}

	public void setAccountTras(List<AccountTrans> accountTras) {
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

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
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
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", accountTras=");
		builder.append(accountTras);
		builder.append("]");
		return builder.toString();
	}

}
