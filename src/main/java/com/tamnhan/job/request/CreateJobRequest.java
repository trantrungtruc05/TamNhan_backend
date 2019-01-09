package com.tamnhan.job.request;

public class CreateJobRequest {
	
	private String jobResponsibilities;
	private String qualification;
	private String test;
	
	public CreateJobRequest() {}
	
	public CreateJobRequest(String jobResponsibilities, String qualification, String test) {
		super();
		this.jobResponsibilities = jobResponsibilities;
		this.qualification = qualification;
		this.test = test;
	}
	public String getJobResponsibilities() {
		return jobResponsibilities;
	}
	public void setJobResponsibilities(String jobResponsibilities) {
		this.jobResponsibilities = jobResponsibilities;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	
	

}
