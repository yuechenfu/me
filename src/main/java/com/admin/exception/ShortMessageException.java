package com.admin.exception;

import com.admin.exception.type.DefaultMessageException;
import com.admin.exception.type.LogException;
import com.admin.log.LogLevel;

public class ShortMessageException extends Exception implements DefaultMessageException, LogException {

	private static final long serialVersionUID = 7023332210045105384L;
	private static final String DEFAULT_MESSAGE = "短信发送异常:";
	private LogLevel logLevel = LogLevel.WARN;

	public ShortMessageException(String message) {
		super(DEFAULT_MESSAGE + message);
	}
	public ShortMessageException(String message, LogLevel logLevel) {
		super(DEFAULT_MESSAGE + message);
		this.logLevel = logLevel;
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
