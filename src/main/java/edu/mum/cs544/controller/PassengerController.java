package edu.mum.cs544.controller;

import edu.mum.cs544.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import edu.mum.cs544.domain.Passenger;

import edu.mum.cs544.service.PassengerService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
@RequestMapping("/passenger")
public class PassengerController {


        @Autowired
	private PassengerService ps;
        
        @InitBinder
	public void dataBinding(WebDataBinder binder) {
//		binder.addValidators(userValidator, emailValidator);
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(true);
		SimpleDateFormat timeFormat = new SimpleDateFormat("MM/dd/yyyy h:mm:ss aaa");
                timeFormat.setLenient(true);	
		
//		
//		binder.registerCustomEditor(Date.class, "Passenger.expiration_month", new CustomDateEditor(dateFormat, true));
//                binder.registerCustomEditor(Date.class, "Passenger.expiration_year", new CustomDateEditor(dateFormat, true));
		binder.setDisallowedFields("card_number","card_type","expiration_month","expiration_year");
	} 

        
          	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(Model model) {
		model.addAttribute("newCustomer", new Customer());
		return "passenger/login";
	}
        
              	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		model.addAttribute("newCustomer", null);
		return "redirect:/flight";
	}
	       	@RequestMapping(value = "/logincancel", method = RequestMethod.GET)
	public String logincancel(Model model) {
		model.addAttribute("newCustomer", null);
		return "redirect:/flight";
	}
        
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String  loginPost(@ModelAttribute("newCustomer") Customer customer,HttpServletRequest request) {

//                 Passenger passenger=ps.getPassenger(customer.getUsername(), customer.getPassword());
//		System.out.println(passenger.getUserName());
//                    if(!passenger.getUserName().equals(customer.getUsername()))
//                    {
//                     return "redirect:/passenger/login";
//                    }
              List<Passenger> passengers=ps.findAll();
              for(Passenger p:passengers)
              {
                  if(p.getUserName().equals(customer.getUsername()))
                     
                  return "redirect:/ticket/reserve";
              }
//		 request.getSession().setAttribute("newCustomer", passenger);
		 return "redirect:/passenger/login";
	}
        
        
        
        
	@RequestMapping(method = RequestMethod.GET)
	public String Passenger(Model model) {

		model.addAttribute("passengers", ps.findAll());
                model.addAttribute("loginUserForm",  new Passenger() );
		return "passenger/passenger";
	}
        



	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPassenger(Model model) {
		model.addAttribute("newPassenger", new Passenger());
		return "passenger/passenger_add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String createPassenger(@ModelAttribute("newPassenger") Passenger passenger) {		


        ps.save(passenger);
		return "redirect:/passenger/add";
	}
	
	// UPDATE Load -----
	@RequestMapping(value="/{contactId}", method=RequestMethod.GET)
	public String editContact(@PathVariable("contactId") Long id, Model model){
		model.addAttribute("newContact", ps.findById(id));
		return "contact/contact_add";
	}
	
	// UPDATE Save -----
	@RequestMapping(value="/{contactId}", method=RequestMethod.POST)
	public String updateContact(@ModelAttribute("newContact") Passenger contact){
		ps.save(contact);
		return "redirect:/contact";
	}
	
	
	// DELETE -----
	@RequestMapping(value="/delete/{Id}", method=RequestMethod.POST)
	public String Delete(Model model, @PathVariable("Id") Long id){
		
		if(ps.findById(id) != null){
			ps.delete(id);
		}
		
		// After delete Fetch data
		model.addAttribute("contacts", ps.findAll());
		return "contact/contact_ajax";
	}
	
	
	public PassengerService getContactService() {
		return ps;
	}

	public void setContactService( PassengerService passengerService) {
		this.ps = passengerService;
	}
}
