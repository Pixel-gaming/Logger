package com.c0d3m4513r.config.iface;

import com.c0d3m4513r.config.ConfigLogger;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class ConfigLoadableSavableExecuter {
    public static void executeLoadOrSave(Class<? extends Annotation> annotation, String methodName, Object object){
        Arrays.stream(object.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(annotation))
                .forEach(f -> {
                    try {
                        f.setAccessible(true);
                        f.getType().getMethod(methodName).invoke(f.get(object));
                    } catch (NoSuchMethodException ignored) {
                    } catch (SecurityException e){
                        ConfigLogger.getConfigLogger().info("[API] Could not set field '"+ f.getName()+"' of class '"+f.getType().getName()+"' as accessible. The exception was:", e);
                    }catch (InvocationTargetException | IllegalAccessException e) {
                        ConfigLogger.getConfigLogger().error("[API] Could not load value for field '" + f.getName() + "' in class '" + object.getClass().getName() + "' because of the following exception:", e);
                    }
                });
    }
}
