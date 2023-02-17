package com.c0d3m4513r.config.ConfigEntry;

import com.c0d3m4513r.config.ConfigLogger;
import com.c0d3m4513r.config.ClassValue;
import com.c0d3m4513r.config.iface.IConfigLoadableSaveable;
import lombok.*;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.Nullable;

/**
 * @param <V> This is the regular type, e.g. List, String or whatever
 * @param <T> This is the due to type erasure, and contains the type of the List elements or Type V
 */
@Value
@NonFinal
@ToString(doNotUseGetters = true)
@Setter(AccessLevel.PROTECTED)
public abstract class SuperConfigEntry<V,T> implements IConfigLoadableSaveable {
    @NonFinal
    @NonNull
    protected ClassValue<V,T> value;
    @NonNull
    protected String configPath;
    protected boolean printValue;

    @Nullable
    protected abstract V getValueFromLoader();

    public void loadValue(){
        V val = getValueFromLoader();
        if(val!=null){
            if (!value.getValue().equals(val)){
                if (printValue)
                    ConfigLogger.getConfigLogger().info("[API] For config string '{}' replacing '{}' with new Value '{}'",configPath,value.getValue(),val);
                else
                    ConfigLogger.getConfigLogger().info("[API] Updating config key '{}'. Value is hidden for security.", configPath);
            }
            value=new ClassValue<>(val,value.getClazz());
        }else{
            ConfigLogger.getConfigLogger().debug("[API] No value from load value. Saving "+configPath);
            saveValue();
        }
    }

    @NonNull
    public V getValue(){
        return value.getValue();
    }
}
