/**
 * 
 */
package com.booking.model;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.entity.Booking;

/**
 * @author pgoya6
 *
 */
@Repository
public interface BookingDAO extends JpaRepository<Booking, String> {
	


}
