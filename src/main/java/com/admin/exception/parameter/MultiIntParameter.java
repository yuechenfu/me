package com.admin.exception.parameter;

import java.util.Arrays;
import java.util.HashSet;

import com.admin.exception.ParameterException;


public class MultiIntParameter {
	private String infoOfValue;
	private int[] valueArray;
	public MultiIntParameter(String infoOfValue, int... valueArray) {
		this.infoOfValue = infoOfValue;
		this.valueArray = valueArray;
	}
	
	public MultiIntParameter isDifferent() throws ParameterException {
		HashSet<Integer> hashSet = new HashSet<>();
		for (int e : valueArray) {
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
		private int[] valueArray;
		public AtLeastOne(MultiIntParameter multi) {
			this.infoOfValue = multi.infoOfValue;
			this.valueArray = multi.valueArray;
		}
		public AtLeastOne isPositive() throws ParameterException {
			boolean ok = false;
			for (int e : valueArray) {
				if (e > 0) {
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
