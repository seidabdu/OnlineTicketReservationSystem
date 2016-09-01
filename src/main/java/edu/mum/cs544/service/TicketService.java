package edu.mum.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.dao.TicketDAO;
import edu.mum.cs544.domain.Passenger;
import edu.mum.cs544.domain.Ticket;

@Service
public class TicketService {

	@Autowired
	private TicketDAO ticketDao;

	/* All Contacts */
	public List<Ticket> findAll() {
		return ticketDao.findAll();
	}

        public  Ticket findAOne( Long ticketID) {
		return ticketDao.findOne(ticketID);
	}
        
       
        
//	/* All Contacts | Sorted by ID */
//	public List<Ticket> findAllByContactId(boolean sort) {
//		if (sort) {
//			return ticketDao.findAllByOrderByContactIdAsc();
//		} else {
//			return ticketDao.findAllByOrderByContactIdDesc();
//		}
//	}
//
//	/* All Contacts | Sorted by Name */
//	public List<Ticket> findAllByName(boolean sort) {
//		if (sort) {
//			return ticketDao.findAllByOrderByContactNameAsc();
//		} else {
//			return ticketDao.findAllByOrderByContactNameDesc();
//		}
//	}
//
//	/* All Contacts | Sorted by Address */
//	public List<Ticket> findAllByAddress(boolean sort) {
//		if (sort) {
//			return ticketDao.findAllByOrderByAddressAsc();
//		} else {
//			return ticketDao.findAllByOrderByAddressDesc();
//		}
//	}
//
//	/* All Contacts | Sorted by Mobile */
//	public List<Ticket> findAllByMobile(boolean sort) {
//		if (sort) {
//			return ticketDao.findAllByOrderByMobileAsc();
//		} else {
//			return ticketDao.findAllByOrderByMobileDesc();
//		}
//	}
//
//	/* All Contacts | Sorted by Email */
//	public List<Ticket> findAllByEmail(boolean sort) {
//		if (sort) {
//			return ticketDao.findAllByOrderByEmailAsc();
//		} else {
//			return ticketDao.findAllByOrderByEmailDesc();
//		}
//	}
//
//	/* Find Contact by Name */
//	public List<Ticket> findByContactName(String contactName) {
//		return ticketDao.findByContactname2(contactName);
//	}
//
//	/* Find Contact by Email */
//	public List<Ticket> findByEmail(String email) {
//		return ticketDao.findByEmailLike(email);
//	}
//
//	/* Find Contact by HomePhone */
//	public List<Ticket> findByPhone(String phone) {
//		return ticketDao.findByPhoneLike(phone, phone);
//	}
//
//	/* Find Contact by Address */
//	public List<Ticket> findByAddress(String address) {
//		return ticketDao.findByAddressLike(address);
//	}
	
	public Ticket findById(Long id) {
		return ticketDao.findOne(id);
	}
        public void update(Ticket t) {
            ticketDao.save(t);
		
	}

	public void delete(Long id) {
		ticketDao.delete(id);
	}
	
	/* SAVE */
	public Long save(Ticket contact) {
		return ticketDao.save(contact).getTicket_ID();
	}
        
}
