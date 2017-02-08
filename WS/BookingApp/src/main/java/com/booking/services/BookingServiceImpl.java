/**
 * 
 */
package com.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.entity.Booking;
import com.booking.model.BookingDAO;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {

	@Autowired	
	private BookingDAO bookingDAO;
	
	@Override
	public List<Booking> getBooking() {
		// TODO Auto-generated method stub
		List<Booking> bookingList=bookingDAO.findAll();
		return bookingList;
	}

	@Override
	public Booking postBooking(Booking booking) {
		// TODO Auto-generated method stub
		Booking newBooking=bookingDAO.save(booking);
		return newBooking;
	}

}
