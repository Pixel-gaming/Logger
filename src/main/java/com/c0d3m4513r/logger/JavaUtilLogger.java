package com.c0d3m4513r.logger;

import com.c0d3m4513r.plugindef.Plugin;
import lombok.*;
import org.slf4j.event.Level;

@RequiredArgsConstructor
@EqualsAndHashCode
public class JavaUtilLogger implements Logger {

    @Setter
    @Getter
    @NonNull
    Level level = Level.INFO;
    @NonNull
    @Getter
    java.util.logging.Logger logger;

    @Override
    public boolean isLogLevelEnabled(LogLevel level) {
        return logger.isLoggable(getLevel(level));
    }

    @Override
    public void log(LogLevel level, String msg) {
        logger.log(getLevel(level),msg);
    }

    @Override
    public void log(LogLevel level, String format, Object arg) {
        logger.log(getLevel(level),format,arg);
    }

    @Override
    public void log(LogLevel level, String format, Object arg1, Object arg2) {
        logger.log(getLevel(level),format,new Object[]{arg1, arg2});
    }

    @Override
    public void log(LogLevel level, String format, Object... arguments) {
        logger.log(getLevel(level),format,arguments);
    }

    @Override
    public void log(LogLevel level, String msg, Throwable t) {
        logger.log(getLevel(level),msg,t);
    }

    @Override
    public String getName() {
        return Plugin.name;
    }

    @NonNull
    private java.util.logging.Level getLevel(LogLevel level){
        switch (level){
            case Trace: return java.util.logging.Level.FINER;
            case Debug: return java.util.logging.Level.FINE;
            case Warn: return java.util.logging.Level.WARNING;
            case Error: return java.util.logging.Level.SEVERE;
            case Info:
            default: return java.util.logging.Level.INFO;
        }
    }
}
