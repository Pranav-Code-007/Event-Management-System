package com.feed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feed.model.Feedback;


public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {

	List<Feedback> findByUserId(Integer userId);
	
}
