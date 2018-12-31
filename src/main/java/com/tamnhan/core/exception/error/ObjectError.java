package com.tamnhan.core.exception.error;

import java.io.Serializable;

public class ObjectError implements Serializable {
    private static final long serialVersionUID = 3821292847014361548L;

    private int errorCode;
    private String errorMessage;

    public ObjectError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
    
    
}
