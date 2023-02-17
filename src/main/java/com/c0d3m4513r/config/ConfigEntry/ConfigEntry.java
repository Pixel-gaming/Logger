package com.c0d3m4513r.config.ConfigEntry;

import com.c0d3m4513r.config.ConfigLogger;
import com.c0d3m4513r.config.ClassValue;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * @param <T> The type of value stored at the specified config path
 */
@EqualsAndHashCode(callSuper = true)
public class ConfigEntry<T> extends SuperConfigEntry<T,T>{

    public ConfigEntry(ClassValue<T, T> value, String configPath) {
        super(value,configPath, true);
    }

    public ConfigEntry(ClassValue<T, T> value, String configPath, boolean printValue){
        super(value,configPath, printValue);
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