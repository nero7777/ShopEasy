package com.lti.server.service;

import java.util.List;

import com.lti.server.entity.CardDetails;

public interface CardDetailsServices {

	public int addCard(int userId, String cardType, double cardLimit, double balance);

	public List<CardDetails> getAllCard();

	public List<CardDetails> getCardById(int userId);

	public double deductBalbyId(int userId, double amt);

	public double addBalbyId(int userId, double amt);

}
