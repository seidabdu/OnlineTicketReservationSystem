package edu.mum.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.dao.PassengerDAO;
import edu.mum.cs544.domain.Passenger;

@Service
public class PassengerService {

	@Autowired
	private PassengerDAO passengerDao;

	/* All Contacts */
	public List<Passenger> findAll() {
		return passengerDao.findAll();
	}

        
//	/* All Contacts | Sorted by ID */
//	public List<Passenger> findAllByContactId(boolean sort) {
//		if (sort) {
//			return passengerDao.findAllByOrderByContactIdAsc();
//		} else {
//			return passengerDao.findAllByOrderByContactIdDesc();
//		}
//	}
//
//	/* All Contacts | Sorted by Name */
//	public List<Passenger> findAllByName(boolean sort) {
//		if (sort) {
//			return passengerDao.findAllByOrderByContactNameAsc();
//		} else {
//			return passengerDao.findAllByOrderByContactNameDesc();
//		}
//	}
//
//	/* All Contacts | Sorted by Address */
//	public List<Passenger> findAllByAddress(boolean sort) {
//		if (sort) {
//			return passengerDao.findAllByOrderByAddressAsc();
//		} else {
//			return passengerDao.findAllByOrderByAddressDesc();
//		}
//	}
//
//	/* All Contacts | Sorted by Mobile */
//	public List<Passenger> findAllByMobile(boolean sort) {
//		if (sort) {
//			return passengerDao.findAllByOrderByMobileAsc();
//		} else {
//			return passengerDao.findAllByOrderByMobileDesc();
//		}
//	}
//
//	/* All Contacts | Sorted by Email */
//	public List<Passenger> findAllByEmail(boolean sort) {
//		if (sort) {
//			return passengerDao.findAllByOrderByEmailAsc();
//		} else {
//			return passengerDao.findAllByOrderByEmailDesc();
//		}
//	}
//
//	/* Find Contact by Name */
//	public List<Passenger> findByContactName(String contactName) {
//		return passengerDao.findByContactname2(contactName);
//	}
//
//	/* Find Contact by Email */
//	public List<Passenger> findByEmail(String email) {
//		return passengerDao.findByEmailLike(email);
//	}
//
//	/* Find Contact by HomePhone */
//	public List<Passenger> findByPhone(String phone) {
//		return passengerDao.findByPhoneLike(phone, phone);
//	}
//
//	/* Find Contact by Address */
//	public List<Passenger> findByAddress(String address) {
//		return passengerDao.findByAddressLike(address);
//	}
//	
        
        public Passenger  getPassenger(String username,String password){
            
              List<Passenger> plist=passengerDao.findByUserName(username);
                  for(Passenger p:plist)
                  {
                    if(p.getPassword().equals(password) && p.getUserName().equals(username))
                        return p;
                  }
                return new Passenger();
        }
	public Passenger findById(Long id) {
		return passengerDao.findOne(id);
	}

	public void delete(Long id) {
		passengerDao.delete(id);
	}
	
	/* SAVE */
	public Long save(Passenger contact) {
		
            return passengerDao.save(contact).getPassenger_id();
	}
        
        public boolean authenticateUser( Passenger passenger_ ) {
            
           Passenger passenger = passengerDao.findOne( passenger_.getPassenger_id());
           
           return passenger != null;
            
            
        }
        
//        public Passenger findByUsernameAndPassword( String username, String password ){
//        
//            return passengerDao.findByUsernameAndPassword(username, password);
//        }
        
     }
