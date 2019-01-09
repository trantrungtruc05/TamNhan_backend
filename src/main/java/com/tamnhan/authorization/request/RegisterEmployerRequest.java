package com.tamnhan.authorization.request;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tamnhan.authorization.model.Employer;

public class RegisterEmployerRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6876611874248909722L;

	@Valid
	@NotNull
	@Size(min = 1, max = 500)
	private String email;

	@Valid
	@NotNull
	@Size(min = 1, max = 500)
	private String password;

	@Valid
	@NotNull
	private String companyName;

	@Valid
	@NotNull
	@Size(min = 1, max = 500)
	private String phoneNumber;
	
	@Valid
	@NotNull
	private Long companyIndustryId;
	
	@Valid
	@NotNull
	@Size(min = 1, max = 20)
	private String addressNo;
	
	@Valid
	@NotNull
	@Size(min = 1, max = 200)
	private String addressStreet;
	
	@Valid
	@NotNull
	@Size(min = 1, max = 200)
	private String addressWard;
	
	@Valid
	@NotNull
	@Size(min = 1, max = 200)
	private String addressDistrict;
	
	@Valid
	@NotNull
	@Size(min = 1, max = 200)
	private String addressCity;

	@Valid
	@NotNull
	private Boolean statusRecuriting;
	
	public Employer convertToEmployer(RegisterEmployerRequest registerEmployerRequest) {
		Employer employer = new Employer();
		employer.setEmail(registerEmployerRequest.getEmail());
		employer.setPassword(registerEmployerRequest.getPassword());
		employer.setPhoneNumber(registerEmployerRequest.getPhoneNumber());
		employer.setStatusRecuriting(registerEmployerRequest.getStatusRecuriting());
		
		return employer;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Long getCompanyIndustryId() {
		return companyIndustryId;
	}

	public void setCompanyIndustryId(Long companyIndustryId) {
		this.companyIndustryId = companyIndustryId;
	}

	public String getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(String addressNo) {
		this.addressNo = addressNo;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressWard() {
		return addressWard;
	}
	
	public void setAddressWard(String addressWard) {
		this.addressWard = addressWard;
	}

	public String getAddressDistrict() {
		return addressDistrict;
	}

	public void setAddressDistrict(String addressDistrict) {
		this.addressDistrict = addressDistrict;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public Boolean getStatusRecuriting() {
		return statusRecuriting;
	}

	public void setStatusRecuriting(Boolean statusRecuriting) {
		this.statusRecuriting = statusRecuriting;
	}
	
	

}
