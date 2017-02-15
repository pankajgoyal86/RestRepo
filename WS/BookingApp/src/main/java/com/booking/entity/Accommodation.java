/**
 * 
 */
package com.booking.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author pgoya6
 *
 */
@Entity
public class Accommodation implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	private String hotelName;
	private String city;
	private String roomId;
	@ManyToOne
	@JoinColumn(name="bookingId")
	private Booking booking;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	/**
	 * 
	 */
	public Accommodation() {
		super();
	}
	
	
	/**
	 * @param id
	 * @param hotelName
	 * @param city
	 * @param roomId
	 * @param booking
	 */
	public Accommodation(String id, String hotelName, String city, String roomId) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		this.city = city;
		this.roomId = roomId;
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accommodation other = (Accommodation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
