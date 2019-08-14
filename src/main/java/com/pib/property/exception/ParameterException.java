package com.pib.property.exception;

import com.pib.property.exception.type.DefaultMessageException;
import com.pib.property.exception.type.LogException;
import com.pib.property.log.LogLevel;

public class ParameterException extends Exception implements DefaultMessageException, LogException {

	private static final long serialVersionUID = 7023332210045105384L;
	private static final String DEFAULT_MESSAGE = "参数错误";
	private static final LogLevel LOG_LEVEL = LogLevel.WARN;

	public ParameterException(String message) {
		super(message);
	}

	@Override
	public String getDefaultMessage() {
		return DEFAULT_MESSAGE;
	}

	@Override
	public LogLevel getLogLevel() {
		return LOG_LEVEL;
	}
}
