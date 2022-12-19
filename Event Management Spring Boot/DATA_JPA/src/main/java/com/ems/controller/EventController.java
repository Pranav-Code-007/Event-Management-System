package com.ems.controller;

import com.ems.service.EventService;
import com.ems.utility.GeneralUtil;
import com.ems.model.Event;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	EventService eventService;
	
	@GetMapping("/getEvent/{id}")
	public ResponseEntity<Event> getEvent(@PathVariable Integer id){
		return new ResponseEntity<Event>(eventService.getEvent(id),HttpStatus.OK);
	}
	
	@PostMapping("/addEvent")
	public ResponseEntity<String> addEvent(@RequestBody Event event){
		eventService.addEvent(event);
		return new ResponseEntity<String>(GeneralUtil.toJson("added"),HttpStatus.OK);
	}
	
	@PutMapping("/updateEvent/{id}")
	public ResponseEntity<String> updateEvent(@PathVariable Integer id, @RequestBody Event event){
		eventService.updateEvent(id,event);
		return new ResponseEntity<String>(GeneralUtil.toJson("updated"),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEvent/{id}")
	public ResponseEntity<String> deleteEvent(@PathVariable Integer id){
		if(eventService.deleteEvent(id))
		return new ResponseEntity<String>(GeneralUtil.toJson("deleted"),HttpStatus.OK);
		return new ResponseEntity<String>(GeneralUtil.toJson("not deleted"),HttpStatus.OK);
	}
	
	@GetMapping("/getAllEvents")
	public ResponseEntity<List<Event>> getEventsList(){
		return new ResponseEntity<List<Event>>(eventService.getAllEvents(),HttpStatus.OK);
	}
	
	/**
	 * returns the list of events created by oragnizer
	 * */
	@GetMapping("getEventByOrganizer/{id}")
	public ResponseEntity<List<Event>> getEventsByOrganizer(@PathVariable Integer id){
		return new ResponseEntity<List<Event>>(eventService.getEventsByOragnizer(id),HttpStatus.OK);
	}
	
	@GetMapping("getcount")
	public ResponseEntity<String> getEventCount(){
		return new ResponseEntity<>(GeneralUtil.toJson(eventService.getEventsCount()),HttpStatus.OK);
	}

}
