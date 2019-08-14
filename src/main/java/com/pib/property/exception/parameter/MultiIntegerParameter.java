package com.pib.property.exception.parameter;

import java.util.Arrays;
import java.util.HashSet;

import com.pib.property.exception.ParameterException;


public class MultiIntegerParameter {
	private String infoOfValue;
	private Integer[] valueArray;
	public MultiIntegerParameter(String infoOfValue, Integer... valueArray) {
		this.infoOfValue = infoOfValue;
		this.valueArray = valueArray;
	}
	
	public MultiIntegerParameter isDifferent() throws ParameterException {
		HashSet<Integer> hashSet = new HashSet<>();
		for (Integer e : valueArray) {
			if (!hashSet.add(e)) {
				throw new ParameterException(infoOfValue + " 不能为 " + Arrays.toString(valueArray) + ", 有效值应全不同");
			}
		}
		return this;
	}
	
	public AtLeastOne atLeastOne() {
		return new AtLeastOne(this);
	}
	
	public static class AtLeastOne {
		private String infoOfValue;
		private Integer[] valueArray;
		public AtLeastOne(MultiIntegerParameter multi) {
			this.infoOfValue = multi.infoOfValue;
			this.valueArray = multi.valueArray;
		}
		public AtLeastOne isPositive() throws ParameterException {
			boolean ok = false;
			for (Integer e : valueArray) {
				if (e != null && e > 0) {
					ok = true;
					break;
				}
			}
			if (!ok) {
				throw new ParameterException(infoOfValue + " 不能为 " + Arrays.toString(valueArray) + ", 有效值 > 0.(其一)");
			}
			return this;
		}
	}
	
}
