package com.pib.property.exception;

import com.pib.property.exception.type.DefaultMessageException;
import com.pib.property.exception.type.LogException;
import com.pib.property.log.LogLevel;

public class FailException extends Exception implements DefaultMessageException, LogException {

	private static final long serialVersionUID = 7023332210045105384L;
	private static final String DEFAULT_MESSAGE = "错误: ";
	private LogLevel logLevel = LogLevel.ERROR;

	public FailException(String message) {
		super(DEFAULT_MESSAGE + message);
	}

	public FailException(Object object) {
		super(DEFAULT_MESSAGE + object!=null ? object.toString() : "null");
	}
	@Override
	public String getDefaultMessage() {
		return DEFAULT_MESSAGE;
	}
	@Override
	public LogLevel getLogLevel() {
		return logLevel;
	}
}
