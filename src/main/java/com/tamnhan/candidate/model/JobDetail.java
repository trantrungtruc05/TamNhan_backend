package com.tamnhan.candidate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_detail")
public class JobDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "job_responsibilites", nullable = false)
	private String jobResponsibilites;
	
	@Column(name = "skill", nullable = false)
	private String skill;
	
	@Column(name = "qualification", nullable = false)
	private String qualification;
	
	public JobDetail() {}

	public JobDetail(Long id, String jobResponsibilites, String skill, String qualification) {
		super();
		this.id = id;
		this.jobResponsibilites = jobResponsibilites;
		this.skill = skill;
		this.qualification = qualification;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJobResponsibilites() {
		return jobResponsibilites;
	}

	public void setJobResponsibilites(String jobResponsibilites) {
		this.jobResponsibilites = jobResponsibilites;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	

}
