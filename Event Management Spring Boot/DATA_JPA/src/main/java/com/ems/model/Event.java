package com.ems.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="event")
public class Event {
    
	@GeneratedValue
	@Id
	Integer eventId;
	
	@Column(name="event_name")
	String name;
	
	String category;
	
	String venue;
	
	LocalDate date;
	
	LocalTime time;
	
	Integer price;
	
	String description;

	
	
	public Event(Integer id, String name, String type, String venue, LocalDate date, LocalTime time, Integer price,
			String description, User user, List<Booking> bookings) {
		super();
		this.eventId = id;
		this.name = name;
		this.category = type;
		this.venue = venue;
		this.date = date;
		this.time = time;
		this.price = price;
		this.description = description;
		this.user = user;
		this.bookings = bookings;
	}

	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@JsonIgnore
	@OneToMany(mappedBy="event",cascade=CascadeType.ALL)
	private List<Booking> bookings;
	
	public Event() {
		
	}

	/**
	 * @return the id
	 */
	public int getEventId() {
		return eventId;
	}

	/**
	 * @param id the id to set
	 */
	public void setEventId(int id) {
		this.eventId = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param type the type to set
	 */
	public void setCategory(String type) {
		this.category = type;
	}

	/**
	 * @return the venue
	 */
	public String getVenue() {
		return venue;
	}

	/**
	 * @param venue the venue to set
	 */
	public void setVenue(String venue) {
		this.venue = venue;
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
	 * @return the bookings
	 */
	public List<Booking> getBookings() {
		return bookings;
	}

	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the time
	 */
	public LocalTime getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(LocalTime time) {
		this.time = time;
	}

	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
