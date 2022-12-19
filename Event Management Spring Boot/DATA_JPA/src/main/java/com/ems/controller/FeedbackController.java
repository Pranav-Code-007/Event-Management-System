package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ems.model.Feedback;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	RestTemplate restTemplate;
	private String url = "http://localhost:9090/feedback";
	
	@GetMapping("/getall")
	ResponseEntity<Feedback[]> getAllFeedabacks(){
		return restTemplate.getForEntity(url+"/getall", Feedback[].class);
	} 
	
	@GetMapping("/getbyuserid/{id}")
	ResponseEntity<Feedback[]> getFeedabacksByUserId(@PathVariable Integer id){
		return restTemplate.getForEntity(url+"/getbyuserid/"+id, Feedback[].class);
	} 

	@GetMapping("/getbyid/{id}")
	ResponseEntity<Feedback> getFeedbackById(@PathVariable Integer id){
		return restTemplate.getForEntity(url+"/getbyid/"+id, Feedback.class);
	}
	
	@PostMapping("/addfeedback")
	ResponseEntity<String> addFeedabck(@RequestBody Feedback feedback){
		return restTemplate.postForEntity(url+"/addfeedback", feedback, String.class);
	}
	
	@GetMapping("/getcount")
	ResponseEntity<String> getCount(){
		return restTemplate.getForEntity(url+"/getcount", String.class);
	}
	
	
}
