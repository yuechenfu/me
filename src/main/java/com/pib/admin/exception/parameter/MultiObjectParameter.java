package com.pib.admin.exception.parameter;

import java.util.Arrays;

import com.pib.admin.exception.ParameterException;


public class MultiObjectParameter {
	private String infoOfValue;
	private Object[] valueArray;
	private String showValue;
	public MultiObjectParameter(String infoOfValue, Object... valueArray) {
		this.infoOfValue = infoOfValue;
		this.valueArray = valueArray;
		String allValue = this.valueArray == null ? "null" : Arrays.asList(this.valueArray).toString();
		this.showValue = allValue.length() > 50 ? allValue.substring(0, 20) + "..." + allValue.substring(allValue.length()-20, allValue.length()) : allValue;
	}
	
	public AtLeastOne atLeastOne() {
		return new AtLeastOne(this);
	}
	
	public static class AtLeastOne {
		private String infoOfValue;
		private Object[] valueArray;
		private String showValue;
		public AtLeastOne(MultiObjectParameter multi) {
			this.infoOfValue = multi.infoOfValue;
			this.valueArray = multi.valueArray;
			this.showValue = multi.showValue;
		}
		public AtLeastOne isNotEmpty() throws ParameterException {
			boolean ok = false;
			for (Object e : valueArray) {
				if (e != null) {
					ok = true;
					break;
				}
			}
			if (!ok) {
				throw new ParameterException(infoOfValue + " 不能为 " + showValue + ", 有效值不为空.(其一)");
			}
			return this;
		}
	}
}
