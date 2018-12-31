package com.tamnhan.authorization.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tamnhan.authorization.model.AdminTamNhan;

public class RegisterAdminRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5282447544558025934L;
	
	@Valid
	@Size(min = 1, max = 300)
	private String firstName;
	
	@Valid
	@Size(min = 1, max = 300)
	private String lastName;
	
	@Valid
	@NotNull
	@Size(min = 1, max = 300)
	private String phoneNumber;
	
	@Valid
	@NotNull
	@Size(min = 1, max = 500)
	private String email;
	
	@Valid
	@NotNull
	@Size(min = 1, max = 300)
	private String password;
	
	@Valid
	@Size(min = 1, max = 1000)
	private String avatarUrl;
	
	@Valid
	private Date birthdate;
	
	public AdminTamNhan convertToCandidate(RegisterAdminRequest registerAdminRequest) {
		AdminTamNhan adminTamNhan = new AdminTamNhan();
		adminTamNhan.setFirstName(registerAdminRequest.getFirstName());
		adminTamNhan.setLastName(registerAdminRequest.getLastName());
		adminTamNhan.setPhoneNumber(registerAdminRequest.getPhoneNumber());
		adminTamNhan.setEmail(registerAdminRequest.getEmail());
		adminTamNhan.setPassword(registerAdminRequest.getPassword());
		adminTamNhan.setAvatarUrl(registerAdminRequest.getAvatarUrl());
		adminTamNhan.setBirthday(registerAdminRequest.getBirthdate());
		
		return adminTamNhan;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

}
