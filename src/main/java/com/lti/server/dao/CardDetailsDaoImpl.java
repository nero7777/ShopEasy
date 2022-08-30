package com.lti.server.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.server.entity.CardDetails;

@Repository
public class CardDetailsDaoImpl implements CardDetailsDao {
	
	@Autowired
	EntityManager em;
	
	
	@Override
	@Transactional
	public int addCard(int userId, String cardType, double cardLimit, double balance) {
		// TODO Auto-generated method stub
		CardDetails card = new CardDetails();
		card.setUserId(userId);
		card.setCardType(cardType);
		card.setCardLimit(cardLimit);
		card.setBalance(balance);
		em.persist(card);
		return card.getCardNo();
		
	}

	@Override
	public List<CardDetails> getAllCard() {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("select c from CardDetails c");
		List<CardDetails>myList = qry.getResultList();
		return myList;
	}

	@Override
	public List<CardDetails> getCardbyId(int userId) {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("select c from CarDetails c where c.userId=:id");
		qry.setParameter("id",userId);
		List<CardDetails> myList = qry.getResultList();
		return myList;
	}

	@Override
	@Transactional
	public double deductBalbyId(int userId, double amt) {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("select c from CardDetails c where c.userId=:id ");
		qry.setParameter("id",userId);
		List<CardDetails> myCard = qry.getResultList();
		double intialBal = myCard.get(0).getBalance();
		double finalBal = intialBal - amt;
		myCard.get(0).setBalance(finalBal);
		Query qry1 = em.createQuery("UPDATE CardDetails c SET c.balance=:finalBal"+ "WHERE c.userId=:id");
		qry1.setParameter("finalBal", finalBal);
		qry1.setParameter("id",userId);
		
		int rowsUpdated = qry1.executeUpdate();
		return rowsUpdated;
	}

	@Override
	@Transactional
	public double addBalbyId(int userId, double amt) {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("select c from CardDetails c where c.userId=:id");
		qry.setParameter("id",userId);
		List<CardDetails> myCard = qry.getResultList();
		double intialBal = myCard.get(0).getBalance();
		double finalBal = intialBal+amt;
		myCard.get(0).setBalance(finalBal);
		Query qry1 = em.createQuery("UPDATE CardDetails c SET c.balance=:finalBal" + "WHERE c.userId =:id ");
		qry1.setParameter("finalBal",finalBal );
		qry1.setParameter("id",userId);
		int rowsUpdated = qry1.executeUpdate();
		return rowsUpdated;
	}

}
