package com.c0d3m4513r.config.ConfigEntry;

import com.c0d3m4513r.config.ConfigLogger;
import com.c0d3m4513r.config.iface.IConfigLoaderSaver;
import com.c0d3m4513r.logger.Logger;
import com.c0d3m4513r.config.ClassValue;
import lombok.*;
import org.jetbrains.annotations.Nullable;

@EqualsAndHashCode(callSuper = true)
/**
 * @type v This is the regular type, e.g. List with String type Parameter
 * @type t This is the due to type erasure
 */
public class ConfigEntry<T> extends SuperConfigEntry<T,T>{

    public ConfigEntry(ClassValue<T, T> value, String configPath) {
        super(value,configPath);
    }
    @Override
    @Nullable
    protected T getValueFromLoader() {
        return ConfigLogger.getConfigLoaderSaver().loadConfigKey(configPath,value.getClazz());
    }

    @Override
    public void saveValue(){
        ConfigLogger.getConfigLoaderSaver().saveConfigKey(value.getValue(),value.getClazz(), configPath);
    }
}