package edu.mum.cs544.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import edu.mum.cs544.domain.Flight;
import edu.mum.cs544.domain.Ticket;

@Repository
public interface FlightDAO extends JpaRepository<Flight, Long> {
	
	
//	// For Searching
	@Query("SELECT f FROM Flight f WHERE f.airline_name like ?1% ORDER BY f.airline_name")   
	
	 List<Flight> findByAirlineName(String airlinename);
	@Query("SELECT f FROM Flight f WHERE f.from_location like ?1% ORDER BY f.from_location")
	List<Flight> findByFromLocation(String fomlocation);
        @Query("SELECT f FROM Flight f WHERE f.to_location like ?1% ORDER BY f.to_location")
	List<Flight> findByToLocation(String to_location);
        
        
//        List<Flight> findByairline_name(String lastname);	
	@Query("SELECT f FROM Flight f WHERE f.from_location like ?1% and f.to_location like ?2% ORDER BY f.from_location")
	List<Flight> findByFromLocationAndToLocation(String from, String to);	
//	@Query("SELECT f FROM Flight f WHERE f.price like %?1% ORDER BY f.price")
//	List<Flight> findByprice(Double price);//	
//	// For Sorting Part
//	List<Flight> findAllByOrderByContactIdAsc();//
//	List<Flight> findAllByOrderByContactIdDesc();//
//	List<Flight> findAllByOrderByContactNameAsc();//
//	List<Flight> findAllByOrderByContactNameDesc();//
//	List<Flight> findAllByOrderByAddressAsc();//
//	List<Flight> findAllByOrderByAddressDesc();//
//	List<Flight> findAllByOrderByEmailAsc();//
//	List<Flight> findAllByOrderByEmailDesc();//
//	List<Flight> findAllByOrderByMobileAsc();//
//	List<Flight> findAllByOrderByMobileDesc();
//    Flight findOne( Ticket tkt );

}
