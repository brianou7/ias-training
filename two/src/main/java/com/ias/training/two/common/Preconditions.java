package com.ias.training.two.common;

import java.util.Objects;

/**
 * Generic preconditions for value-objects.
 */
public class Preconditions {

    /**
     * @param reference any value.
     * @see Objects
     * @throws NullPointerException
     */
    public static void checkNotNull(Object reference) {
        if (Objects.isNull(reference)) {
            throw new NullPointerException();
        }
    }

    /**
     * @param argument
     * @throws IllegalArgumentException
     */
    public static void checkArgument(boolean argument) {
        if (argument) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkSexagesimal(Integer number) {
        if (number < 0 | number > 60) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkMilitaryHour(Integer hour) {
        if (hour < 0 | hour > 23) {
            throw new IllegalArgumentException();
        }
    }

}
