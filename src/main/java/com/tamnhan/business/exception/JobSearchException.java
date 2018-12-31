package com.tamnhan.business.exception;

import com.tamnhan.core.exception.error.BaseException;

public class JobSearchException extends BaseException {
	
	public JobSearchException() {
		super(200, "No Job");
	}

}
