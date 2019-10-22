package com.admin.nullhandler;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 所有实体内的实现此接口
 * 如需要返回 null 时返回该对应的实例，之后判断通过isNull来判断为空 
 * 实体类内部如果有属性为对象，需要自行重载get方法.
 * 需要与NullObject配合使用
 * 例子:
 * public class Member implements NotNullObject {
 * 	private Room room;
 * 	public static class Null implements NullObject {}
 * }
 * if (member.getRoom().getCar().isNull()) { ... }
 * if (member.getRoom().getName==null) { ... }
 * 
 * @author Chengwei
 */
public interface NotNullObject {
	@JsonIgnore
	default boolean isNull() {
		return false;
	}
}
