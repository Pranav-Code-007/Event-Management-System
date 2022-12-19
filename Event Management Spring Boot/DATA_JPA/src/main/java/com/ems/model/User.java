package com.ems.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User {
    public User() {
		super();
	}


	public User(int id, @NotBlank(message = "Name is mandatory to fill !!") @Size(min = 2, max = 30) String name,
			@NotBlank(message = "email is mandatory to fill !!") @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}") String email,
			String mobile_number,
			@NotBlank(message = "password is mandatory to fill !!") @Size(min = 8) String password, int status,
			int loginAttempts, int otp, List<Event> events, List<Booking> bookings, String role) {
		super();
		this.userId = id;
		this.name = name;
		this.email = email;
		this.mobile_number = mobile_number;
		this.password = password;
		this.status = status;
		this.loginAttempts = loginAttempts;
		this.otp = otp;
		this.events = events;
		this.bookings = bookings;
		this.role = role;
	}


	@GeneratedValue
	@Id
	private int userId;

    @NotBlank(message = "Name is mandatory to fill !!")
    @Size(min=2,max=30)
    @Column(name="user_name")
    private String name;
    
    @NotBlank(message = "email is mandatory to fill !!")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    @Column(name="user_email")
    private String email;
    
    @Column(name="mobile_number")
    private String mobile_number;
    
    @NotBlank(message = "password is mandatory to fill !!")
    @Size(min=8)
    @Column(name="password")
    private String password;
    
    /**
     * if status=0 then account is deactivated
     * */   
    @Column(name="status",columnDefinition = "integer default 0")
    private int status;
    
    
    @Column(name="login_attempts", columnDefinition = "integer default 0")
    private int loginAttempts;
	
    @Column(name="otp")
    private int otp;
    
    @JsonIgnore
    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
    private List<Event> events;
    
    @JsonIgnore
    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
    private List<Booking> bookings;
    
    @Column(name="role")
    private String role;
	

	/**
	 * one to many -> booking
	 * one to many -> event
	 * */
	
	


	/**
	 * @return the name
	 */
	public String getName() {
		
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the events
	 */
	public List<Event> getEvents() {
		return events;
	}


	/**
	 * @param events the events to set
	 */
	public void setEvents(List<Event> events) {
		this.events = events;
	}


	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}


	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the mobile_number
	 */
	public String getMobile_number() {
		return mobile_number;
	}


	/**
	 * @param mobile_number the mobile_number to set
	 */
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}


	/**
	 * @return the bookings
	 */
	public List<Booking> getBookings() {
		return bookings;
	}


	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}


	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 * if status=1 the account is activated
	 */
	public void setStatus(int status) {
		this.status = status;
	}


	/**
	 * @return the loginAttempts
	 */
	public int getLoginAttempts() {
		return loginAttempts;
	}


	/**
	 * @param loginAttempts the loginAttempts to set
	 */
	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + userId + ", name=" + name + ", email=" + email + ", mobile_number=" + mobile_number
				+ ", password=" + password + ", status=" + status + ", loginAttempts=" + loginAttempts + ", events="
				+ events + ", bookings=" + bookings + ", role=" + role + "]";
	}


	/**
	 * @return the otp
	 */
	public int getOtp() {
		return otp;
	}


	/**
	 * @param otp the otp to set
	 */
	public void setOtp(int otp) {
		this.otp = otp;
	}


	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
