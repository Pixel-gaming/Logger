package com.c0d3m4513r.config.ConfigEntry;

import com.c0d3m4513r.config.ConfigLogger;
import com.c0d3m4513r.config.ClassValue;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
/**
 * @type v This is the regular type, e.g. List with String type Parameter
 * @type t This is the due to type erasure
 */
public class ListConfigEntry<T> extends SuperConfigEntry<List<T>,T>{

    public ListConfigEntry(@NonNull ClassValue<List<T>, T> value, @NonNull String configPath) {
        super(value,configPath);
    }

    @Override
    @Nullable
    protected List<T> getValueFromLoader() {
        return ConfigLogger.getConfigLoaderSaver().loadConfigKeyList(configPath,value.getClazz());
    }

    @Override
    public void saveValue(){
        ConfigLogger.getConfigLoaderSaver().saveConfigKeyList(value.getValue(),value.getClazz(), configPath);
    }
}