package edu.mum.cs544.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ticket implements Serializable {
	    
       public static enum TicketStatus{ 
           RESERVED,PURCHASED, CACELED, NEW
       }
    @Id @GeneratedValue
	private Long ticket_ID;    
	private String code;
	private double basePrice;
	private Long flightId;
        @Enumerated( EnumType.STRING)
	private TicketStatus status = TicketStatus.NEW;
        
	@ManyToOne
	private Flight flight;
        
	public Ticket() {
		
	}

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
        
	public Long getTicket_ID() {
		return ticket_ID;
	}
	public void setTicket_ID(Long ticket_ID) {
		this.ticket_ID = ticket_ID;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
        
        
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
}
