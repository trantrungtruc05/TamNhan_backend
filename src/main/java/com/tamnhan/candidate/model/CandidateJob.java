package com.tamnhan.candidate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tamnhan.authorization.model.Candidate;

@Entity
@Table(name="candidate_job")
public class CandidateJob {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Candidate candidate;
	
	@ManyToOne
	private Job job;
	
	private Date dateApply;
	
	public CandidateJob() {}
	
	public CandidateJob(Candidate candidate, Job job, Date dateApply) {
		super();
		this.candidate = candidate;
		this.job = job;
		this.dateApply = dateApply;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateApply() {
		return dateApply;
	}

	public void setDateApply(Date dateApply) {
		this.dateApply = dateApply;
	}
	
	
	
	
	

}
