package com.pib.property.model.rest;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.reflect.TypeToken;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.pib.nullhandler.NotNullObject;
import com.pib.nullhandler.NullObject;


public class Rest<T> implements Serializable, NotNullObject {
	private static final long serialVersionUID = 7731002699358014851L;
	private String message;
	private RestCode code;
	@JsonInclude(Include.NON_ABSENT)
	private T data;
	
	public static <T> Rest<T> createSuccess(T data) {
		Rest<T> result = new Rest<>();
		result.transformSuccess();
		result.setData(data);
		return result;
	}
	public static <T> Rest<T> createFail() {
		Rest<T> result = new Rest<>();
		result.setCode(BasicRestCode.FAIL);
		result.setMessage(BasicRestCode.FAIL.getMessage()); 
		return result;
	}
	public static <T> Rest<T> createFail(RestCode code) {
		Rest<T> result = new Rest<>();
		result.setCode(code);
		result.setMessage(code.getMessage()); 
		return result;
	}
	
	public static <T> Rest<T> fromJson(String json) {
		return fromJson(json, BasicRestCode.class);
	}
	public static <T> Rest<T> fromJson(String json, Type codeType) {
		return fromJson(json, codeType, new TypeToken<Rest>() {}.getType());
	}
	
	public static <T> Rest<T> fromJson(String json, Type codeType, Type restTypeFromTypeToken) {
		if (json==null || json.indexOf("{")!=0 || json.lastIndexOf("}")!=json.length()-1) {
			json = null;
		}
		Rest<T> result = new GsonBuilder().registerTypeAdapter(RestCode.class, new JsonDeserializer<RestCode>() {
					@Override
		            public RestCode deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
						return jsonDeserializationContext.deserialize(jsonElement, codeType);
		            }
				}).registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
					@Override
					public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
						return LocalDateTime.parse(json.getAsString());
					}
				}).registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
					@Override
					public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
						return LocalDate.parse(json.getAsString());
					}
		}).create().fromJson(json, restTypeFromTypeToken);
		if (result == null) {
			result = NULL;
		}
		return result;
	}
	
	public void transformSuccess() {
		this.code = BasicRestCode.SUCCESS;
		this.message = BasicRestCode.SUCCESS.getMessage();
	}
	public void transformSuccess(T data) {
		transformSuccess();
		this.data = data;
	}
	public void transformFail() {
		this.code = BasicRestCode.FAIL;
		this.message = BasicRestCode.FAIL.getMessage();
	}
	public void transformFail(RestCode code) {
		this.code = code;
		this.message = code.getMessage();
	}
	public void transformFail(String message) {
		this.code = BasicRestCode.FAIL;
		this.message = message;
	}
	
	public static final Null NULL = new Null();
	private static class Null extends Rest implements NullObject {
		@Override
		public String getMessage() { return null; }
		@Override
		public RestCode getCode() { return null; }
	}
	
	public RestCode getCode() {
		return code;
	}
	public void setCode(RestCode code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Rest [" + (message != null ? "message=" + message + ", " : "") + (code != null ? "code=" + code + ", " : "") + (data != null ? "data=" + data : "") + "]";
	}
}
