package com.pib.admin.exception.parameter;

import com.pib.admin.exception.ParameterException;

public class IntParameter {
	private String infoOfValue;
	private int value;
	public IntParameter(String infoOfValue, int value) { this.infoOfValue = infoOfValue; this.value = value; }
	public IntParameter isPositive() throws ParameterException {
		if (value <= 0) {
			throw new ParameterException(infoOfValue + " 不能为 " + value + ", 有效值 > 0");
		}
		return this;
	}
	public IntParameter isNaturalNumber() throws ParameterException {
		if (value < 0) {
			throw new ParameterException(infoOfValue + " 不能为 " + value + ", 有效值 >= 0");
		}
		return this;
	}
	public IntParameter isIn(int min, int max) throws ParameterException {
		if (value < min || value > max) {
			throw new ParameterException(infoOfValue + " 不能为 " + value + ", 有效值： " + min + " <= 值 <= " + max);
		}
		return this;
	}
	
}
