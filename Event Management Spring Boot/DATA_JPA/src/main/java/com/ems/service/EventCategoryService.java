package com.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.ems.model.EventCategory;
import com.ems.repository.EventCategoryRepo;

@Service
public class EventCategoryService {

	@Autowired
	EventCategoryRepo eventCategoryRepo;
	
	public boolean updateEventCategory(String eventCategory, String newEventCategory) {
		
		try {
		EventCategory category = eventCategoryRepo.findByCategory(eventCategory);
		category.setCategory(newEventCategory);
		eventCategoryRepo.save(category);
		return true;
		}
	catch(Exception exception) {
	     System.out.println("Error while updatinf event category"+exception.getMessage());
	}
	return false;
	}
	
	public List<EventCategory> getAllCategories(){
		
		return eventCategoryRepo.findAll();
	}
	
	public boolean addEventCategory(String category) {
		try {
		 eventCategoryRepo.save(new EventCategory(category));
		 return true;}
		catch(Exception exception) {
			System.out.println("Error while adding category "+exception.getMessage());
		}
		return false;
	}
	
	public boolean deleteEventCategory(String eventCategory) {
		try {
			eventCategoryRepo.delete(eventCategoryRepo.findByCategory(eventCategory));
		    return true;
		}
		catch(Exception exception) {
			System.out.println("Error while deleting event category"+exception.getMessage());
		}
		return false;
	}

}
