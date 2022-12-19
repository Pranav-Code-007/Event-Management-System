package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.model.Event;
import com.ems.repository.EventRepo;

@Service
public class EventService {

	@Autowired
	private EventRepo eventRepo;
	
	public Event getEvent(int id) {
		return eventRepo.findById(id).get();
	}
	
	public String getEventNameById(int id) {
		return eventRepo.findById(id).get().getName();
	}

	public void addEvent(Event event) {
		eventRepo.save(event);
	}
	
	public List<Event> getAllEvents(){
		return eventRepo.findAll();
	}

	public void updateEvent(Integer eventId, Event event) {
		
		Event storedEvent = eventRepo.findById(eventId).get();
		if(!event.getCategory().equals(storedEvent.getCategory())) 
			storedEvent.setCategory(event.getCategory());
		
		if(!event.getDate().equals(storedEvent.getDate())) 
			storedEvent.setDate(event.getDate());
		
		if(!event.getDescription().contentEquals(storedEvent.getDescription())) 
			storedEvent.setDescription(event.getDescription());
		
		if(!event.getVenue().contentEquals(storedEvent.getVenue()))
			storedEvent.setVenue(event.getVenue());
		
		if(!event.getPrice().equals(storedEvent.getPrice()))
			storedEvent.setPrice(event.getPrice());
		
		if(!event.getName().contentEquals(storedEvent.getName())) 
			storedEvent.setName(event.getName());
		
		eventRepo.save(storedEvent);
		
	}
	
	public boolean deleteEvent(Integer eventId) {
		try {
		eventRepo.deleteById(eventId);
		return true;
		}
		catch(Exception exception) {
			System.out.println("error in deleteEvent "+exception.getMessage());
			
		}
		return false;
	}

	public List<Event> getEventsByOragnizer(Integer id) {
		return eventRepo.getEventsCreatedByOrganizer(id);
		
	}

	public String getEventsCount() {
		
		return String.valueOf(eventRepo.count());
	}
	
}
