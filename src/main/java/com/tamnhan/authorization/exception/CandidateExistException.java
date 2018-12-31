package com.tamnhan.authorization.exception;

import com.tamnhan.core.exception.error.BaseException;

public class CandidateExistException extends BaseException {

	public CandidateExistException() {
		super(101, "User exist");
	}

}
