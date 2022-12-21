package com.c0d3m4513r.logger;

import com.c0d3m4513r.plugindef.Plugin;
import lombok.*;
import org.slf4j.Marker;
import org.slf4j.event.Level;

import java.util.Arrays;

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
    private void log(java.util.logging.Level level, String msg, Object... args){
        String log = msg;
        if(args!=null) for (val o:args) {
            //noinspection RegExpRedundantEscape
            log=log.replaceFirst("\\{\\}",o!=null?o.toString():"null");
        }
        logger.log(level,log);
    }

    @Override
    public String getName() {
        return Plugin.name;
    }

    @NonNull
    private java.util.logging.Level getLevel(Level level){
        switch (level){
            case TRACE: return java.util.logging.Level.FINER;
            case DEBUG: return java.util.logging.Level.FINE;
            case WARN: return java.util.logging.Level.WARNING;
            case ERROR: return java.util.logging.Level.SEVERE;
            default: return java.util.logging.Level.INFO;
        }
    }

    @Override
    public boolean isTraceEnabled() {
        return level.toInt()<=Level.TRACE.toInt();
    }

    @Override
    public void trace(String msg) {
        log(getLevel(Level.TRACE),msg);
    }

    @Override
    public void trace(String format, Object arg) {
        log(getLevel(Level.TRACE),format,arg);
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        log(getLevel(Level.TRACE),format, arg1,arg2);
    }

    @Override
    public void trace(String format, Object... arguments) {
        log(getLevel(Level.TRACE),format, Arrays.stream(arguments).toArray());
    }

    @Override
    public void trace(String msg, Throwable t) {
        logger.log(getLevel(Level.TRACE),msg,t);
    }

    @Override
    public boolean isDebugEnabled() {
        return level.toInt()<=Level.DEBUG.toInt();
    }

    @Override
    public void debug(String msg) {
        log(getLevel(Level.DEBUG),msg);
    }

    @Override
    public void debug(String format, Object arg) {
        log(getLevel(Level.DEBUG),format,arg);

    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        log(getLevel(Level.DEBUG),format, arg1,arg2);

    }

    @Override
    public void debug(String format, Object... arguments) {
        log(getLevel(Level.DEBUG),format, Arrays.stream(arguments).toArray());
    }

    @Override
    public void debug(String msg, Throwable t) {
        logger.log(getLevel(Level.DEBUG),msg,t);
    }

    @Override
    public boolean isInfoEnabled() {
        return level.toInt()<=Level.INFO.toInt();
    }

    @Override
    public void info(String msg) {
        log(java.util.logging.Level.INFO,msg);
    }

    @Override
    public void info(String format, Object arg) {
        log(getLevel(Level.INFO),format,arg);
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        log(getLevel(Level.INFO),format, arg1,arg2);
    }

    @Override
    public void info(String format, Object... arguments) {
        log(getLevel(Level.INFO),format, Arrays.stream(arguments).toArray());
    }

    @Override
    public void info(String msg, Throwable t) {
        logger.log(getLevel(Level.INFO),msg,t);;
    }
    @Override
    public boolean isWarnEnabled() {
        return level.toInt()<=Level.WARN.toInt();
    }

    @Override
    public void warn(String msg) {
        log(getLevel(Level.WARN),msg);
    }

    @Override
    public void warn(String format, Object arg) {
        log(getLevel(Level.WARN),format,arg);
    }

    @Override
    public void warn(String format, Object... arguments) {
        log(getLevel(Level.WARN),format, Arrays.stream(arguments).toArray());
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        log(getLevel(Level.WARN),format, arg1,arg2);
    }

    @Override
    public void warn(String msg, Throwable t) {
        logger.log(getLevel(Level.WARN),msg,t);
    }

    @Override
    public boolean isErrorEnabled() {
        return level.toInt()<=Level.ERROR.toInt();
    }

    @Override
    public void error(String msg) {
        log(getLevel(Level.ERROR),msg);
    }

    @Override
    public void error(String format, Object arg) {
        log(getLevel(Level.ERROR),format,arg);
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        log(getLevel(Level.ERROR),format, arg1,arg2);
    }

    @Override
    public void error(String format, Object... arguments) {
        log(getLevel(Level.ERROR),format, Arrays.stream(arguments).toArray());
    }

    @Override
    public void error(String msg, Throwable t) {
        logger.log(getLevel(Level.ERROR),msg,t);
    }
}
