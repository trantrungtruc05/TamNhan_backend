package com.tamnhan.authorization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tamnhan.employer.model.Company;

@Entity
@Table(name="employer")
public class Employer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "email", length = 200, nullable = false)
	private String email;
	
	@Column(name = "password", length = 200, nullable = false)
	private String password;
	
	@OneToOne
	private Company company;
	
	@Column(name = "phone_number", length = 100, nullable = false)
	private String phoneNumber;
	
	@Column(name = "status_recuriting", nullable = false)
	private boolean statusRecuriting;
	
	public Employer() {}

	public Employer(Long id, String email, String password, Company company, String phoneNumber,
			boolean statusRecuriting) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.company = company;
		this.phoneNumber = phoneNumber;
		this.statusRecuriting = statusRecuriting;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isStatusRecuriting() {
		return statusRecuriting;
	}

	public void setStatusRecuriting(boolean statusRecuriting) {
		this.statusRecuriting = statusRecuriting;
	}
	
	

}
