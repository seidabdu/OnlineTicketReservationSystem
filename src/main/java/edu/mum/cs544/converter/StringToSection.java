package edu.mum.cs544.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import edu.mum.cs544.domain.Passenger;
import edu.mum.cs544.service.PassengerService;

public class StringToSection implements Converter<String, Passenger> {
	@Autowired
	private PassengerService passengerService;
	public Passenger convert(String sectionId) {
            
            return passengerService.findById(Long.parseLong(sectionId));
//		return passengerService.findOne(Long.parseLong(sectionId));
	};
}
