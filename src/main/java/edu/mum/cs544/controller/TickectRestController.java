package edu.mum.cs544.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import edu.mum.cs544.domain.Customer;
import edu.mum.cs544.domain.Flight;
import edu.mum.cs544.domain.Passenger;
import edu.mum.cs544.domain.Ticket;
import edu.mum.cs544.service.FlightService;
import edu.mum.cs544.service.PassengerService;
import edu.mum.cs544.service.TicketService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@Controller
@RequestMapping("rest/ticket")
public class TickectRestController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private FlightService flightService;    
    

                
      @RequestMapping(value = "/cancel/{ticketID}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deletePurchasedTicket(@PathVariable("ticketID") Long ticketID, HttpServletRequest request) {
            
             Ticket ticket = ticketService.findById(ticketID);
         Flight newflight=flightService.findById(ticket.getFlightId());
        ticket.setStatus(Ticket.TicketStatus.CACELED);
        ticket.setFlightId(null);
      
        ticket.setTicket_ID(null);
        ticket.setFlight(null);       
        Passenger passenger = (Passenger) request.getSession().getAttribute("newCustomer");
        passenger.setTicket(null);                        
        if (newflight != null && newflight.getAvailable_seats() < newflight.getTotal_seats() ) {
            newflight.setAvailable_seats(newflight.getAvailable_seats() + 1 );
        }
          ticketService.save(ticket);
          
           passengerService.save(passenger);
            flightService.save(newflight);
            ticketService.delete(ticketID);        
           
          
        
       
		
	}
        
        
        @RequestMapping(value = "/find/{ticketID}", method = RequestMethod.GET)
	public @ResponseBody Ticket findticket(@PathVariable("ticketID") Long ticketID) {     
	
	    
         return  ticketService.findAOne(ticketID);
        }
        
    
}
