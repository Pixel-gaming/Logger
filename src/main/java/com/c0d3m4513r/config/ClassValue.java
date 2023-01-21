package com.c0d3m4513r.config;

import lombok.*;

@Value
@NonNull
public class ClassValue<V,T> {
    V value;
    Class<T> clazz;
}
