package com.lti.server.dao;

import java.util.List;

import com.lti.server.entity.CardDetails;

public interface CardDetailsDao {

	public int addCard(int userId, String cardType, double cardLimit, double balance);

	public List<CardDetails> getAllCard();

	public List<CardDetails> getCardbyId(int userId);

	public double deductBalbyId(int userId, double amt);

	public double addBalbyId(int userId, double amt);

}
