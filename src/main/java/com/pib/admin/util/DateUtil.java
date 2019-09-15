package com.pib.admin.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
* 時間函式類
* @author weiceng1sheng
*/
public class DateUtil {

	private static final String DEFAULT_DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";
	private static final String YYYYMMDD_FORMAT = "yyyyMMdd";
	private static final String YYMMDD_FORMAT = "yyMMdd";
	private static final String YYMM_FORMAT = "yyMM";
	private static final String MONTH_FORMAT_PATTERN = "yyyy-MM";
	private static final String PROJECT_START_DATE = "2016-05-19 00:00:00";
	private static final String END_DATE_OF_THE_WORLD = "9999-01-01 00:00:00";
	
    /**
     * 返回Server的當地日期字串
	 * @return 返回Server的當地日期字串, ex: 2019-02-11
     */  
	public static String newInstance() {
		return dateToString(LocalDate.now());
	}
	
    /**
     * 返回Server的當地日期時間字串
	 * @return 返回Server的當地日期時間字串, ex: 2019-02-11T15:59:29.088
     */  
	public static String newTimeInstance() {
		return dateToString(LocalDateTime.now());
	}
	
    /**
     * 返回UTC日期字串
	 * @return 返回UTC日期字串, ex: 2019-02-11
     */ 
	public static String newUtcInstance() {
		return dateToString(LocalDate.now(ZoneId.of("UTC")));
	}
	
    /**
     * 返回UTC日期時間字串
	 * @return 返回UTC日期時間字串, ex: 2019-02-12T00:02:11.741
     */ 
	public static String newUtcTimeInstance() {
		return dateToString(LocalDateTime.now(ZoneId.of("UTC")));
	}
	
    /**
     * 日期轉換成字串
     * @param date 日期物件
	 * @return 返回字串
     */  
	public static String dateToString(LocalDate date) {
		return date.toString();
	}
	
    /**
     * 日期時間轉換成字串
     * @param date 日期時間物件
	 * @return 返回字串
     */ 
	public static String dateToString(LocalDateTime date) {
		return date.toString();
	}
	
    /**
     * 依據轉換格式，將日期轉換成字串
     * @param date 日期物件
     * @param format 指定轉換格式
	 * @return 返回字串
     */ 
	public static String dateToString(LocalDate date, String format) {
		return date.format(DateTimeFormatter.ofPattern(format));
	}
	
    /**
     * 依據轉換格式，將日期時間轉換成字串
     * @param date 日期時間物件
     * @param format 指定轉換格式
	 * @return 返回字串
     */ 
	public static String dateToString(LocalDateTime date, String format) {
		return date.format(DateTimeFormatter.ofPattern(format));
	}
	
	/**
	 * 依據年月日產生檔名
	 * @return e.g. 20170204
	 */
	public static String generateFileNameInstance() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern(YYYYMMDD_FORMAT));
	}
	
	/**
	 * 根据格式化长度分别返回: 例: &gt;8 2017-08-03 <br>
	 * &gt;8: 20170803 <br>
	 * 7~8: 170803 <br>
	 * 5~6: 1708 <br>
	 * 0~4: 17
	 * @param formatLength 根据格式化长度分别返回
	 * @return 時間字串
	 */
	public static String getDateString(int formatLength) {
		//formatLength = Math.min(formatLength, YYYYMMDD_FORMAT.length());
		String format = formatLength > YYYYMMDD_FORMAT.length() ? YYYYMMDD_FORMAT
						: formatLength > YYMMDD_FORMAT.length() ? YYMMDD_FORMAT
						: formatLength > YYMM_FORMAT.length() ? YYMM_FORMAT
						: "yy";
		return format;
	}
	
	/**
	 * 获取指定日期中的月份的第一天
	 * @param dateString 日期字串, ex: 2019-02-01 
	 * @param addMonth 如果下一个月1，下两个月2，三个月3
	 * @param minDate 用于当转化错误的时候的默认值，如果比对的时候:date(数据库) &lt; minDate(返回值)，则应true ; <br> 未使用
	 * @return yyyy-MM-dd格式，当数据库varchar存储时间时候，可以直接比对大小，如果失败，返回""
	 */
	public static String getMonthStart(String dateString, int addMonth, boolean minDate) {
		LocalDate date = LocalDate.parse(dateString);
		return LocalDate.of(date.getYear(), date.getMonthValue() + addMonth, 1).toString();
	}
	
	/**
	 * 檢核日期格式
	 * @param date 日期字串, ex: 2019-02-01 ; 僅接受yyyy-mm-dd
	 * @return true or false
	 */
	public static boolean isVaildDate(String date) {
		if (date == null) {
			return false;
		}
		try {
			LocalDate.parse(date);
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * 檢核日期時間格式
	 * @param date 日期時間字串, ex: 2019-02-01T10:30:01 ; 僅接受yyyy-mm-ddTHH:MM:SS
	 * @return true or false
	 */
	public static boolean isVaildDateTime(String date) {
		if (date == null) {
			return false;
		}
		try {
			LocalDateTime.parse(date);
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}
	/**
	 * 获取当前时间秒计算的时间戳
	 * @param date
	 * @return
	 */
	public static int getSecondTimestampTwo(Date date){
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime()/1000);
        return Integer.valueOf(timestamp);
    } 
	public static void main(String args[]) {
		Date time = new Date();
        int t =DateUtil.getSecondTimestampTwo(time);
        System.out.println(t);
	}
}
