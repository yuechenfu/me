package com.pib.admin.exception;

import com.pib.admin.exception.type.DefaultMessageException;
import com.pib.admin.exception.type.LogException;
import com.pib.admin.exception.type.RestCodeException;
import com.pib.admin.log.LogLevel;
import com.pib.admin.model.rest.RestCode;

public class ServiceException extends Exception implements DefaultMessageException, LogException, RestCodeException {

	private static final long serialVersionUID = 7023332210045105384L;
	private static final String DEFAULT_MESSAGE = "业务异常:";
	private LogLevel logLevel = LogLevel.INFO;
	private RestCode code;

	/**
	 * 默认日志等级info
	 * @param message 默认日志等级info
	 */
	public ServiceException(String message) {
		super(DEFAULT_MESSAGE + message);
	}
	public ServiceException(String message, LogLevel logLevel) {
		super(DEFAULT_MESSAGE + message);
		this.logLevel = logLevel;
	}
	public ServiceException(String message, LogLevel logLevel, RestCode code) {
		super(DEFAULT_MESSAGE + message);
		this.logLevel = logLevel;
		this.code = code;
	}
	public ServiceException(String message, RestCode code) {
		super(DEFAULT_MESSAGE + message);
		this.code = code;
	}

	@Override
	public String getDefaultMessage() {
		return DEFAULT_MESSAGE;
	}

	@Override
	public LogLevel getLogLevel() {
		return logLevel;
	}
	@Override
	public <T extends RestCode> T getCode() {
		return (T) code;
	}
}
