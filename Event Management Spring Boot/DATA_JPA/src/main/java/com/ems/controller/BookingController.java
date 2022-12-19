package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.Booking;
import com.ems.model.Event;
import com.ems.service.BookingService;
import com.ems.service.EventService;
import com.ems.service.UserService;
import com.ems.utility.GeneralUtil;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	EventService eventService;
	
	/**
	 * returns booking list by userId
	 * */
	@GetMapping("/user/{id}")
	public ResponseEntity<List<Booking>> getBookingsByUserId(@PathVariable Integer id){
		
		return new ResponseEntity<List<Booking>>(bookingService.getBookingsByUserId(id), HttpStatus.OK);
		
	}
	
	/**
	 * returns booking List by eventId
	 * */
	@GetMapping("/event/{id}")
	public ResponseEntity<List<Booking>> getBookingsByEventId(@PathVariable Integer id){
		return new ResponseEntity<List<Booking>>(bookingService.getBookingsByEventId(id), HttpStatus.OK);
	}
	
	@PostMapping("/addBooking")
	public ResponseEntity<String> addBooking(@RequestBody Booking booking){
		String message = "already added";
		if(bookingService.getBookingByEventAndUserId(booking.getUser().getUserId(), booking.getEvent().getEventId())==null) {
			bookingService.addBooking(booking);
			message="added";
		}
		
		
		return new ResponseEntity<String>(GeneralUtil.toJson(message),HttpStatus.CREATED);
	}
	
	@PutMapping("/updateBookingStatus/{id}/{status}")
	public ResponseEntity<String> updateStatus(@PathVariable Integer id,@PathVariable String status){
		bookingService.updateStatus(id,status);
		return new ResponseEntity<String>(GeneralUtil.toJson("updated"),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteBooking/{id}")
	public ResponseEntity<String> deleteBooking(@PathVariable Integer id){
		bookingService.deleteBookingById(id);
		return new ResponseEntity<String>(GeneralUtil.toJson("deleted"),HttpStatus.OK);
	}
	
	/**
	 * returns the all types of booking
	 * */
	@GetMapping("/getAll")
	public ResponseEntity<List<Booking>> getAllBookings(){
		return new ResponseEntity<List<Booking>>(bookingService.getAllBooking(),HttpStatus.OK);
	}
	
	/**
	 * returns event by evenId
	 * */
	@GetMapping("/getById/{id}")
	public ResponseEntity<Booking> getBooking(@PathVariable Integer id){
		return new ResponseEntity<Booking>(bookingService.getBookingById(id),HttpStatus.OK);
	}
	
	/**
	 * Call it when you need is event booked or not
	 * */
	@GetMapping("/getEventAndUser/{eventid}/{userid}")
	public ResponseEntity<Boolean> getEventAndUser(@PathVariable Integer eventid, @PathVariable Integer userid){
		Boolean answer =true;
		if(bookingService.getBookingByEventAndUserId(userid, eventid)==null) {
			answer = false;
		}
		return new ResponseEntity<Boolean>(answer,HttpStatus.OK);
	}
	
	@GetMapping("/getcount")
	public ResponseEntity<String> getBookingsCount(){
		return new ResponseEntity<>(GeneralUtil.toJson(bookingService.getCount().toString()),HttpStatus.OK);
	}

}
