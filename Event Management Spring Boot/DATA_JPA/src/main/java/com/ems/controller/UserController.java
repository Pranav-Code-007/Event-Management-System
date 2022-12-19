package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.exception.RecordNotFoundException;
import com.ems.model.User;
import com.ems.service.EmailService;
import com.ems.service.UserService;
import com.ems.utility.UserUtil;
import com.ems.utility.GeneralUtil;
import java.util.List;

import javax.validation.Valid;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@Autowired 
    EmailService emailService;
	
	
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		
		return new ResponseEntity<List<User>>(service.getAllUsers(), HttpStatus.OK);
		
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@Valid @RequestBody User user,BindingResult bindingResult){
		if(service.getUserByEmail(user.getEmail())!=null) {
			return new ResponseEntity<String>(GeneralUtil.toJson("user exists already"),HttpStatus.OK);
		}
		
		if(service.addUser(user))
		return new ResponseEntity<String>(GeneralUtil.toJson("registered successfully"),HttpStatus.CREATED);
		
		else {
			StringBuilder errMessage=new StringBuilder("");
			bindingResult
			.getFieldErrors()
			.stream()
			.forEach(f -> { errMessage.append(f.getField()+":"+f.getDefaultMessage()+", ");});
			return new ResponseEntity<String>(GeneralUtil.toJson(errMessage.toString()),HttpStatus.OK);	
			}
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user){
		String message = "Something went wrong";
		User storedUser = service.getUserByEmail(user.getEmail());
		Boolean isRoleMatching = storedUser.getRole().equals(user.getRole());
		
		if(storedUser==null)
			throw new RecordNotFoundException(GeneralUtil.toJson(UserUtil.USER_NOT_FOUND));
		
		else if(storedUser.getLoginAttempts()==3 && isRoleMatching)
			message = UserUtil.ACCOUNT_BLOCKED;
		
		else if(storedUser.getStatus()!=1 && isRoleMatching)
			message = UserUtil.VERIFY_ACCOUNT;
		
		else if(service.isPasswordCorrect(user) && isRoleMatching) {
			message="login successfull "+UserUtil.OTP_SENT;
			System.out.println("after OTP sent message");
			Integer otp = UserUtil.generateOTP();
			System.out.println(" after Generate OTP ");
			String otpString  = otp.toString();
			emailService.sendOTP(storedUser, otpString);
			System.out.println(" after send OTP ");
			service.updateOTP(storedUser.getUserId(), otp);
			System.out.println(" after updating otp ");
			service.updateLoginAttempts(storedUser.getUserId(), storedUser.getLoginAttempts()+1);
		}
		else {
			message = UserUtil.WRONG_PASSWORD;
			service.updateLoginAttempts(storedUser.getUserId(), storedUser.getLoginAttempts()+1);
			
		}
			return new ResponseEntity<String>(GeneralUtil.toJson(message),HttpStatus.OK);
		
	}
	
	@PostMapping("/otp/{email}/{otp}")
	public ResponseEntity<String> verifyOTP(@PathVariable String email,@PathVariable Integer otp){
		if(service.getUserByEmail(email).getOtp()==otp) {
			return new ResponseEntity<String>(GeneralUtil.toJson("login with otp successfull"),HttpStatus.OK);			
		}
		System.out.println(service.getUserByEmail(email).getOtp()+" "+otp);
		return new ResponseEntity<String>(GeneralUtil.toJson("Invalid OTP"),HttpStatus.OK);
	}
	
	@GetMapping("/activateAccount/{id}")
	public ResponseEntity<String> activateAccount(@PathVariable Integer id){
		try {
		service.updateStatus(id, 1);
		return new ResponseEntity<String>(UserUtil.VERIFICATION_PAGE,HttpStatus.OK);
		}
		catch(Exception exception) {
		throw new RecordNotFoundException(UserUtil.USER_NOT_FOUND);
		}
		
	}
	
	
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Integer id,@RequestBody User user) {
		service.updateUserById(id,user);
		
		if(service.updateUserById(id,user)!=null) {
			return new ResponseEntity<String>(GeneralUtil.toJson("updated"),HttpStatus.OK);
		}
		else {
			throw new RecordNotFoundException(GeneralUtil.toJson("not updated"));
//			return new ResponseEntity<String>(GeneralUtil.toJson("not updated"),HttpStatus.NOT_FOUND);
		}
		
					
		
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id){
		if(service.deleteUser(id)) 
			return new ResponseEntity<String>(GeneralUtil.toJson("deleted successfully"),HttpStatus.OK);
		return new ResponseEntity<String>(GeneralUtil.toJson("could not delete maybe it is not present"),HttpStatus.OK);
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUser(@PathVariable Integer id){
		return new ResponseEntity<User>(service.getUserById(id),HttpStatus.OK);
	}

	@GetMapping("/getUserByEmail/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email){
		return new ResponseEntity<User>(service.getUserByEmail(email),HttpStatus.OK);
	}
	
	@GetMapping("/get_all_users_by_role/{role}")
	public ResponseEntity<List<User>> getUsersListByRole(@PathVariable String role){
		return new ResponseEntity<List<User>>(service.getUsersByRole(role),HttpStatus.OK);
	}
	
	@GetMapping("/getcount")
	public ResponseEntity<String> getUsersCount(){
		return new ResponseEntity<>(GeneralUtil.toJson(service.getCountOfUser().toString()),HttpStatus.OK);
	}

}
