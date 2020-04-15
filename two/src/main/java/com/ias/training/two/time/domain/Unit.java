package com.ias.training.two.time.domain;

import com.ias.training.two.configuration.domain.Settings;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;

/**
 * Time unit types for compose day's hours.
 */
public enum Unit {

    MILISECONDS,
    SECONDS,
    MINUTES,
    HOURS;

    public static Long totalUnitFromMidnight(Unit unit, LocalTime now) {
        switch (unit) {
            case HOURS:
                return Long.valueOf(now.getHour());
            case MINUTES:
                return (now.getHour() * 60L) + now.getMinute();
            case SECONDS:
                return (now.getHour() * 3600L) + (now.getMinute() * 60L) + now.getSecond();
            case MILISECONDS:
                return (now.getHour() * 3600000L) + (now.getMinute() * 60000L) + (now.getSecond() * 1000);
            default:
                throw new UnsupportedOperationException();
        }
    }

}
