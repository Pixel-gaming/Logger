package com.c0d3m4513r.config.iface;

import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

public interface IConfigSaver {
    /**
     * This needs to be Async safe.
     * This will save an Object from the config at the specified config path.
     * @param path Config Path
     * @param typeToken Type of the value stored in the Config
     * @param value Value to be stored in the config
     * @return Returns null or a valid Object of the specified type
     * @param <T> Type of Data stored in the config
     */
    <T> boolean saveConfigKey(@Nullable T value, @NonNull Class<T> typeToken, @NonNull String path);
    /**
     * This needs to be Async safe.
     * This will save a list from the config at the specified config path.
     * <p>
     * This method expects the actual type of value to be something like List&lt;T&gt;
     * @param path Config Path
     * @param typeToken Type of the value stored in the Config
     * @param value Value to be stored in the config
     * @return Returns null or a valid Object of the specified type
     * @param <T> Type of Data stored in the config
     * @param <V> List Type
     */
    <V,T> boolean saveConfigKeyList(@Nullable V value, @NonNull Class<T> typeToken, @NonNull String path);

    /***
     * Updates the config Loader, and loads new keys
     * @return if there has been no error, and the config loader has been updated successfully
     */
    boolean updateConfigLoader();
}
