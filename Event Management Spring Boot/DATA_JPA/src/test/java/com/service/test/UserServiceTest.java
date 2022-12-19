package com.service.test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ems.repository.UserRepo;
import com.ems.service.UserService;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepo userRepo;
	
	private UserService userService;
	
	@BeforeEach
	void setup(){
		
		this.userService = new UserService();
		
	}
	
	@Test
	void getAllUsers() {
	  userService.getAllUsers();
	  verify(userRepo).findAll();
	}

}
