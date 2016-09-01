
package edu.mum.cs544.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import static javax.persistence.TemporalType.DATE;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@SecondaryTable(name = "FLIGHT_DETAIL")
@Entity
public class Flight implements Serializable {
	
	@Id @GeneratedValue
	private Long flight_ID;
        @NotNull
	private String airline_name;
        @NotNull       
	private String from_location;
        @NotNull
	private String to_location;
        @Temporal(TemporalType.DATE)
        @NotNull
//        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date departure_time;
         @Temporal(TemporalType.DATE)
         @NotNull
	private Date arrival_time;
	private int duration;
	@NotNull
	private int total_seats;
	@Column( table="FLIGHT_DETAIL")
	private Date flight_departure_date;
	@Column( table="FLIGHT_DETAIL")
        @NotNull
	private Double price;
	@Column( table="FLIGHT_DETAIL")
	private int available_seats;
	
//	@OneToMany(mappedBy="flight", cascade=CascadeType.ALL )
//	private List<Ticket> ticket;
	
	public Flight() {
		
	}

    public Long getFlight_ID() {
        return flight_ID;
    }

    public void setFlight_ID(Long flight_ID) {
        this.flight_ID = flight_ID;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }

    public String getFrom_location() {
        return from_location;
    }

    public void setFrom_location(String from_location) {
        this.from_location = from_location;
    }

    public String getTo_location() {
        return to_location;
    }

    public void setTo_location(String to_location) {
        this.to_location = to_location;
    }

    public Date getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Date departure_time) {
        this.departure_time = departure_time;
    }

    public Date getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Date arrival_time) {
        this.arrival_time = arrival_time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTotal_seats() {
        return total_seats;
    }

    public void setTotal_seats(int total_seats) {
        this.total_seats = total_seats;
    }

    public Date getFlight_departure_date() {
        return flight_departure_date;
    }

    public void setFlight_departure_date(Date flight_departure_date) {
        this.flight_departure_date = flight_departure_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(int available_seats) {
        this.available_seats = available_seats;
    }

//    public List<Ticket> getTicket() {
//        return ticket;
//    }
//
//    public void setTicket(List<Ticket> ticket) {
//        this.ticket = ticket;
//    }

   
}