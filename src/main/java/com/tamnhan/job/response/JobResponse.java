package com.tamnhan.job.response;

import java.util.List;

import com.tamnhan.candidate.model.Job;

public class JobResponse {
	
	private List<Job> jobs;
	private int totalPage;
	
	public List<Job> getJobs() {
		return jobs;
	}
	
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
