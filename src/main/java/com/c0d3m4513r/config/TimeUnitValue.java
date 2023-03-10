package com.c0d3m4513r.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeUnitValue implements Comparable<TimeUnitValue> {
    @NonNull
    TimeUnit unit;
    long value;

    void add(TimeUnitValue unitValue){
        value+=unit.convert(unitValue.value,unitValue.unit);
    }

    public ChronoUnit getChronoUnit(){
        switch (unit){
            case DAYS: return ChronoUnit.DAYS;
            case HOURS: return ChronoUnit.HOURS;
            case MINUTES: return ChronoUnit.MINUTES;
            case MILLISECONDS: return ChronoUnit.MILLIS;
            case MICROSECONDS: return ChronoUnit.MICROS;
            case NANOSECONDS: return ChronoUnit.NANOS;
            case SECONDS:
            default: return ChronoUnit.SECONDS;
        }
    }

    @Override
    public int compareTo(TimeUnitValue o) {
        if (o.unit == unit)
            return Long.compare(value,o.value);
        return Long.compare(TimeUnit.SECONDS.convert(value,unit), TimeUnit.SECONDS.convert(o.value,o.unit));
    }

    @Override
    public boolean equals(Object obj){
        try {
            TimeUnitValue tuv = (TimeUnitValue) obj;
            return compareTo(tuv)==0;
        }catch (ClassCastException e){
            return false;
        }
    }
}
