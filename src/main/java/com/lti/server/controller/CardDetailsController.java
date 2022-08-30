package com.lti.server.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.server.entity.CardDetails;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/card-api")
public class CardDetailsController {
	CardDetailsServices services;
	
	
	// http://localhost:8085/card-api/addcard/101/Gold

	@PostMapping("/addcard/{userId}/{cardType}")
	public String addCard(@PathVariable("userId") int userId,@PathVariable("cardType") String cardType) {
		CardDetails card = new CardDetails();
		if(cardType.equalsIgnoreCase("Gold")) {
			card.setCardLimit(500000);
			card.setBalance(500000);
		}
		else if(cardType.equalsIgnoreCase("Titanium")) {
			card.setCardLimit(1000000);
			card.setBalance(1000000);
		}
		int cardNo = services.addCard(userId, cardType, card.getCardLimit(), card.getBalance());
		return "Card No" + cardNo +"added";
	}
	// http://localhost:8085/card-api/getallcards
	
	@GetMapping("/getallcards")
	public List<CardDetails> getAllCards (){
		List<CardDetails> myList = services.getAllCard();
		return myList;
	}
	// http://localhost:8085/card-api/getcardbyid/134
	@GetMapping("/getcardbyid/{userId}")
	public List<CardDetails> getCardbyId(@PathVariable("userId")int userId){
		List<CardDetails> card = services.getCardById(userId);
		return card;
	}
	// http://localhost:8085/card-api/deductbalbyid/101/10000

	@PutMapping("/deductbalbyid/{userId}/{amt}")
	public double deductBalbyId(@PathVariable("userId") int userId, @PathVariable("amt") double amt) {
		double recordUpdated = services.deductBalbyId(userId, amt);
		return recordUpdated;
	}
	// http://localhost:8085/card-api/addbalbyid/101/7000000
	@PutMapping("/addbalbyid/{userId}/{amt}")
	public double addBalbyId(@PathVariable("userId") int userId,@PathVariable("amt") double amt) {
		double recordUpdated = services.addBalbyId(userId,amt);
		return recordUpdated;
	}
	
}
