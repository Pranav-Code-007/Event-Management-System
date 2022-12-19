package com.ems.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.ems.model.Booking;
import com.ems.model.User;
import com.ems.repository.UserRepo;


@Service
public class UserService {

	private static Logger logger=Logger.getLogger(UserService.class);
	
	@Autowired
	UserRepo userRepo;

	@Autowired
	EmailService emailService;
	
	public String getNameById(int id) {
		logger.info("Inside UserService => String getNameById");
		return userRepo.findById(id).get().getName();
	}

	public User getUserById(int id) {
		try {
			logger.info("Inside UserService => User getUserById method )");
		return userRepo.findById(id).get();}
		catch(Exception e) {
			logger.error("getUserByIf failed id was not present in database");
			System.out.println("id with that user not found getUserById in UserService");
			return null;
		}
	}

	public User getUserByEmail(String email) {
	    logger.info("User getUserByEmail");
		return userRepo.findByEmail(email);
	}
	
	
	/**
	 * @return true if user get stored ,
	 * otherwise false
	 * */
	public boolean addUser(User user) {
		
		try {
			boolean flag = false;
			int id = userRepo.save(user).getUserId();
		System.out.println("id "+id);
		flag = true;
		emailService.sendVerificationEmail(user, "http://localhost:8089/user/activateAccount/"+id);
		logger.setLevel(Level.INFO);
		logger.info("addUser");
		return flag;}
		catch(Exception e) {
			e.printStackTrace();
			logger.setLevel(Level.ERROR);
			logger.info("could not addUser");
			System.out.println("error while adding user"+e);
			return false;
		}
		
	}

	public boolean deleteUser(int id) {
		try {
		userRepo.delete(userRepo.findById(id).get());
		logger.setLevel(Level.INFO);
		logger.info("deleteUser");
		return true;}
		catch(Exception exception) {
			logger.setLevel(Level.ERROR);
			logger.info("could not deleteUser");
			return false;
		}
	}
	
	
	public boolean updateStatus(int id,int status) {
		User user = userRepo.findById(id).get();
		user.setStatus(status);
		userRepo.save(user);
		logger.setLevel(Level.INFO);
		logger.info("updateStatus");
		return true;
	}
	
	public boolean updateLoginAttempts(int id,int attempts) {
		User user = userRepo.findById(id).get();
		user.setLoginAttempts(attempts);
		userRepo.save(user);
		logger.setLevel(Level.INFO);
		logger.info("updateLoginAttempts");
		return true;
	}
	
	public boolean updateOTP(int id,Integer otp) {
		User user = userRepo.findById(id).get();
		user.setOtp(otp);
		userRepo.save(user);
		logger.setLevel(Level.INFO);
		logger.info("updateOTP");
		return true;
	}
	/**
	 * *
	 * 
	 * @param id   : int
	 * @param user : User
	 * @return User updated object else Generate error if user does not find
	 */
	public User updateUserById(int id, User user) {
		User user1 = userRepo.findById(id).get();

		if (user.getName() != null)
			user1.setName(user.getName());

		if (user.getBookings() != null)
			user1.setBookings(user.getBookings());

		if (user.getMobile_number() != null)
			user1.setMobile_number(user.getMobile_number());

		if (user.getPassword() != null)
			user1.setPassword(user.getPassword());

		if (user.getEmail() != null)
			user1.setEmail(user.getEmail());

		if (user.getRole() != null)
			user1.setRole(user.getRole());

		if (user.getLoginAttempts() != -1)
			user1.setLoginAttempts(user.getLoginAttempts());

		if (user.getStatus() != -1)
			user1.setStatus(user.getStatus());

		logger.setLevel(Level.INFO);
		logger.info("updateUserById");
		
		
		return userRepo.save(user1);
	}

	/**
	 * returns bookings done by user of role "user"
	 */
	public List<Booking> getBookingByUserByUserId(int user_id) {
		return userRepo.findById(user_id).get().getBookings();
	}

	/**
	 * returns the list of all users
	 */
	public List<User> getAllUsers() {
		logger.setLevel(Level.INFO);
		logger.info("getAllUsers");
		return userRepo.findAll();

	}

	/**
	 * return the list of user by their role
	 */
	public List<User> getUsersByRole(String role) {
		
		logger.setLevel(Level.INFO);
		logger.info("getUsersByRole");
		return userRepo.findByRole(role);
	}

    
	
	public boolean isPasswordCorrect(User user) {
		return this.getUserByEmail(user.getEmail()).getPassword().equals(user.getPassword());
		
	}
	
	public Integer getCountOfUser() {
		return this.getUsersByRole("user").size();
	}

}
