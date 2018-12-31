package com.tamnhan.authorization.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tamnhan.authorization.model.Candidate;

public class RegisterCandidateRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5332539109179710590L;
	
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
	
	public Candidate convertToCandidate(RegisterCandidateRequest registerCandidateRequest) {
		Candidate candidate = new Candidate();
		candidate.setFirstName(registerCandidateRequest.getFirstName());
		candidate.setLastName(registerCandidateRequest.getLastName());
		candidate.setPhoneNumber(registerCandidateRequest.getPhoneNumber());
		candidate.setEmail(registerCandidateRequest.getEmail());
		candidate.setPassword(registerCandidateRequest.getPassword());
		candidate.setAvatarUrl(registerCandidateRequest.getAvatarUrl());
		candidate.setBirthday(registerCandidateRequest.getBirthdate());
		
		return candidate;
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
