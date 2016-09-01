package edu.mum.cs544.domain;

import java.util.Date;

public class CreditCard {
   

	public enum CardType {
		
		DISCOVER,
		CAPITALONE,
		BANKOFAMERICA
	}
	
	private int card_number;
	private CardType card_type;
	private Date expiration_month;
	private Date expiration_year;
	
	
	
	
}
