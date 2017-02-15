/**
 * 
 */
package com.booking.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author pgoya6
 *
 */
@Entity
public class Booking implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String bookingId;
	private String userName;
	private Date startDate;
	private Date endDate;
	
	@OneToMany(mappedBy="booking", cascade=CascadeType.ALL)
	private Set<Accommodation> accommodations=new HashSet<>();
	
	
	
	public Set<Accommodation> getAccommodations() {
		return accommodations;
	}
	public void setAccommodations(Set<Accommodation> accommodations) {
		this.accommodations = accommodations;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Booking() {

	}

	public Booking(String bookingId, String userName, Date startDate, Date endDate, Set<Accommodation> accommodations) {
		super();
		this.bookingId = bookingId;
		this.userName = userName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.accommodations=accommodations;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	

}
