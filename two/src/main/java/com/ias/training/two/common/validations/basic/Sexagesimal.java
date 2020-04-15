package com.ias.training.two.common.validations.basic;

import com.ias.training.two.common.Preconditions;

/**
 * Abstract class to define a valid sexagesimal value.
 */
public class Sexagesimal extends AbstractNotNull {

    /**
     * Only values between 0 and 59 allowed.
     *
     * @param value
     * @see AbstractNotNull
     */
    protected Sexagesimal(Integer value) {
        super(value);
        Preconditions.checkSexagesimal(value);
    }

}
