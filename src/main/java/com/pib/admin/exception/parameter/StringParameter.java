package com.pib.admin.exception.parameter;


import java.util.List;
import java.util.regex.Pattern;
import com.google.common.base.Strings;
import com.pib.admin.exception.ParameterException;
import com.pib.admin.util.DateUtil;


public class StringParameter {
	private String infoOfValue;
	private String value;
	private String showValue;
	public StringParameter(String infoOfValue, String value) {
		this.infoOfValue = infoOfValue;
		this.value = value;
		this.showValue = this.value == null ? "null" 
					: this.value.length() > 50 ? this.value.substring(0, 20) + "..." + this.value.substring(this.value.length()-20, this.value.length()) 
					: this.value;
	}
	/**
	 * 内部已判断非空
	 * @return
	 * @throws ParameterException
	 */
	public StringParameter isUUID() throws ParameterException {
		isNotEmpty();
		if (value.length() < 30 || value.length() > 50) {
			throw new ParameterException(infoOfValue + " 不能为 " + showValue + ", 必须使用自动生成, 或数据存储的uuid");
		}
		return this;
	}
	public StringParameter isDate() throws ParameterException {
		if (!DateUtil.isVaildDate(value)) {
			throw new ParameterException(infoOfValue + " 不能为 " + showValue + ", 有效值 2013-01-01");
		}
		return this;
	}
	public StringParameter isDateTime() throws ParameterException {
		if (!DateUtil.isVaildDateTime(value)) {
			throw new ParameterException(infoOfValue + " 不能为 " + showValue + ", 有效值 2013-01-01");
		}
		return this;
	}
	public StringParameter isNotEmpty() throws ParameterException {
		
		return null;
	}
	/**
	 * 内部已判断非null。0--空字符串
	 * @param length
	 * @return
	 * @throws ParameterException
	 */
	public StringParameter isLength(int length) throws ParameterException {
		if (value == null) {
			throw new ParameterException(infoOfValue + " 不能为 " + showValue + ", 有效值不为null");
		}
		if (value.length() != length) {
			throw new ParameterException(infoOfValue + " 不能为 " + showValue + ", 长度必须为: " + length);
		}
		return this;
	}
	/**
	 * 内部已判断非null。0--空字符串，-1--不做判断
	 * @param min
	 * @param max
	 * @return
	 * @throws ParameterException
	 */
	public StringParameter isLengthIn(int min, int max) throws ParameterException {
		if (value == null) {
			throw new ParameterException(infoOfValue + " 不能为 " + showValue + ", 有效值不为null");
		}
		if ((min != -1 && value.length() < min) || (max != -1 && value.length() > max)) {
			throw new ParameterException(infoOfValue + " 不能为 " + showValue + ", 长度不在要求范围内: " + (min==-1?0:min) + "~" + (max==-1?"":max));
		}
		return this;
	}
	/**
	 * 内部已判断非空
	 * @param array
	 * @return
	 * @throws ParameterException
	 */
	public StringParameter contain(String... array) throws ParameterException {
		isNotEmpty();
		boolean ok = true;
		for (String text : array) {
			if (!this.value.contains(text)) {
				ok = false; 
				break;
			}
		}
		if (!ok) {
			StringBuilder stringBuilder = new StringBuilder();
			for (String text : array) {
				stringBuilder.append(" " + text);
			}
			throw new ParameterException(infoOfValue + " 不能为 " + showValue + ", 内容必须包含: " + stringBuilder.toString());
		}
		return this;
	}

	public StringParameter beContainedIn(List<String> list) throws ParameterException {
		boolean ok = list.stream().anyMatch(e -> e.equals(this.value));
		if (!ok) throw new ParameterException(infoOfValue + " 不能为 " + showValue + ", 内容必须包含在: " + list + " 里面");
		return this;
	}
	/**
	 * 内部已判断非null
	 * @param text
	 * @return
	 * @throws ParameterException
	 */
	public StringParameter isNotEqual(String text) throws ParameterException {
		if (value == null) {
			throw new ParameterException(infoOfValue + " 不能为 " + showValue + ", 有效值不为null");
		}
		if (value.equals(text)) {
			throw new ParameterException(infoOfValue + " 不能为 " + showValue);
		}
		return this;
	}

	/**
	 * 内部已判断非null
	 * 判断是否符合对应的正则表达式
	 */
	public StringParameter isRegex(String regex) throws ParameterException {
		if (value == null) {
			throw new ParameterException(infoOfValue + " 不能为 " + showValue + ", 有效值不为null");
		}
		if (!Pattern.matches(regex, value)) {
			throw new ParameterException(infoOfValue + " 不能为 " + showValue + ", 内容不合法");
		}
		return this;
	}
}
