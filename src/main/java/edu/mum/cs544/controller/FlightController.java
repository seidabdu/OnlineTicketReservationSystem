package edu.mum.cs544.controller;

import edu.mum.cs544.aspectj.Audit;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import edu.mum.cs544.domain.Flight;

import edu.mum.cs544.service.FlightService;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	private FlightService fs;
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
//		binder.addValidators(userValidator, emailValidator);
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(true);
		SimpleDateFormat timeFormat = new SimpleDateFormat("MM/dd/yyyy h:mm:ss aaa");
                timeFormat.setLenient(true);	
		
		
		binder.registerCustomEditor(Date.class, "Flight.departure_time", new CustomDateEditor(dateFormat, true));
                binder.registerCustomEditor(Date.class, "Flight.arrival_time", new CustomDateEditor(dateFormat, true));
		binder.setDisallowedFields("flight_ID","flight_departure_date","available_seats");
	} 
      @Audit("Home")
	@RequestMapping(method = RequestMethod.GET)
	public String flight(Model model) {

		model.addAttribute("flights", fs.findAll());
		return "flight/flights";
	}
	
	@RequestMapping(value="/find", method = RequestMethod.POST)
	public String ContactFind(HttpServletRequest request, @RequestParam("from") String from, @RequestParam("to") String to) {
            
            
             request.getSession().removeAttribute("flights");
            request.getSession().setAttribute("flights", fs.findByFromLocationAndToLocation(from, to));

//		return "flight/flightResult";
             return "flight/flightResult";
	}
	


	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getFlight(Model model) {
		model.addAttribute("newFlight", new Flight());
		return "flight/flight_add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String createFlight(@ModelAttribute("newFlight") Flight flight) {

               flight.setAvailable_seats(flight.getTotal_seats());
		System.out.println(flight.getDeparture_time());

		fs.save(flight);
		return "redirect:/flight";
	}
	
//	// UPDATE Load -----
//	@RequestMapping(value="/{flightId}", method=RequestMethod.GET)
//	public String editContact(@PathVariable("flightId") Long id, Model model){
//		model.addAttribute("newContact", fs.findById(id));
//		return "flight/flight_add";
//	}
//	
//	// UPDATE Save -----
//	@RequestMapping(value="/{flightId}", method=RequestMethod.POST)
//	public String updateContact(@ModelAttribute("newFlight") Flight flight){
//		fs.save(flight);
//		return "redirect:/flight";
//	}
//	
//	
//	// DELETE -----
//	@RequestMapping(value="/delete/{Id}", method=RequestMethod.POST)
//	public String Delete(Model model, @PathVariable("Id") Long id){
//		
//		if(fs.findById(id) != null){
//			fs.delete(id);
//		}
//		
//		// After delete Fetch data
//		model.addAttribute("flights", fs.findAll());
//		return "flight/flight_ajax";
//	}
//	
//	
	public FlightService getFlightService() {
		return fs;
	}

	public void setFlightService(FlightService flightService) {
		this.fs = flightService;
	}
}
