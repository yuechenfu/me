package com.pib.admin.log;

import com.google.common.base.Strings;
import com.pib.admin.exception.type.DefaultMessageException;
import com.pib.admin.exception.type.LogException;
import com.pib.admin.util.DateUtil;
import com.pib.admin.util.ReflectorUtil;

import org.apache.logging.log4j.LogManager;
import org.springframework.dao.DataAccessException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;

import java.util.List;

public class LogUtil {

    public static String getMessageAndLog(Exception e) {
        // message 是用于返回(给客户端)的消息，可以和日志打印的内容无关
        String message = null;
        if (e instanceof DefaultMessageException) {
            message = e.getMessage() != null ? e.getMessage() : ((DefaultMessageException) e).getDefaultMessage();
        }
        if (e instanceof LogException) {
            log(((LogException) e).getLogLevel(), message, e);
        } else if (e instanceof DataAccessException) {
            message = "数据库操作异常";
            error(message, e);
        } else if (e instanceof BindException) {
            FieldError fieldError = ((BindException) e).getFieldErrors().stream().findFirst().get();
            message = fieldError.getObjectName() + "." + fieldError.getField() + " can not be " + fieldError.getRejectedValue();
        } else {
            error("未知异常: " + e.getClass(), e);
        }
        if (DebugSetting.debug) {
            e.printStackTrace();
            if (Strings.isNullOrEmpty(message)) {
                message = "异常: " + e.getClass();
            }
        }
        return message;
    }

    public static void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public static void error(String message, Object... objectArray) {
        log(LogLevel.ERROR, message, objectArray);
    }

    public static void error(String message, Throwable throwable) {
        log(LogLevel.ERROR, message, throwable);
    }

    public static void error(String message, Throwable throwable, Object... objectArray) {
        log(LogLevel.ERROR, message, throwable, objectArray);
    }

    public static void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public static void warn(String message, Object... objectArray) {
        log(LogLevel.WARN, message, objectArray);
    }

    public static void info(String message) {
        log(LogLevel.INFO, message);
    }

    public static void info(String message, Object... objectArray) {
        log(LogLevel.INFO, message, objectArray);
    }

    public static void log(LogLevel level, String message, Object... objectArray) {
        String logger = level == LogLevel.ERROR ? getLogger(false)
                : level == LogLevel.WARN ? getLogger(true)
                : "";
        realTimeLog(level, DateUtil.newTimeInstance() + " " + level + " " + logger + " - " + message);
        // 先显示错误内容，在显示缘由，更适合阅读。故对调
        LogManager.getLogger(message).log(level.transformToLog4j2(), logger, objectArray);
    }

    public static void log(LogLevel level, String message, Throwable throwable, Object... objectArray) {
        String logger = getLogger(throwable);
        realTimeLog(level, DateUtil.newTimeInstance() + " " + level + " " + logger + " - " + message);
        // 先显示错误内容，在显示缘由，更适合阅读。故对调
        LogManager.getLogger(message).log(level.transformToLog4j2(), logger, objectArray);
    }

    public static void debug(Exception e) {
        if (DebugSetting.debug) {
            e.printStackTrace();
        }
    }

    public static void debug(String e) {
        if (DebugSetting.debug) {
            System.out.println(e);
        }
    }

    private static void realTimeLog(LogLevel level, String message) {
//		if (realTimeLogger != null) {
//			realTimeLogger.log(message);
//		}
    }

    private static String getLogger(boolean onlyFirst) {
        String result = null;
        if (onlyFirst) {
            result = ReflectorUtil.getFirstCaller();
        } else {
            List<String> list = ReflectorUtil.getCallerList();
            result = list.toString().replace("[", "[\n\t").replace("]", "\n]").replaceAll(", ", "\n\t");
        }
        return result;
    }

    private static String getLogger(Throwable throwable) {
        String result = null;
        List<String> list = ReflectorUtil.getCallerList(throwable);
        result = list.toString().replace("[", "[\n\t").replace("]", "\n]").replaceAll(", ", "\n\t");
        return result;
    }

}
