package com.c0d3m4513r.config.iface;

public interface IConfigSavable {
    /***
     * Saves all necessary Config values, to a IConfigSaver
     */
    default void saveValue(){
        ConfigLoadableSavableExecuter.executeLoadOrSave(Savable.class, "saveValue", this);
    }
}
