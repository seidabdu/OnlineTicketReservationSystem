package edu.mum.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.dao.FlightDAO;
import edu.mum.cs544.domain.Flight;
import edu.mum.cs544.domain.Ticket;

@Service
public class FlightService {

	@Autowired
	private FlightDAO flightDao;

	/* All Contacts */
	public List<Flight> findAll() {
		return flightDao.findAll();
	}
        
//        public Flight findOne( Ticket tkt ) {
//		return flightDao.findOne(tkt);
//	}
//        
        /* Find Contact by Name */
	public List<Flight> findByAirlineName(String airlineName) {
		return  flightDao.findByAirlineName(airlineName);
	}

	/* Find Contact by Email */
	public List<Flight> findByfromLocation(String fromlocation) {
		return flightDao.findByFromLocation(fromlocation);
	}

	/* Find Contact by HomePhone */
	public List<Flight> findByToLocation(String toLocation) {
		return flightDao.findByToLocation(toLocation);
	}
        
        /* Find Contact by HomePhone */
	public List<Flight> findByFromLocationAndToLocation(String from,String to) {
		return flightDao.findByFromLocationAndToLocation(from,to);
	}

//	/* Find Contact by Address */
//	public List<Flight> findByPrice(Double price) {
//		return flightDao.findByprice(price);
//	}
	
	public Flight findById(Long id) {
		return flightDao.findOne(id);
	}

	public void delete(Long id) {
		flightDao.delete(id);
	}
	
        

//	/* All Contacts | Sorted by ID */
//	public List<Flight> findAllByContactId(boolean sort) {
//		if (sort) {
//			return flightDao.findAllByOrderByContactIdAsc();
//		} else {
//			return flightDao.findAllByOrderByContactIdDesc();
//		}
//	}
//
//	/* All Contacts | Sorted by Name */
//	public List<Flight> findAllByName(boolean sort) {
//		if (sort) {
//			return flightDao.findAllByOrderByContactNameAsc();
//		} else {
//			return flightDao.findAllByOrderByContactNameDesc();
//		}
//	}
//
//	/* All Contacts | Sorted by Address */
//	public List<Flight> findAllByAddress(boolean sort) {
//		if (sort) {
//			return flightDao.findAllByOrderByAddressAsc();
//		} else {
//			return flightDao.findAllByOrderByAddressDesc();
//		}
//	}
//
//	/* All Contacts | Sorted by Mobile */
//	public List<Flight> findAllByMobile(boolean sort) {
//		if (sort) {
//			return flightDao.findAllByOrderByMobileAsc();
//		} else {
//			return flightDao.findAllByOrderByMobileDesc();
//		}
//	}
//
//	/* All Contacts | Sorted by Email */
//	public List<Flight> findAllByEmail(boolean sort) {
//		if (sort) {
//			return flightDao.findAllByOrderByEmailAsc();
//		} else {
//			return flightDao.findAllByOrderByEmailDesc();
//		}
//	}
//
//	/* Find Contact by Name */
//	public List<Flight> findByContactName(String contactName) {
//		return flightDao.findByContactname2(contactName);
//	}
//
//	/* Find Contact by Email */
//	public List<Flight> findByEmail(String email) {
//		return flightDao.findByEmailLike(email);
//	}
//
//	/* Find Contact by HomePhone */
//	public List<Flight> findByPhone(String phone) {
//		return flightDao.findByPhoneLike(phone, phone);
//	}
//
//	/* Find Contact by Address */
//	public List<Flight> findByAddress(String address) {
//		return flightDao.findByAddressLike(address);
//	}
//	
//	public Flight findById(Long id) {
//		return flightDao.findOne(id);
//	}
//
//	public void delete(Long id) {
//		flightDao.delete(id);
//	}
	
	/* SAVE */
	public Long save(Flight contact) {
		return flightDao.save(contact).getFlight_ID();
	}
}
