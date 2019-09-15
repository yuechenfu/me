package com.pib.admin.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectorUtil {
	public static String getFirstCaller() {
		return Arrays.stream(new Throwable().getStackTrace())
						.filter(e -> e.getClassName().startsWith("com.hiveel.") && !e.getClassName().startsWith("com.hiveel.core."))
						.findFirst().map(StackTraceElement::toString).get();
		
	}
	
	public static List<String> getCallerList() {
		return getCallerList(new Throwable());
	}
	
	public static List<String> getCallerList(Throwable throwable) {
		return Arrays.stream(throwable.getStackTrace())
						.filter(e -> e.getClassName().startsWith("com.hiveel.") && !e.getClassName().startsWith("com.hiveel.core."))
						.map(e -> e.getClassName() + "." + e.getMethodName() + ": " + e.getLineNumber()).collect(Collectors.toList());
	}
}
