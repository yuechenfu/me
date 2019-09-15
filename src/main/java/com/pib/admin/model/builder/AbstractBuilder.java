package com.pib.admin.model.builder;

import java.util.HashMap;
import java.util.Map;

import com.pib.admin.exception.ServiceException;
import com.pib.admin.log.LogUtil;
import com.pib.admin.nullhandler.NullObject;



/**
 * 创建builder的set方法
 * e.g.
 * public static class Builder extends AbstractBuilder {
 *		public Make build() {
 *			try {
 *				return super.build(Make.class);
 *			} catch (InstantiationException | IllegalAccessException e) {
 *				return new Make.Null();
 *			}
 *		}
 *	}
 * 使用时： new Make.Builder().set("name", "aaa").set("age", 1).build();
 * 
 *
 * @author Chengwei
 */
public abstract class AbstractBuilder {
	private Map<String, Object> map = new HashMap<>();
	public <T extends AbstractBuilder> T set(String key, Object value) {
		map.put(key, value);
		return (T) this;
	} 
	
	protected <T> T build(Class<T> c) throws InstantiationException, IllegalAccessException {
		T t = c.newInstance();
		map.forEach((k, v) -> {
			if (v == null) {
				return ;
			}
			String upperProperty = k.substring(0, 1).toUpperCase() + k.substring(1);
			try {
				Class<?> setToClass = !NullObject.class.isAssignableFrom(v.getClass()) ? v.getClass() : (Class<?>) v.getClass().getGenericSuperclass();
				t.getClass().getMethod("set" + upperProperty, setToClass).invoke(t, v);
			} catch (Exception e) {
				try {
					t.getClass().getMethod("set" + upperProperty, getUnboxType(v)).invoke(t, v);
				} catch (Exception e1) {
					LogUtil.error("AbstractBuilder.build() 出错，位于: " + t.getClass() + "." + "set" + upperProperty + "(" + v + "," + v.getClass() + ")");
				}
			}
		});
		return t;
	}
	
	private Class<?> getUnboxType(Object v) throws ServiceException {
		Class result = null;
		if (v instanceof java.lang.Integer) {
			result = int.class;
		} else if (v instanceof java.lang.Boolean) {
			result = boolean.class;
		} else if (v instanceof java.lang.Double) {
			result = double.class;
		} else if (v instanceof java.lang.Long) {
			result = long.class;
		} else {
			throw new ServiceException("非可拆装箱类型");
		}
		return result;
	}

	public abstract <T extends Object> T build();
}