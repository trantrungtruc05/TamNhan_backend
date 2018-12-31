package com.tamnhan.core.exception.error;

public class BaseException{
	
	private ObjectError error;

    public BaseException(int errorCode, String errorMessage) {
    	error = new ObjectError(errorCode, errorMessage);
    }

	public ObjectError getError() {
		return error;
	}

	public void setError(ObjectError error) {
		this.error = error;
	}
	
}
