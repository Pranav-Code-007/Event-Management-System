package com.feed.controller;

import com.feed.model.Feedback;
import com.feed.service.FeedbackService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	FeedbackService service;
	
	
	@GetMapping("/getall")
	ResponseEntity<List<Feedback>> getAllFeedabacks(){
		return new ResponseEntity<>(service.getAllFeedbacks(),HttpStatus.OK);
	} 
	
	@GetMapping("/getbyuserid/{id}")
	ResponseEntity<List<Feedback>> getFeedabacksByUserId(@PathVariable Integer id){
		return new ResponseEntity<>(service.getFeedbackByUserId(id),HttpStatus.OK);
	} 

	@GetMapping("/getbyid/{id}")
	ResponseEntity<Feedback> getFeedbackById(@PathVariable Integer id){
		return new ResponseEntity<>(service.getFeedbackById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getcount")
	ResponseEntity<String> getCount(){
		return new ResponseEntity<>(service.getFeedbackCount().toString(),HttpStatus.OK);
	}
	
	@PostMapping("/addfeedback")
	ResponseEntity<String> addFeedabck(@RequestBody Feedback feedback){
		if(service.addFeedback(feedback))
		return new ResponseEntity<>("added",HttpStatus.OK);
		return new ResponseEntity<>("not added",HttpStatus.OK);
	}
	
  
	
	
}
