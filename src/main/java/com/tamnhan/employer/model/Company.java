package com.tamnhan.employer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "company_name", length = 100, nullable = false)
	private String companyName;

	@OneToOne
	private CompanyIndustry companyIndustry;

	@Column(name = "website", length = 500, nullable = true)
	private String website;

	@Column(name = "address_no", length = 100, nullable = false)
	private String addressNo;

	@Column(name = "address_street", length = 200, nullable = false)
	private String addressStreet;

	@Column(name = "address_ward", length = 200, nullable = false)
	private String addressWard;

	@Column(name = "address_district", length = 200, nullable = false)
	private String addressDistrict;

	@Column(name = "address_city", length = 200, nullable = false)
	private String addressCity;

	@Column(name = "quantity_employee", nullable = true)
	private int quantityEmployee;

	@Column(name = "facebook_link", length = 200, nullable = true)
	private String facebookLink;

	@Column(name = "google_link", length = 200, nullable = true)
	private String googleLink;

	@Column(name = "linkedin_link", length = 200, nullable = true)
	private String linkedinLink;

	@Column(name = "description", nullable = true)
	private String description;

	public Company() {
	}

	public Company(String companyName, CompanyIndustry companyIndustry, String website, String addressNo,
			String addressStreet, String addressWard, String addressDistrict, String addressCity, int quantityEmployee,
			String facebookLink, String googleLink, String linkedinLink, String description) {
		super();
		this.companyName = companyName;
		this.companyIndustry = companyIndustry;
		this.website = website;
		this.addressNo = addressNo;
		this.addressStreet = addressStreet;
		this.addressWard = addressWard;
		this.addressDistrict = addressDistrict;
		this.addressCity = addressCity;
		this.quantityEmployee = quantityEmployee;
		this.facebookLink = facebookLink;
		this.googleLink = googleLink;
		this.linkedinLink = linkedinLink;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public CompanyIndustry getCompanyIndustry() {
		return companyIndustry;
	}

	public void setCompanyIndustry(CompanyIndustry companyIndustry) {
		this.companyIndustry = companyIndustry;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
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

	public int getQuantityEmployee() {
		return quantityEmployee;
	}

	public void setQuantityEmployee(int quantityEmployee) {
		this.quantityEmployee = quantityEmployee;
	}

	public String getFacebookLink() {
		return facebookLink;
	}

	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}

	public String getGoogleLink() {
		return googleLink;
	}

	public void setGoogleLink(String googleLink) {
		this.googleLink = googleLink;
	}

	public String getLinkedinLink() {
		return linkedinLink;
	}

	public void setLinkedinLink(String linkedinLink) {
		this.linkedinLink = linkedinLink;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
