package com.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ems.model.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer>{
//     public List<Booking> findAllByUserId(Integer user_id);
//     public List<Booking> findAllByEventId(Integer event_id);
       
//     @Query("FROM Booking where user_id=?1")
//     List<Booking> getBookingByUser(Integer user_id);
     
     //SELECT column_name(s)
//     FROM table1
//     INNER JOIN table2
//     ON table1.column_name = table2.column_name;
     
	@Query(value="select * FROM Booking where user_id=?1 ",nativeQuery=true)
    List<Booking> getBookingByUserId(Integer userId);
	
	@Query(value="select * FROM Booking where event_id=?1 ",nativeQuery=true)
	List<Booking> getBookingByEventId(Integer event_id);
	
     @Query(value="select * FROM Booking where user_id=?1 and event_id=?2",nativeQuery=true)
     Booking getBookingByUserAndEventId(Integer userId, Integer eventId);

	
}
