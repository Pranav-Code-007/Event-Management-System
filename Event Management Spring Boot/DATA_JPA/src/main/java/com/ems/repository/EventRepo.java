package com.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ems.model.Event;

@Repository
public interface EventRepo extends JpaRepository<Event,Integer>{
    @Query(value="select * from event where user_id=?1",nativeQuery=true)
	List<Event> getEventsCreatedByOrganizer(Integer id);

}
