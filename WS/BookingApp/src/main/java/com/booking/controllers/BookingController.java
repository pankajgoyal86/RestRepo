/**
 * 
 */
package com.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.booking.entity.Booking;
import com.booking.services.BookingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author pgoya6
 *
 */
@Api(basePath = "/bookings", value = "Bookings", description = "Operations with Bookings", produces = "application/json")
@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	/*@ApiOperation(value = "getBookings", nickname = "getBookings")
	@RequestMapping(method=RequestMethod.GET)
	public String bookingOverview(){
		return "bookingOverview";
	}*/
	
	@ApiOperation(value = "getBookings", nickname = "getBookings", notes="Fetch list of Bookings")
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Booking.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal server error")}) 
	public ResponseEntity<List<Booking>> getbookingOverview(){
		List<Booking> bookinglist = bookingService.getBooking();
		if(bookinglist.isEmpty()){
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Booking>>(bookinglist,HttpStatus.OK);
		
		
	}
	@ApiOperation(value = "postBooking", nickname = "postBooking" , notes= "create new booking")
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Booking.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal server error")}) 
	public ResponseEntity<Booking> postBookingOverview(@RequestBody Booking booking, UriComponentsBuilder uri){
		
		Booking newBooking= bookingService.postBooking(booking);
		if(newBooking.equals(null))
		{
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri.path("/bookings/{id}").buildAndExpand(newBooking.getBookingId()).toUri());
		return new ResponseEntity<Booking>(newBooking,headers,HttpStatus.OK);
		
		
		
	}
	
	/*
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test()
	{
		return "test";
	}
	@RequestMapping(value="/test1",method=RequestMethod.GET)
	public String test1()
	{
		return "test1";
	}*/

}
