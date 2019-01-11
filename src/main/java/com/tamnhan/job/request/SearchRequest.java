package com.tamnhan.job.request;

public class SearchRequest {

	private String keyword;
	private long companyIndustryId;
	private String workLocation;
	private int limit;
	private int offset;

	public SearchRequest() {
	};

	public SearchRequest(String keyword, long companyIndustryId, String workLocation, int limit, int offset) {
		super();
		this.keyword = keyword;
		this.companyIndustryId = companyIndustryId;
		this.workLocation = workLocation;
		this.limit = limit;
		this.offset = offset;
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

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

}
