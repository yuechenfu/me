package com.pib.property.exception.parameter;

import com.pib.property.exception.ParameterException;

public class ObjectParameter {
	private String infoOfValue;
	private Object value;
	public ObjectParameter(String infoOfValue, Object value) {
		this.infoOfValue = infoOfValue;
		this.value = value;
	}
	public ObjectParameter isNotNull() throws ParameterException {
		if (value == null) {
			throw new ParameterException(infoOfValue + " 不能为空(null)");
		}
		return this;
	}
}
