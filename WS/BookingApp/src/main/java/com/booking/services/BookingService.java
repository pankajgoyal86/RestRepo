/**
 * 
 */
package com.booking.services;

import java.util.List;



import com.booking.entity.Booking;

/**
 * @author pgoya6
 *
 */

public interface BookingService {
	
	public List<Booking> getBooking();
	public Booking postBooking(Booking b);
	

}