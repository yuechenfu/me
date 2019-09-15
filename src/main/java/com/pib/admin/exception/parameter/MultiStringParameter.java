package com.pib.admin.exception.parameter;

import java.util.Arrays;
import java.util.HashSet;

import com.pib.admin.exception.ParameterException;



public class MultiStringParameter {
	private String infoOfValue;
	private String[] valueArray;
	private String showValue;
	public MultiStringParameter(String infoOfValue, String... valueArray) {
		this.infoOfValue = infoOfValue;
		this.valueArray = valueArray;
		String allValue = this.valueArray == null ? "null" : Arrays.asList(this.valueArray).toString();
		this.showValue = allValue.length() > 50 ? allValue.substring(0, 20) + "..." + allValue.substring(allValue.length()-20, allValue.length()) : allValue;
	}
	
	public MultiStringParameter isDifferent() throws ParameterException {
		HashSet<String> hashSet = new HashSet<>();
		for (String e : valueArray) {
			if (!hashSet.add(e)) {
				throw new ParameterException(infoOfValue + " 不能为 " + showValue + ", 有效值应全不同");
			}
		}
		return this;
	}
	
	public AtLeastOne atLeastOne() {
		return new AtLeastOne(this);
	}
	
	public static class AtLeastOne {
		private String infoOfValue;
		private String[] valueArray;
		private String showValue;
		public AtLeastOne(MultiStringParameter multi) {
			this.infoOfValue = multi.infoOfValue;
			this.valueArray = multi.valueArray;
			this.showValue = multi.showValue;
		}
		public AtLeastOne isNotEmpty() throws ParameterException {
			boolean ok = false;
		
			if (!ok) {
				throw new ParameterException(infoOfValue + " 不能为 " + showValue + ", 有效值不为空.(其一)");
			}
			return this;
		}
	}
	
}
