package com.feed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feed.model.Feedback;
import com.feed.repository.FeedbackRepo;

@Service
public class FeedbackService {
    @Autowired
    FeedbackRepo repo;
    
    public List<Feedback> getAllFeedbacks(){
    	return repo.findAll();
    }
	
    public List<Feedback> getFeedbackByUserId(Integer userId){
    	return repo.findByUserId(userId);
    }
    
    public Feedback getFeedbackById(Integer feedbackId) {
    	return repo.findById(feedbackId).get();
    }
    
    public Boolean addFeedback(Feedback feedback) {
    	try{repo.save(feedback);
    	return true;}
    	catch(Exception exception) {
    		return false;
    	}
    	
    	
    }

	public Long getFeedbackCount() {
		// TODO Auto-generated method stub
		return repo.count();
	}
    
}
