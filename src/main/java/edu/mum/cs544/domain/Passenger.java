package edu.mum.cs544.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;





@Entity
@SecondaryTable( name ="CREDIT_CARD_DETAIL")
public class Passenger implements Serializable {
    
	@Id @GeneratedValue
	private Long passenger_id;
        @NotNull
	private String password;
        @NotNull
	private String firstName;
        @NotNull
	private String lastName;
        @NotNull
        private String userName;
	private String tel_no;
        @Email
	@Column(columnDefinition = "varchar(80)")
	private String email_id;
	
	@Column( table ="CREDIT_CARD_DETAIL")       
	private int card_number;
	@Column( table ="CREDIT_CARD_DETAIL")
	private CardType card_type;
	@Column( table ="CREDIT_CARD_DETAIL")
         @Temporal(TemporalType.DATE)
	private Date expiration_month;
	@Column( table ="CREDIT_CARD_DETAIL")
         @Temporal(TemporalType.DATE)
	private Date expiration_year;
	
	@OneToOne
	private Ticket ticket;
	
	public Passenger() {
		
	}

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
	
        
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTel_no() {
		return tel_no;
	}
	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public Long getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id( Long passenger_id) {
		this.passenger_id = passenger_id;
	}

	public int getCard_number() {
		return card_number;
	}

	public void setCard_number(int card_number) {
		this.card_number = card_number;
	}

	public CardType getCard_type() {
		return card_type;
	}

	public void setCard_type(CardType card_type) {
		this.card_type = card_type;
	}

	public Date getExpiration_month() {
		return expiration_month;
	}

	public void setExpiration_month(Date expiration_month) {
		this.expiration_month = expiration_month;
	}

	public Date getExpiration_year() {
		return expiration_year;
	}

	public void setExpiration_year(Date expiration_year) {
		this.expiration_year = expiration_year;
	}
	
    
	
	
}
