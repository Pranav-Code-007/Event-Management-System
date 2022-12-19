package com.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	List<User> findByRole(String role);

	User findByEmail(String email);

}
