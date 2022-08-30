package com.lti.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CARD_DETAILS")
public class CardDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Card_Seq") //generating sequence that is created in database
	@SequenceGenerator(name="Card_Seq", sequenceName="Card_Seq", allocationSize=1)
	private int cardNo;

	private int userId;
	
	@Column(length=15)
	private String cardType;
	
	@Column(length=15)
	private String validityDate="27-12-27";
	
	private double cardLimit;
	
	private double balance;
	

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(String validityDate) {
		this.validityDate = validityDate;
	}

	public double getCardLimit() {
		return cardLimit;
	}

	public void setCardLimit(double cardLimit) {
		this.cardLimit = cardLimit;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public CardDetails(int cardNo, int userId, String cardType, String validityDate, double cardLimit, double balance) {
		super();
		this.cardNo = cardNo;
		this.userId = userId;
		this.cardType = cardType;
		this.validityDate = validityDate;
		this.cardLimit = cardLimit;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "CardDetails [cardNo=" + cardNo + ", userId=" + userId + ", cardType=" + cardType + ", validityDate="
				+ validityDate + ", cardLimit=" + cardLimit + ", balance=" + balance + "]";
	}

	public CardDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
