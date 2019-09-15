package com.pib.admin.exception.parameter;

import com.pib.admin.exception.ParameterException;

public class IntegerParameter {
	private String infoOfValue;
	private Integer value;
	public IntegerParameter(String infoOfValue, Integer value) { this.infoOfValue = infoOfValue; this.value = value; }
	public IntegerParameter isPositive() throws ParameterException {
		isNotNull();
		if (value <= 0) {
			throw new ParameterException(infoOfValue + " 不能为 " + value + ", 有效值 > 0");
		}
		return this;
	}
	public IntegerParameter isNaturalNumber() throws ParameterException {
		isNotNull();
		if (value < 0) {
			throw new ParameterException(infoOfValue + " 不能为 " + value + ", 有效值 >= 0");
		}
		return this;
	}
	public IntegerParameter isIn(int min, int max) throws ParameterException {
		isNotNull();
		if (value < min || value > max) {
			throw new ParameterException(infoOfValue + " 不能为 " + value + ", 有效值： " + min + " <= 值 <= " + max);
		}
		return this;
	}
	public IntegerParameter isNotNull() throws ParameterException {
		if (value == null) {
			throw new ParameterException(infoOfValue + " 不能为空(null)");
		}
		return this;
	}
}
