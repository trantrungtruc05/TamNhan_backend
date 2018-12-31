package com.tamnhan.job.request;

public class SearchRequest {
	
	private String keyword;
	private long companyIndustryId;
	private String workLocation;
	
	public SearchRequest() {};
	
	public SearchRequest(String keyword, long companyIndustryId, String workLocation) {
		super();
		this.keyword = keyword;
		this.companyIndustryId = companyIndustryId;
		this.workLocation = workLocation;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public long getCompanyIndustryId() {
		return companyIndustryId;
	}
	public void setCompanyIndustryId(long companyIndustryId) {
		this.companyIndustryId = companyIndustryId;
	}
	public String getWorkLocation() {
		return workLocation;
	}
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	
	

}
