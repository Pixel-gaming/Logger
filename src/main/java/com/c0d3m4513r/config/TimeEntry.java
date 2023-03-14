package com.c0d3m4513r.config;

import lombok.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.math.BigInteger;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
@Data
@Setter(AccessLevel.NONE)
@Getter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeEntry implements Comparable<TimeEntry> {
    public long days = 0;
    public long hours = 0;
    public long minutes = 0;
    public long seconds = 0;
    public long ms = 0;
    public long us = 0;
    public long ns = 0;

    public long getTime(TimeUnit unit){
        switch (unit){
            case NANOSECONDS: return ns;
            case MICROSECONDS: return us;
            case MILLISECONDS: return ms;
            case SECONDS: return seconds;
            case MINUTES: return minutes;
            case HOURS: return hours;
            case DAYS: return days;
            default: throw new RuntimeException("Too many enum variants");
        }
    }

    public void setTime(TimeUnit unit, long value){
        switch (unit){
            case NANOSECONDS:
                ns = value;
                return;
            case MICROSECONDS:
                us = value;
                return;
            case MILLISECONDS:
                ms = value;
                return;
            case SECONDS:
                seconds = value;
                return;
            case MINUTES:
                minutes = value;
                return;
            case HOURS:
                hours = value;
                return;
            case DAYS:
                days = value;
                return;
            default: throw new RuntimeException("Too many enum variants");
        }
    }

    public static @NonNull Optional<TimeEntry> of(@Nullable String unit, @Nullable String value){
        long longValue;
        if (value == null || unit == null) return Optional.empty();
        try {
            longValue = Long.parseLong(value);
        }catch (NumberFormatException e){
            return Optional.empty();
        }
        TimeEntry te = new TimeEntry();
        switch (unit) {
            case "ns":
            case "nanosecond":
            case "nanoseconds":
                te.ns = longValue;
                break;
            case "ys":
            case "us":
            case "microsecond":
            case "microseconds":
                te.us = longValue;
                break;
            case "ms":
            case "millisecond":
            case "milliseconds":
                te.ms = longValue;
                break;
            case "s":
            case "sec":
            case "second":
            case "seconds":
                te.seconds = longValue;
                break;
            case "m":
            case "min":
            case "minúte":
            case "minute":
                te.minutes = longValue;
                break;
            case "h":
            case "hour":
            case "hours":
                te.hours = longValue;
                break;
            case "d":
            case "day":
            case "days":
                te.days = longValue;
                break;
            default:
                return Optional.empty();
        }

        return Optional.of(te);
    }
    public static @NonNull Optional<TimeEntry> of(@NonNull String parse){
        TimeEntry te = new TimeEntry();
        for(val s:parse.split("\\+")){
            try{
                TimeUnit u = null;
                String value = null;
                for (val entry:Convert.timeUnit.entrySet()){
                    if (s.endsWith(entry.getKey())){
                        u=entry.getValue();
                        value=s.substring(0,s.length()-entry.getKey().length())
                                //compatibility
                                .replace(",","");
                        break;
                    }
                }
                if(u==null||value==null){
                    ConfigLogger.getConfigLogger().info("[API] The unit was likely invalid");
                    return Optional.empty();
                }
                long val = Long.parseLong(value);
                switch (u){
                    case DAYS:te.days+=val; break;
                    case HOURS:te.hours+=val; break;
                    case MINUTES:te.minutes+=val; break;
                    case SECONDS:te.seconds+=val; break;
                    case MILLISECONDS:te.ms+=val; break;
                    case MICROSECONDS:te.us+=val; break;
                    case NANOSECONDS:te.ns+=val; break;
                }
            }catch (NullPointerException | NumberFormatException e){
                ConfigLogger.getConfigLogger().error("[API] Could not convert string to TimeEntry. Error is: ",e);
                return Optional.empty();
            }
        }
        return Optional.of(te);
    }
    @Contract(pure = true)
    public static @NonNull TimeEntry of(@NonNull TimeUnitValue tuv){
        TimeEntry te = new TimeEntry();
        te.setTime(tuv.getUnit(),tuv.getValue());
        return te;
    }

    public void add(TimeEntry te){
        days+=te.days;
        hours+=te.hours;
        minutes+=te.minutes;
        seconds+=te.seconds;
        ms+=te.ms;
        us+=te.us;
        ns+=te.ns;
    }

    public void sub(TimeEntry te){
        days-=te.days;
        hours-=te.hours;
        minutes-=te.minutes;
        seconds-=te.seconds;
        ms-=te.ms;
        us-=te.us;
        ns-=te.ns;
    }

    public BigInteger to(TimeUnit unit){
        return BigInteger.valueOf(unit.convert(ns, TimeUnit.NANOSECONDS))
                .add(BigInteger.valueOf(unit.convert(us, TimeUnit.MICROSECONDS)))
                .add(BigInteger.valueOf(unit.convert(ms, TimeUnit.MILLISECONDS)))
                .add(BigInteger.valueOf(unit.convert(seconds, TimeUnit.SECONDS)))
                .add(BigInteger.valueOf(unit.convert(minutes, TimeUnit.MINUTES)))
                .add(BigInteger.valueOf(unit.convert(hours, TimeUnit.HOURS)))
                .add(BigInteger.valueOf(unit.convert(days, TimeUnit.DAYS)));
    }
    public long getHours(){return days*24+hours;}
    public long getMinutes(){return getHours()*60+minutes;}
    public long getSeconds(){return getMinutes()*60+seconds;}
    public long getMs(){return getSeconds()*1000+ms;}
    public long getUs(){return getMs()*1000+us;}
    public long getNs(){return getUs()*1000+ns;}
    public TimeUnitValue getMaxUnit(){
        if (ns==0){
            if (us==0){
                if (ms==0){
                    if (seconds==0){
                        if (minutes==0){
                            if (hours==0){
                                return new TimeUnitValue(TimeUnit.DAYS,days);
                            }else{
                                return new TimeUnitValue(TimeUnit.HOURS,getHours());
                            }
                        }else{
                            return new TimeUnitValue(TimeUnit.MINUTES,getMinutes());
                        }
                    }else{
                        return new TimeUnitValue(TimeUnit.SECONDS,getSeconds());
                    }
                }else{
                    return new TimeUnitValue(TimeUnit.MILLISECONDS,getMs());
                }
            }else{
                return new TimeUnitValue(TimeUnit.MICROSECONDS,getUs());
            }
        }else{
            return new TimeUnitValue(TimeUnit.NANOSECONDS,getNs());
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if (days != 0) sb.append(days).append("d");
        if (hours != 0) sb.append(hours).append("h");
        if (minutes != 0) sb.append(minutes).append("m");
        if (seconds != 0) sb.append(seconds).append("s");
        if (ms != 0) sb.append(ms).append("ms");
        if (us != 0) sb.append(us).append("us");
        if (ns != 0) sb.append(ns).append("ns");
        return sb.toString();
    }

    @Override
    public int compareTo(@NonNull TimeEntry o) {
        return to(TimeUnit.NANOSECONDS).compareTo(o.to(TimeUnit.NANOSECONDS));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TimeEntry) {
            return compareTo((TimeEntry) obj) == 0;
        } else {
            return false;
        }
    }
    @Override
    public int hashCode(){
        return to(TimeUnit.NANOSECONDS).hashCode();
    }
}
