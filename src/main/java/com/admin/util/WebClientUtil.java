package com.admin.util;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;



public class WebClientUtil {
	private static final List<String> AGENT_LIST = Arrays.asList("Chrome", "navigator", "Firefox", "version", "opera", "MSIE", "rv:11");
	private static final List<String> BOWSER_LIST = Arrays.asList("Chrome", "navigator", "Firefox", "safari", "opera", "IE", "IE11");
	private static final List<String> MOBILE_USER_AGENT_LIST = Arrays.asList("Android", "iPhone", "iPod","iPad", "Windows Phone");
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (notExistIp(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		} else {
			ip = ip.split(",")[0];
		}
		if (notExistIp(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (notExistIp(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	private static boolean notExistIp(String ip) {
		return ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip);
	}
	public static String getBowser(HttpServletRequest request) {
		String result = null;
		String userAgent = request.getHeader("User-Agent");
		for (int i = 0, length = AGENT_LIST.size(); i<length; i++) {
			if (userAgent.contains(AGENT_LIST.get(i))) {
				result = BOWSER_LIST.get(i);
				break;
			}
		}
		for (String mobile : MOBILE_USER_AGENT_LIST) {
			if (userAgent.contains(mobile)) {
				result = mobile + "---" + result;
			}
		}
		if (result == null) {
			result = "unknown: " + userAgent;
		}
		return result;
	}
}
