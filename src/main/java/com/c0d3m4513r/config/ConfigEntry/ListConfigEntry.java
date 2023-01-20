package com.c0d3m4513r.config.ConfigEntry;

import com.c0d3m4513r.config.iface.IConfigLoaderSaver;
import com.c0d3m4513r.logger.Logger;
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

    @NonNull
    protected final IConfigLoaderSaver configLoaderSaver;

    public ListConfigEntry(@NonNull ClassValue<List<T>, T> value, @NonNull String configPath, @NonNull IConfigLoaderSaver configLoaderSaver) {
        super(value,configPath);
        this.configLoaderSaver = configLoaderSaver;
    }

    @Override
    @Nullable
    protected List<T> getValueFromLoader() {
        return configLoaderSaver.loadConfigKeyList(configPath,value.getClazz());
    }

    @Override
    public void saveValue(){
        configLoaderSaver.saveConfigKeyList(value.getValue(),value.getClazz(), configPath);
    }
}