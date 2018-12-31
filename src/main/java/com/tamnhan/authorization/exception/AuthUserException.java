package com.tamnhan.authorization.exception;

import com.tamnhan.core.exception.error.BaseException;

public class AuthUserException extends BaseException {
	
	public AuthUserException() {
		super(100, "User not found");
	}
}
