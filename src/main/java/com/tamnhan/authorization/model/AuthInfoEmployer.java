package com.tamnhan.authorization.model;

public class AuthInfoEmployer {
	
	private String token;
	
	private Employer employer;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public Employer getEmployer() {
		return employer;
	}
	
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

}
