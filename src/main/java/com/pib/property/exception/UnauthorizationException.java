package com.pib.property.exception;

import com.pib.property.exception.type.DefaultMessageException;
import com.pib.property.exception.type.LogException;
import com.pib.property.log.LogLevel;

public class UnauthorizationException extends Exception implements DefaultMessageException, LogException {

	private static final long serialVersionUID = 7023332210045105384L;
	private static final String DEFAULT_MESSAGE = "权限异常:";
	private LogLevel logLevel = LogLevel.WARN;

	/**
	 * @param message 默认日志等级warn
	 */
	public UnauthorizationException(String message) {
		super(DEFAULT_MESSAGE + message);
	}
	public UnauthorizationException(String message, LogLevel logLevel) {
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
