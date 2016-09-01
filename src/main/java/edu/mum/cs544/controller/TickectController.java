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

@Controller
@RequestMapping("/ticket")
public class TickectController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private PassengerService passengerService;
    @Autowired
    private FlightService flightService;

 
    
    @RequestMapping(value="/find", method = RequestMethod.POST)
	public String ticketFind(Model model,HttpServletRequest request) {
	     request.getSession().setAttribute("tickets", ticketService.findAll());
//            model.addAttribute("tickets", ticketService.findAll());	
//            switch(searchby) {
//		case "airline_name":
//			model.addAttribute("flights", fs.findByAirlineName(search));
//                        for(Flight f:fs.findByAirlineName(search))
//                        {
//                            System.out.println(f.getAirline_name());
//                        }
//			break;
//		case "from_location":
//			model.addAttribute("flights", fs.findByfromLocation(search));
//                          for(Flight f:fs.findByfromLocation(search))
//                        {
//                            System.out.println(f.getAirline_name());
//                        }
//			break;
//		case "to_location":
//			model.addAttribute("flights", fs.findByToLocation(search));
//                           for(Flight f:fs.findByToLocation(search))
//                        {
//                            System.out.println(f.getAirline_name());
//                        }
//			break;			
		
		
//		}
                
               
		return "ticket/ticketResult";
    
        }

    @RequestMapping(value = "/reserve", method = RequestMethod.GET)
    public String showTicketForm(Model model, HttpServletRequest request) {
                
//                Long flightid=(long)request.getSession().getAttribute("flightid");
//                Flight newflight=flightService.findById(flightid);
//                Ticket nkt=new Ticket();
//                nkt.setFlightId(flightid);
                model.addAttribute("reserveTicket",  new Ticket());
                
        return "ticket/reserveTicket";
    }
    
        @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String  TicketStatus(Model model, HttpServletRequest request) {
                
//                Long flightid=(long)request.getSession().getAttribute("flightid");
//                Flight newflight=flightService.findById(flightid);
//                Ticket nkt=new Ticket();
//                nkt.setFlightId(flightid);

 Passenger passenger=(Passenger)request.getSession().getAttribute("newCustomer");
        
            if(passenger!=null && (passenger.getTicket().getTicket_ID()!=null))
   model.addAttribute("ticket", ticketService.findAOne(passenger.getTicket().getTicket_ID()));
                
        return "ticket/ticketResult";
    }

       @RequestMapping(value = "/ticketResult", method = RequestMethod.GET)
    public String showTicketDetail(Model model,HttpServletRequest request) {
             Passenger currentpassenger=(Passenger)request.getSession().getAttribute("newCustomer");
           Ticket savedTicket=ticketService.findById(currentpassenger.getTicket().getTicket_ID());
        request.getSession().setAttribute("tickets",savedTicket );
               
                
        return "ticket/ticketResult";
    }
    
    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
    public String reserveTicket(@ModelAttribute("reserveTicket") Ticket ticket, HttpServletRequest request) {
         Flight newflight=flightService.findById(ticket.getFlightId());
        ticket.setFlight(newflight);
        ticket.setStatus(Ticket.TicketStatus.RESERVED);
        Passenger passenger = (Passenger) request.getSession().getAttribute("newCustomer");
         ticketService.save(ticket);
        passenger.setTicket(ticket);
     
        passengerService.save(passenger);
        request.getSession().setAttribute("newTicket", ticket);
        return "redirect:/ticket/purchase";
    }
    
    @RequestMapping(value = "/cancel/{ticketID}", method = RequestMethod.GET)
    public String cancelTicket(@PathVariable("ticketID") Long ticketID, HttpServletRequest request) {
        
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
           
           
          
        
        return "redirect:/flight";
    }
    
    
     @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    public String confirmPurchase(@ModelAttribute("purchaseTicket") Ticket ticket, HttpServletRequest request) {

        Ticket tkt = ticketService.findById(ticket.getTicket_ID());
        tkt.setStatus(Ticket.TicketStatus.PURCHASED);
        request.getSession().setAttribute("ticket", tkt);
        Passenger passenger = (Passenger) request.getSession().getAttribute("newCustomer");
        passenger.setTicket(tkt);

         Flight newflight=flightService.findById(tkt.getFlightId());
        
        if (newflight != null && newflight.getAvailable_seats() > 0) {
            newflight.setAvailable_seats(newflight.getAvailable_seats() - 1);
        }
        ticketService.save(tkt);
        passengerService.save(passenger);
        flightService.save(newflight);

        return "redirect:/ticket/ticketResult";
    }

    
   
    @RequestMapping(value = "/purchase", method = RequestMethod.GET)
    public String showPurchase(Model model,HttpServletRequest request) {

          model.addAttribute("purchaseTicket", (Ticket)request.getSession().getAttribute("newTicket"));
         
        return "ticket/purchaseTicket";
    }


//	@RequestMapping(value = "/add", method = RequestMethod.GET)
//	public String addContact(Model model) {
//		model.addAttribute("newContact", new Contact());
//		return "contact/contact_add";
//	}
//	
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public String createContact(@ModelAttribute("newContact") Contact contact) {
//
//		/* under test */
//		User newUser = new User();
//		newUser.setUserId(1L);
//		newUser.setUserName("Siken");
//		newUser.setPassword("test");
//		contact.setUser(newUser);
//		/* temporary solution */
//		
//
//		contactService.save(contact);
//		return "redirect:/contact";
//	}
//	
//	// UPDATE Load -----
//	@RequestMapping(value="/{contactId}", method=RequestMethod.GET)
//	public String editContact(@PathVariable("contactId") Long id, Model model){
//		model.addAttribute("newContact", contactService.findById(id));
//		return "contact/contact_add";
//	}
//	
//	// UPDATE Save -----
//	@RequestMapping(value="/{contactId}", method=RequestMethod.POST)
//	public String updateContact(@ModelAttribute("newContact") Contact contact){
//		contactService.save(contact);
//		return "redirect:/contact";
//	}
//	
//	
//	// DELETE -----
//	@RequestMapping(value="/delete/{Id}", method=RequestMethod.POST)
//	public String Delete(Model model, @PathVariable("Id") Long id){
//		
//		if(contactService.findById(id) != null){
//			contactService.delete(id);
//		}
//		
//		// After delete Fetch data
//		model.addAttribute("contacts", contactService.findAll());
//		return "contact/contact_ajax";
//	}
//	
//	
//	public ContactService getContactService() {
//		return contactService;
//	}
//
//	public void setContactService(ContactService contactService) {
//		this.contactService = contactService;
//	}
}
