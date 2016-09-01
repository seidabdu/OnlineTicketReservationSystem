package edu.mum.cs544.dao;

import edu.mum.cs544.domain.Passenger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import edu.mum.cs544.domain.Ticket;;

@Repository
public interface TicketDAO extends JpaRepository<Ticket, Long> {
	
//	
//	// For Searching
//	@Query("SELECT c FROM Ticket c WHERE c.contactName like ?1% ORDER BY c.contactName")
//	List<Ticket> findByContactname2(String contactName);
//	
//	// List<Contact> findByFirstnameLike(String contactName);
//	@Query("SELECT c FROM Ticket c WHERE c.email like ?1% ORDER BY c.email")
//	List<Ticket> findByEmailLike(String email);
//	
	
//	
//	@Query("SELECT c FROM Ticket c WHERE c.address like %?1% ORDER BY c.address")
//	List<Ticket> findByAddressLike(String address);
//
//	
//	// For Sorting Part
//	List<Ticket> findAllByOrderByContactIdAsc();
//
//	List<Ticket> findAllByOrderByContactIdDesc();
//
//	List<Ticket> findAllByOrderByContactNameAsc();
//
//	List<Ticket> findAllByOrderByContactNameDesc();
//
//	List<Ticket> findAllByOrderByAddressAsc();
//
//	List<Ticket> findAllByOrderByAddressDesc();
//
//	List<Ticket> findAllByOrderByEmailAsc();
//
//	List<Ticket> findAllByOrderByEmailDesc();
//
//	List<Ticket> findAllByOrderByMobileAsc();
//
//	List<Ticket> findAllByOrderByMobileDesc();
    

}
