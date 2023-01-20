package com.c0d3m4513r.config.iface;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface IConfigLoader {
    /***
     * This needs to be Async safe.
     * This will load a Object from the config at the specified config path.
     * @param path Config Path
     * @param type Type of the value stored in the Config
     * @return Returns null or a valid Object of the specified type
     * @param <T> Type of Data stored in the config
     */
    <T> @Nullable T loadConfigKey(String path, Class<T> type);
    /***
     * This needs to be Async safe.
     * This will load a list of Objects from the config at the specified config path.
     * @param path Config Path
     * @param type Type of the value stored in the list
     * @return Returns null or a valid Object of the specified type
     * @param <T> Type of Data stored in the config
     */
    <T> @Nullable List<T> loadConfigKeyList(String path, Class<T> type);

    /***
     * Updates the config Loader, and loads new keys
     * @return if there has been no error, and the config loader has been updated successfully
     */
    boolean updateConfigLoader();
}
