package com.ems.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.model.Booking;
import com.ems.repository.BookingRepo;

@Service
public class BookingService {


	
	@Autowired
	BookingRepo bookingRepo;
	
//	@Autowired
//	UserService userService;
	
	public boolean addBooking(Booking booking) {
		bookingRepo.save(booking);
		return true;
	}
	
	public boolean isEventBookedByUser(Integer userId, int eventId ) {
		try {
			
			
			List<Booking> bookingList = new UserService().getBookingByUserByUserId(userId).stream().filter(booking -> booking.getEvent().getEventId() == eventId ).collect(Collectors.toList());
			if(bookingList.size()==0)
				return false;
			    
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage()+"error in isEventBooked By");
			}
		return true;
	}
	
	
	public boolean setBookingStatus(Integer id,String status) {
		Booking booking = bookingRepo.findById(id).get();
		booking.setStatus(status);
		bookingRepo.save(booking);
		return true;
	}
	
	public boolean deleteBookingById(Integer booking_id) {
		bookingRepo.delete(bookingRepo.findById(booking_id).get());
		return true;
	}
	
//	public boolean deleteBookingsByEventId(Integer event_id) {
//		bookingRepo.deleteAll(bookingRepo.findAllByEventId(event_id));
//		return true;
//	}
	
//	public boolean deleteBookingsByUserId(Integer user_id) {
//		bookingRepo.deleteAll(bookingRepo.findAllByUserId(user_id));
//		return true;
//	}
	
	public Booking getBookingById(Integer id) {
		return bookingRepo.findById(id).get();
	}
	
	public Booking getBookingByEventAndUserId(Integer userId, Integer eventId) {
		return bookingRepo.getBookingByUserAndEventId(userId, eventId);
	}
	
	
	public List<Booking> getBookingsByUserId(Integer user_id) {
		return bookingRepo.getBookingByUserId(user_id);
	}
	
	public List<Booking> getBookingsByEventId(Integer event_id) {
		return bookingRepo.getBookingByEventId(event_id);
	}
	
	public List<Booking> getAllBooking(){
		return bookingRepo.findAll();
	}

	public void updateStatus(Integer id,String status) {
		Booking booking = bookingRepo.findById(id).get();
		booking.setStatus(status);	
		bookingRepo.save(booking);
	}

	public Long getCount() {
		
		return bookingRepo.count();
	}

}
