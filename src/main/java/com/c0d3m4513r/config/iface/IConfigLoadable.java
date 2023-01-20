package com.c0d3m4513r.config.iface;

public interface IConfigLoadable {
    /***
     * Loads all necessary Config values, from a IConfigLoader
     */
    default void loadValue() {
        ConfigLoadableSavableExecuter.executeLoadOrSave(Loadable.class, "loadValue", this);
    }
}
