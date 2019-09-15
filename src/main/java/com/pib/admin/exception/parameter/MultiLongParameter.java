package com.pib.admin.exception.parameter;


import java.util.Arrays;
import java.util.HashSet;

import com.pib.admin.exception.ParameterException;

public class MultiLongParameter {
	private String infoOfValue;
	private Long[] valueArray;
	public MultiLongParameter(String infoOfValue, Long... valueArray) {
		this.infoOfValue = infoOfValue;
		this.valueArray = valueArray;
	}
	
	public MultiLongParameter isDifferent() throws ParameterException {
		HashSet<Long> hashSet = new HashSet<>();
		for (Long e : valueArray) {
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
		private Long[] valueArray;
		public AtLeastOne(MultiLongParameter multi) {
			this.infoOfValue = multi.infoOfValue;
			this.valueArray = multi.valueArray;
		}
		public AtLeastOne isPositive() throws ParameterException {
			boolean ok = false;
			for (Long e : valueArray) {
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
