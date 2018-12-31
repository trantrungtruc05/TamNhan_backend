package com.tamnhan.candidate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tamnhan.employer.model.Company;
import com.tamnhan.employer.model.CompanyIndustry;

@Entity
@Table(name="job")
public class Job {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private JobDetail jobDetail;
	
	@OneToOne
	private CompanyIndustry companyIndustry;
	
	@OneToOne
	private Company company;
	
	@Column(name = "work_location", length = 100, nullable = true)
	private String workLocation;
	
	@Column(name = "job_name", length = 1000, nullable = true)
	private String jobName;
	
	@Column(name = "salary", length = 100, nullable = true)
	private String salary;
	
	@Column(name = "created_at", nullable = true)
	private Date createdAt;
	
	@Column(name = "tags", length = 1000, nullable = true)
	private String tags;

	public Job() {}
	
	public Job(Long id, JobDetail jobDetail, CompanyIndustry companyIndustry, Company company, String workLocation, String jobName,
			String salary, Date createdAt, String tags) {
		super();
		this.id = id;
		this.jobDetail = jobDetail;
		this.companyIndustry = companyIndustry;
		this.company = company;
		this.workLocation = workLocation;
		this.jobName = jobName;
		this.salary = salary;
		this.createdAt = createdAt;
		this.tags = tags;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JobDetail getJobDetail() {
		return jobDetail;
	}

	public void setJobDetail(JobDetail jobDetail) {
		this.jobDetail = jobDetail;
	}

	public CompanyIndustry getCompanyIndustry() {
		return companyIndustry;
	}

	public void setCompanyIndustry(CompanyIndustry companyIndustry) {
		this.companyIndustry = companyIndustry;
	}
	
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
}
