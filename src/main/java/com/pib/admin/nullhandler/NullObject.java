package com.pib.admin.nullhandler;

/**
 * 所有实体内的实现此接口
 * 如需要返回 null 时返回该对应的实例，之后判断通过isNull来判断为空 
 * 实体类内部如果有属性为对象，需要自行重载get方法.
 * 需要与NullObject配合使用
 * 例子:
 * public static class Null extends Member implements NullObject {
 * 	-tag name:Override
 * 	public void getRoom() { return new Room.Null(); } 
 * }
 * 
 * public void foo() {
 * 	Member member = new Member.Null();
 *  if (member.getRoom().getCar().isNull()) { ... }
 * 	if (member.getRoom().getName==null) { ... }
 * }
 * 
 * @author Chengwei
 */
public interface NullObject extends NotNullObject {
	@Override
	default boolean isNull() {
		return true;
	}
}
