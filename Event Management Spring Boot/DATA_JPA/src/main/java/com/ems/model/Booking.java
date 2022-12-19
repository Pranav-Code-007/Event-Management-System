package com.ems.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {

	@GeneratedValue
	@Id
	Integer bookingId;
	
	/**
	 * status = pending
	 * status = confirmed
	 * */
	@Column(name="status")
	String status;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	
	@ManyToOne
	@JoinColumn(name="eventId")
	private Event event;
	
	public String getStatus() {
		return status;
	}


	public Booking(int id, String status, User user, Event event) {
		super();
		this.bookingId = id;
		this.status = status;
		this.user = user;
		this.event = event;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	
//	int user_id;
//	
//	int event_id;
	
	
	public Booking() {
		
	}


	/**
	 * @return the id
	 */
	public int getBookingId() {
		return bookingId;
	}


	/**
	 * @param id the id to set
	 */
	public void setBookingId(int id) {
		this.bookingId = id;
	}


	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}


	/**
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}


	/**
	 * @param event the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}


//	/**
//	 * @return the user_id
//	 */
//	public int getUser_id() {
//		return user_id;
//	}
//
//
//	/**
//	 * @param user_id the user_id to set
//	 */
//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}
//
//
//	/**
//	 * @return the event_id
//	 */
//	public int getEvent_id() {
//		return event_id;
//	}
//
//
//	/**
//	 * @param event_id the event_id to set
//	 */
//	public void setEvent_id(int event_id) {
//		this.event_id = event_id;
//	}

}
