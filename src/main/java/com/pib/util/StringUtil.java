package com.pib.util;

import java.util.Random;

public class StringUtil {
	
	/**
	 * 替换为全模糊: content ---&gt; %content%
	 * @param content
	 * @return
	 */
	public static String transformToFullFuzzyKey(String content) {
		return '%' + transformToRightFuzzyKey(content);
	}
	
	/**
	 * 替换为右模糊: content ---&gt; content%
	 * @param content
	 * @return
	 */
	public static String transformToRightFuzzyKey(String content) {
		int length = content == null ? 0 : content.length();
		StringBuilder stringBuilder = new StringBuilder();
		if (length > 0) {
			content.chars().mapToObj(e -> (char)e).forEach(e -> {
				switch ((char)e) {
				case '%':
				case '\\':
				case '*':
					stringBuilder.append('\\');
					break;
				case '<':
					stringBuilder.append("&lt;");
					break;
				case '>':
					stringBuilder.append("&gt;");
					break;
				case '&':
					stringBuilder.append("&amp");
					break;
				default:
					stringBuilder.append((char)e);
					break;
				}
			});
			stringBuilder.append('%');
		}
		return stringBuilder.toString();
	}
	
	
	
	public static String generateRandomString(int length) {
		StringBuilder stringBuilder = new StringBuilder();
		Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < length; i++) {
			int randomNumber = random.nextInt(26);
			if (random.nextBoolean()) {
				randomNumber += 32;
			}
			stringBuilder.append((char) ('A' + randomNumber));
		}
		return stringBuilder.toString();
	}
	
	public static String generateRandomInteger(int length) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < length; i++) {
			result.append((int)(1+Math.random()*9));
		}
		return result.toString();
	}
	
	/**
	 * 把不合法的文件名: \, :, *, ? ", &lt;, &gt;, |
	 * 替换为: 1
	 * @param String	the string to be check if it's a correct filename.
	 * @return String
	 */
	public static String correctFileName(String value) {
		String pattern = "[^\\w,\\s-,.]";
		return value.replaceAll(pattern, "1");
	}
	
	/**
	 * 使用6个*来覆盖原有的中间部分的字符
	 * e.g. abcdefg1234567 --&gt; abc******4567
	 * @param value
	 * @return
	 */
	public static String coverMiddle(String value) {
		int length = value.length();
		int cover = length / 2 + length % 2;
		int start = length / 4;
		return value.substring(0, start) + "******" + value.substring(start + cover, value.length());
	}
	/**
	 * 判断字符串是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}