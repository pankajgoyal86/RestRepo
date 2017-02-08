/**
 * 
 */
package com.booking.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author pgoya6
 *
 */
@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	private String bookingiD;
	private String userName;
	private Date startDate;
	private Date endDate;
	
	
	public String getBookingiD() {
		return bookingiD;
	}
	public void setBookingiD(String bookingiD) {
		this.bookingiD = bookingiD;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Booking() {

	}
	public Booking(String id, String bookingiD, String userName, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.bookingiD = bookingiD;
		this.userName = userName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	

}
