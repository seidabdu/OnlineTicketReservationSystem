package edu.mum.cs544.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import edu.mum.cs544.domain.Passenger;

@Repository
public interface PassengerDAO extends JpaRepository<Passenger, Long> {
    
    
   
//   @Query("SELECT p FROM Passenger p WHERE p.userName like ?1% ORDER BY p.userName")
//	Passenger  findByUserNameAndPassword(String username, String Password);
	
//	
//	// For Searching
//	@Query("SELECT p FROM Passenger p WHERE p.userName = :username AND p.password = :password ")
//	Passenger findByUsernameAndPassword(String username, String password);
//	
//	// List<Contact> findByFirstnameLike(String contactName);
//	@Query("SELECT c FROM Contact c WHERE c.email like ?1% ORDER BY c.email")
//	List<Passenger> findByEmailLike(String email);
//	
//	@Query("SELECT c FROM Contact c WHERE c.homePhone like ?1% or c.mobile like ?2% ORDER BY c.contactName")
//	List<Passenger> findByPhoneLike(String phone1, String phone2);
//	
	@Query("SELECT c FROM Passenger c WHERE c.userName like %?1% ORDER BY c.userName")
	List<Passenger> findByUserName(String address);
//
//	
//	// For Sorting Part
//	List<Passenger> findAllByOrderByContactIdAsc();
//
//	List<Passenger> findAllByOrderByContactIdDesc();
//
//	List<Passenger> findAllByOrderByContactNameAsc();
//
//	List<Passenger> findAllByOrderByContactNameDesc();
//
//	List<Passenger> findAllByOrderByAddressAsc();
//
//	List<Passenger> findAllByOrderByAddressDesc();
//
//	List<Passenger> findAllByOrderByEmailAsc();
//
//	List<Passenger> findAllByOrderByEmailDesc();
//
//	List<Passenger> findAllByOrderByMobileAsc();
//
//	List<Passenger> findAllByOrderByMobileDesc();

}
