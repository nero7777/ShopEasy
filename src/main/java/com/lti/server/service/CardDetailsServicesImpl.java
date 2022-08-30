package com.lti.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.server.dao.CardDetailsDao;
import com.lti.server.entity.CardDetails;

@Service
public class CardDetailsServicesImpl implements CardDetailsServices {
	@Autowired
	CardDetailsDao dao;

	@Override
	public int addCard(int userId, String cardType, double cardLimit, double balance) {
		// TODO Auto-generated method stub
		
		return dao.addCard(userId,cardType,cardLimit,balance);
	}

	@Override
	public List<CardDetails> getAllCard() {
		// TODO Auto-generated method stub
		return dao.getAllCard();
	}

	@Override
	public List<CardDetails> getCardById(int userId) {
		// TODO Auto-generated method stub
		return dao.getCardbyId(userId);
	}

	@Override
	public double deductBalbyId(int userId, double amt) {
		// TODO Auto-generated method stub
		return dao.deductBalbyId(userId,amt);
	}

	@Override
	public double addBalbyId(int userId, double amt) {
		// TODO Auto-generated method stub
		return dao.addBalbyId(userId,amt);
	}

}
