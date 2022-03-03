package com.account_core.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="account_trans")
public class AccountTrans {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String transData;
	private int transAmmount;
	private String transType;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTransData() {
		return transData;
	}
	public void setTransData(String transData) {
		this.transData = transData;
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
		builder.append("AccountTrans [id=");
		builder.append(id);
		builder.append(", transData=");
		builder.append(transData);
		builder.append(", transAmmount=");
		builder.append(transAmmount);
		builder.append(", transType=");
		builder.append(transType);
		builder.append("]");
		return builder.toString();
	}
	
	
}
