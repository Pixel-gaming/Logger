package com.c0d3m4513r.logger;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoopLogger implements Logger{
    @Override
    public boolean isLogLevelEnabled(LogLevel level) {
        return false;
    }

    @Override
    public void log(LogLevel level, String msg) {}

    @Override
    public void log(LogLevel level, String format, Object arg) {}

    @Override
    public void log(LogLevel level, String format, Object arg1, Object arg2) {}

    @Override
    public void log(LogLevel level, String format, Object... arguments) {}

    @Override
    public void log(LogLevel level, String msg, Throwable t) {}

    @Override
    public String getName() {
        return null;
    }
}
