package com.admin.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
* MD5加密函式類
* @author weiceng1sheng
*/
public class DigestUtil {
	
    /**
     * MD5變形函式
     * @param text 原字符
	 * @return 返回md5(md5(字符).在最後一位前插入0)
     */  
	public static String md5(String text) {
		return md5(text, 0);
	}
	
    /**
     * MD5變形函式
     * @param text 原字符
     * @param round round參數,0=MD5變形函式^2 ; &gt;0=MD5變形函式
	 * @return 返回MD5變形Hex
     */  
	public static String md5(String text, int round) {
		StringBuffer stringBuffer = new StringBuffer(DigestUtils.md5Hex(text));
		boolean done = false;
		for (int i=0; i<9; i++) {
			int index = stringBuffer.indexOf(i+"");
			if (index!=-1) {
				stringBuffer.insert(stringBuffer.length()-1-index, i);
				done = true;
				break;
			}
		}
		if (!done && round<5) {
			return md5(text, round+1);
		}
		if (done && round==0) {
			return DigestUtils.md5Hex(stringBuffer.toString());
		}
		return stringBuffer.toString();
	}
	public static void main(String args[]) {
		String p =DigestUtil.md5("1");
		System.out.print(p);
	}
}
