package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.model.EventCategory;

@Repository
public interface EventCategoryRepo extends JpaRepository<EventCategory, Integer> {

	EventCategory findByCategory(String category);

}
