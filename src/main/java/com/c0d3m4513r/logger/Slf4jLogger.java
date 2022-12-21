package com.c0d3m4513r.logger;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;


//This converts a slf4j:1.7.15 or later Logger into a Logger compatible with the API
@AllArgsConstructor
public class Slf4jLogger implements Logger {
    @NonNull
    private Object logger;
    private Class<?> clazz;

    ///@throws ClassCastException if the logger is not from org.slf4j.Logger (this includes relocations)
    public Slf4jLogger(org.slf4j.Logger logger){
        this(logger, org.slf4j.Logger.class);
    }


    @SneakyThrows
    @Override
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public String getName() {
        return (String) clazz.getMethod("getName").invoke(logger);
    }


    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public boolean isTraceEnabled() {
        return (boolean) clazz.getMethod("isTraceEnabled").invoke(logger);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void trace(String msg) {
        clazz.getMethod("trace", String.class).invoke(logger, msg);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void trace(String format, Object arg) {
        clazz.getMethod("trace", String.class, Object.class).invoke(logger, format, arg);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void trace(String format, Object arg1, Object arg2) {
        clazz.getMethod("trace", String.class, Object.class, Object.class).invoke(logger, format, arg1, arg2);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void trace(String format, Object... arguments) {
        clazz.getMethod("trace", String.class, Object[].class).invoke(logger, format, arguments);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException or ClassCastException if the specified logger from the constructor is not compatible.
    public void trace(String msg, Throwable t) {
        clazz.getMethod("trace", String.class, Throwable.class).invoke(logger, msg, t);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public boolean isDebugEnabled() {
        return (boolean) clazz.getMethod("isDebugEnabled").invoke(logger);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void debug(String msg) {
        clazz.getMethod("debug", String.class).invoke(logger, msg);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void debug(String format, Object arg) {
        clazz.getMethod("debug", String.class, Object.class).invoke(logger, format, arg);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void debug(String format, Object arg1, Object arg2) {
        clazz.getMethod("debug", String.class, Object.class, Object.class).invoke(logger, format, arg1, arg2);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void debug(String format, Object... arguments) {
        clazz.getMethod("debug", String.class, Object[].class).invoke(logger, format, arguments);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void debug(String msg, Throwable t) {
        clazz.getMethod("debug", String.class, Throwable.class).invoke(logger, msg, t);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public boolean isInfoEnabled() {
        return (boolean) clazz.getMethod("isInfoEnabled").invoke(logger);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void info(String msg) {
        clazz.getMethod("info", String.class).invoke(logger, msg);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void info(String format, Object arg) {
        clazz.getMethod("info", String.class, Object.class).invoke(logger, format, arg);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void info(String format, Object arg1, Object arg2) {
        clazz.getMethod("info", String.class, Object.class, Object.class).invoke(logger, format, arg1, arg2);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void info(String format, Object... arguments) {
        clazz.getMethod("info", String.class, Object[].class).invoke(logger, format, arguments);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void info(String msg, Throwable t) {
        clazz.getMethod("info", String.class, Throwable.class).invoke(logger, msg, t);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public boolean isWarnEnabled() {
        return (boolean) clazz.getMethod("isWarnEnabled").invoke(logger);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void warn(String msg) {
        clazz.getMethod("warn", String.class).invoke(logger, msg);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void warn(String format, Object arg) {
        clazz.getMethod("warn", String.class, Object.class).invoke(logger, format, arg);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void warn(String format, Object... arguments) {
        clazz.getMethod("warn", String.class, Object[].class).invoke(logger, format, arguments);
    }


    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void warn(String format, Object arg1, Object arg2) {
        clazz.getMethod("warn", String.class, Object.class, Object.class).invoke(logger, format, arg1, arg2);
    }

    @Override
    @SneakyThrows
    public void warn(String msg, Throwable t) {
        clazz.getMethod("warn", String.class, Throwable.class).invoke(logger, msg, t);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public boolean isErrorEnabled() {
        return (boolean) clazz.getMethod("isErrorEnabled").invoke(logger);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void error(String msg) {
        clazz.getMethod("error", String.class).invoke(logger, msg);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void error(String format, Object arg) {
        clazz.getMethod("error", String.class, Object.class).invoke(logger, format, arg);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void error(String format, Object arg1, Object arg2) {
        clazz.getMethod("error", String.class, Object.class, Object.class).invoke(logger, format, arg1, arg2);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void error(String format, Object... arguments) {
        clazz.getMethod("error", String.class, Object[].class).invoke(logger, format, arguments);
    }

    @Override
    @SneakyThrows
    ///@throws NoSuchMethodException if the specified logger from the constructor is not compatible.
    public void error(String msg, Throwable t) {
        clazz.getMethod("error", String.class, Throwable.class).invoke(logger, msg, t);
    }
}
