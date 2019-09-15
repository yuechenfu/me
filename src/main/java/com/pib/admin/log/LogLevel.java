package com.pib.admin.log;

import org.apache.logging.log4j.Level;

public enum LogLevel {
    DEBUG, TRACE, INFO, WARN, ERROR;

    public Level transformToLog4j2() {
        return Level.getLevel(name());
    }
}
