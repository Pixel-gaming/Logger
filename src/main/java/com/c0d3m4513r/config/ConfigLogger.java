package com.c0d3m4513r.config;

import com.c0d3m4513r.config.iface.IConfigLoaderSaver;
import com.c0d3m4513r.logger.Logger;
import com.c0d3m4513r.logger.NoopLogger;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public final class ConfigLogger {
    private static Logger configLogger = null;

    public static void setConfigLogger(Logger configLogger) {
        if (configLogger == null) ConfigLogger.configLogger = configLogger;
    }

    public static Logger getConfigLogger() {
        if (configLogger == null) {
            return new NoopLogger();
        }
        return configLogger;
    }

    private static IConfigLoaderSaver configLoaderSaver = null;

    public static void setConfigLoaderSaver(IConfigLoaderSaver configLoaderSaver) {
        if (configLoaderSaver == null) ConfigLogger.configLoaderSaver = configLoaderSaver;
    }
    public static IConfigLoaderSaver getConfigLoaderSaver() {
        if (configLoaderSaver == null) {
            return new IConfigLoaderSaver(){
                @Override
                public <T> boolean saveConfigKey(@Nullable T value, @NonNull Class<T> typeToken, @NonNull String path) {
                    return false;
                }

                @Override
                public <V, T> boolean saveConfigKeyList(@Nullable V value, @NonNull Class<T> typeToken, @NonNull String path) {
                    return false;
                }

                @Override
                public boolean updateConfigLoader() {
                    return false;
                }

                @Override
                public <T> @Nullable T loadConfigKey(String path, Class<T> type) {
                    return null;
                }

                @Override
                public @Nullable <T> List<T> loadConfigKeyList(String path, Class<T> type) {
                    return null;
                }
            };
        }
        return configLoaderSaver;
    }
}
