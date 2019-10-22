package com.admin.exception.parameter;

import com.admin.exception.ParameterException;

public class LongParameter {
	private String infoOfValue;
	private Long value;
	public LongParameter(String infoOfValue, Long value) { this.infoOfValue = infoOfValue; this.value = value; }
	public LongParameter isPositive() throws ParameterException {
		isNotNull();
		if (value <= 0) {
			throw new ParameterException(infoOfValue + " 不能为 " + value + ", 有效值 > 0");
		}
		return this;
	}
	public LongParameter isNaturalNumber() throws ParameterException {
		isNotNull();
		if (value < 0) {
			throw new ParameterException(infoOfValue + " 不能为 " + value + ", 有效值 >= 0");
		}
		return this;
	}
	public LongParameter isIn(int min, int max) throws ParameterException {
		isNotNull();
		if (value < min || value > max) {
			throw new ParameterException(infoOfValue + " 不能为 " + value + ", 有效值： " + min + " <= 值 <= " + max);
		}
		return this;
	}
	public LongParameter isNotNull() throws ParameterException {
		if (value == null) {
			throw new ParameterException(infoOfValue + " 不能为空(null)");
		}
		return this;
	}
}
