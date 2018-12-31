package com.tamnhan.candidate.request;

import java.util.Date;

public class ApplyCvRequest {

	private long jobId;
	private Date applyDate;

	public ApplyCvRequest() {
	}

	public ApplyCvRequest(long jobId, Date applyDate) {
		super();
		this.jobId = jobId;
		this.applyDate = applyDate;
	}

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

}
