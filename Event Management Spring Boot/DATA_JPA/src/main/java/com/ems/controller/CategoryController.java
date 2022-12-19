package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ems.model.EventCategory;
import com.ems.service.EventCategoryService;
import com.ems.utility.GeneralUtil;

@CrossOrigin("http://localhost:4200/")
@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	EventCategoryService eventCategoryService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<EventCategory>> getAllEvents(){
		return new ResponseEntity<List<EventCategory>>(eventCategoryService.getAllCategories(),HttpStatus.OK);
	}
	
	@PostMapping("/add/{category}")
	public ResponseEntity<String> addCategory(@PathVariable String category){
		return new ResponseEntity<String>(GeneralUtil.toJson("result"+eventCategoryService.addEventCategory(category)),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{category}/{updateCategory}")
	public ResponseEntity<String> updateCategory(@PathVariable String category, @PathVariable String updateCategory){
		return new ResponseEntity<String>(GeneralUtil.toJson("result"+eventCategoryService.updateEventCategory(category, updateCategory)),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{category}")
	public ResponseEntity<String> deleteCategory(@PathVariable String category){
		return new ResponseEntity<String>(GeneralUtil.toJson("result "+eventCategoryService.deleteEventCategory(category)),HttpStatus.OK);
	}
	

}
