package com.admin.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.util.Strings;

import com.admin.log.LogUtil;
import com.admin.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author Chengwei
 * 
 * 本对象里包含: 
 * 客户端设置筛选起始, 总数: start, startId, startDate, startModifyDate, limit
 *      通用设置: name, minDate, maxDate
 *      排序: sortBy, sortByAZ, defaultSortBy(不应暴露给客户端), defaultSortByAZ(不应暴露给客户端)
 * 服务端模糊查询: like
 * like 的使用:
 * like 第一次调用后会生成，此后值不会再改变，请于第一次调用前把需要的值设置完毕
 * id 结尾，date 结尾的属性不能作为 模糊查询的内容
 * sql语句需要到的模糊查询
 * 		1.使用 #{searchCondition.like.name} 来获取右模糊查询值
 * 		2.使用 #{searchCondition.like.fullFuzzy.name} 来获取全模糊查询(只有name)
 */
public abstract class AbstractSearchCondition {
	private int start;
	private int startId;
	private String startDate;
	private String startCreateDate;
	private String startModifyDate;
	private int limit = 0;
	private String name;
	private String minDate;
	private String maxDate;
	private String sortBy;
	private boolean sortByAZ;
	/**
	 * 用于辅助 sortBy 获取对应的正确值，key：包含关键字；value：对应 sql 语句里面的表名
	 */
	@JsonIgnore
	private Map<String, String> sortMap;
	@JsonIgnore
	private String defaultSortBy;
	@JsonIgnore
	private boolean defaultSortByAZ;
	@JsonIgnore
	private AbstractSearchCondition like;
	@JsonIgnore
	private boolean fullFuzzy;
	/**
	 * 直接获取 where 起始筛选的位置，放置于where条件判断
	 * 使用需 ${sqlTrimLimit}
	 * 必须放在 mybatis 的 trim里面，否则无法转换关键字 AND
	 * @return e.g. AND e.id &gt; 11 AND e.date &gt; 30 LIMIT 542, 10
	 */
	public String getSqlTrimLimit() {
		StringBuilder stringBuilder = new StringBuilder();
		if (startId > 0) {
			stringBuilder.append(" AND e.id >= '" + startId + "'");
		}
		if (startDate != null) {
			stringBuilder.append(" AND e.date >= '" + startDate + "'");
		}
		if (startCreateDate != null) {
			stringBuilder.append(" AND e.createDate >= '" + startCreateDate + "'");
		}
		if (startModifyDate != null) {
			stringBuilder.append(" AND e.modifyDate >= '" + startModifyDate + "'");
		}
		return stringBuilder.toString();
	}
	
	/**
	 * 直接获取 mysql 语句的limit部分，放置于trim之外
	 * 使用需 ${sqlLimit}
	 * @return e.g.  LIMIT 542, 10
	 */
	public String getSqlLimit() {
		StringBuilder stringBuilder = new StringBuilder();
		if (limit > 0) {
			stringBuilder.append(" LIMIT");
			if (start > 0) {
				stringBuilder.append(" " + start + ",");
			}
			stringBuilder.append(" " + limit);
		}
		return stringBuilder.toString();
	}
	
	/**
	 * 获取客户端自定义的 order by 部分, 如需添加默认排序，需预先设置 setDefaultSortBy(), setDefaultSortByAZ() 这两项不应暴露给客户端
	 * 使用需 ${sqlOrder} LIMIT 10
	 * @return e.g. ORDER BY name ASC, date DESC
	 */
	public String getSqlOrder() {
		if (sortBy==null && defaultSortBy==null) {
			return "";
		}
		List<String> sortList = new ArrayList<>();
		if (sortBy != null) {
			// 如果采用 e. + sortBy 的话，无法对子对象的属性进行（e.car.price）
			Entry<String, String> entry = getSortMap().entrySet().stream().filter(e -> sortBy.contains(e.getKey())).findFirst().orElse(null);
			String tempSortBy = entry != null ? entry.getValue() // 找到对应的设置值
						: !sortBy.contains(".") ? "e." + sortBy // sortBy里面没包含 . （不会形成 e.car.price）
						: null; // 如果形成 e.car.price
			if (tempSortBy != null) {
				sortList.add(" " + tempSortBy + (sortByAZ ? " ASC" : " DESC"));
			}
		}
		if (defaultSortBy != null) {
			sortList.add(" e." + defaultSortBy + (defaultSortByAZ ? " ASC" : " DESC"));
		}
		if (sortList.size() == 0) {
			return "";
		}
		return " ORDER BY " + sortList.stream().collect(Collectors.joining(","));
	}
	
	public <T extends AbstractSearchCondition> T getLike() {
		if (like != null) {
			return (T) like;
		}
		String className = this.getClass().getName();
		try {
			T temp = (T) Class.forName(className).newInstance();
			Class<? extends Object> tempClass = temp.getClass();
			Stream.concat(
				Arrays.stream(this.getClass().getDeclaredFields()), Arrays.stream(this.getClass().getSuperclass().getDeclaredFields())
			).parallel().filter(e -> {
				String name = e.getName();
				int length = name.length();
				return e.getGenericType().getTypeName().equals("java.lang.String")
					&& !name.regionMatches(false, length-2, "Id", 0, 2)
					&& !name.regionMatches(true, length-4, "date", 0, 4)
					;
			}).forEach(e -> {
				String upperProperty = e.getName().substring(0, 1).toUpperCase() + e.getName().substring(1);
				try {
					String value = StringUtil.transformToRightFuzzyKey((String) this.getClass().getMethod("get" + upperProperty).invoke(this));
					temp.getClass().getMethod("set" + upperProperty, java.lang.String.class).invoke(temp, value);
				} catch (Exception ex) {
					LogUtil.error("尝试设置 searchcondition.like 失败, 属性："+upperProperty+"。 异常: " + ex.getMessage());
				}
			});
			like = temp;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
			LogUtil.error("获取 searchcondition.like 的类名 失败, 类名："+className+"。 异常: " + ex.getMessage());
		}
		return (T)like;
	}
	
	public AbstractSearchCondition getFullFuzzy() {
		fullFuzzy = true;
		return this;
	}
	public String getName() {
		String result = fullFuzzy ? '%'+name : name;
		fullFuzzy = false;
		return result;
	}
	public void setName(String name) {
		this.name = Strings.isNotEmpty(name) ? name : null;
	}
	public String getMinDate() {
		return minDate;
	}
	public void setMinDate(String minDate) {
		if (maxDate==null || minDate.compareTo(this.maxDate) <= 0) {
			this.minDate = minDate;
		} else {
			this.minDate = this.maxDate;
			this.maxDate = minDate;
		}
	}
	public String getMaxDate() {
		return maxDate;
	}
	public void setMaxDate(String maxDate) {
		if (minDate==null || maxDate.compareTo(this.minDate) >= 0) {
			this.maxDate = maxDate;
		} else {
			this.maxDate = this.minDate;
			this.minDate = maxDate;
		}
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getStartId() {
		return startId;
	}
	public void setStartId(int startId) {
		this.startId = startId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate.replaceAll(" ", "");
	}
	public String getStartCreateDate() {
		return startCreateDate;
	}
	public void setStartCreateDate(String startCreateDate) {
		this.startCreateDate = startCreateDate.replaceAll(" ", "");
	}
	public String getStartModifyDate() {
		return startModifyDate;
	}
	public void setStartModifyDate(String startModifyDate) {
		this.startModifyDate = startModifyDate.replaceAll(" ", "");
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy.replaceAll(" ", "");
	}
	public boolean isSortByAZ() {
		return sortByAZ;
	}
	public void setSortByAZ(boolean sortByAZ) {
		this.sortByAZ = sortByAZ;
	}
	public String getDefaultSortBy() {
		return defaultSortBy;
	}
	public void setDefaultSortBy(String defaultSortBy) {
		this.defaultSortBy = defaultSortBy.replaceAll(" ", "");
	}
	public void setDefaultSortBy(String defaultSortBy, boolean defaultSortByAZ) {
		this.defaultSortBy = defaultSortBy.replaceAll(" ", "");
		this.defaultSortByAZ = defaultSortByAZ;
	}
	public boolean isDefaultSortByAZ() {
		return defaultSortByAZ;
	}
	public void setDefaultSortByAZ(boolean defaultSortByAZ) {
		this.defaultSortByAZ = defaultSortByAZ;
	}
	/**
	 * 设置 用于处理 sortBy 为对象子属性的问题
	 * @return
	 */
	public Map<String, String> getSortMap() {
		if (sortMap == null) {
			sortMap = new HashMap<String, String>();
		}
		return sortMap;
	}
}