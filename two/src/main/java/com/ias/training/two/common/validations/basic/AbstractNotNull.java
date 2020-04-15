package com.ias.training.two.common.validations.basic;

import com.ias.training.two.common.Preconditions;

/**
 * Define a not nullable value-object.
 *
 * @see Preconditions
 */
public abstract class AbstractNotNull {

    /**
     * Initialize and valid like a not nul value.
     * @param value any value.
     */
    protected AbstractNotNull(Object value) {
        Preconditions.checkNotNull(value);
    }

}
