package com.admin.exception.util;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.admin.exception.parameter.*;

public class ParameterExceptionUtil {
	
	public static IntParameter verify(String infoOfValue, int value) {
		return new IntParameter(infoOfValue, value);
	}
	public static MultiIntParameter verify(String infoOfValue, int... valueArray) {
		return new MultiIntParameter(infoOfValue, valueArray);
	}
	public static LongParameter verify(String infoOfValue, Long value) {
		return new LongParameter(infoOfValue, value);
	}
	public static MultiLongParameter verify(String infoOfValue, Long... valueArray) {
		return new MultiLongParameter(infoOfValue, valueArray);
	}
	public static IntegerParameter verify(String infoOfValue, Integer value) {
		return new IntegerParameter(infoOfValue, value);
	}
	public static DoubleParameter verify(String infoOfValue, Double value) {
		return new DoubleParameter(infoOfValue, value);
	}
	
	public static MultiIntegerParameter verify(String infoOfValue, Integer... valueArray) {
		return new MultiIntegerParameter(infoOfValue, valueArray);
	}
	public static StringParameter verify(String infoOfValue, String value) {
		return new StringParameter(infoOfValue, value);
	}
	
	public static MultiStringParameter verify(String infoOfValue, String... valueArray) {
		return new MultiStringParameter(infoOfValue, valueArray);
	}
	
	public static FileParameter verify(String infoOfValue, File value) {
		return new FileParameter(infoOfValue, value);
	}
	
	public static MultipartFileParameter verify(String infoOfValue, MultipartFile value) {
		return new MultipartFileParameter(infoOfValue, value);
	}
	
	public static ObjectParameter verify(String infoOfValue, Object value) {
		return new ObjectParameter(infoOfValue, value);
	}
	public static MultiObjectParameter verify(String infoOfValue, Object... valueArray) {
		return new MultiObjectParameter(infoOfValue, valueArray);
	}
}
