package com.c0d3m4513r.config.ConfigEntry;

import com.c0d3m4513r.config.ConfigLogger;
import com.c0d3m4513r.config.ClassValue;
import com.c0d3m4513r.config.iface.IConfigLoadableSaveable;
import lombok.*;
import org.jetbrains.annotations.Nullable;

@Data
@ToString(doNotUseGetters = true)
@Setter(AccessLevel.PROTECTED)
/**
 * @type v This is the regular type, e.g. List or string
 * @type t This is the due to type erasure, and contains the contents of the List or type v
 */
public abstract class SuperConfigEntry<V,T> implements IConfigLoadableSaveable {
    @NonNull
    protected ClassValue<V,T> value;
    @NonNull
    protected final String configPath;

    @Nullable
    protected abstract V getValueFromLoader();

    public void loadValue(){
        V val = getValueFromLoader();
        if(val!=null){
            if (!value.getValue().equals(val)) ConfigLogger.getConfigLogger().info("[API] For config string '{}' replacing '{}' with new Value '{}'",configPath,value.getValue(),val);
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
