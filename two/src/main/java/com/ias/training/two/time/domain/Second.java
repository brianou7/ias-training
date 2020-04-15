package com.ias.training.two.time.domain;

import com.ias.training.two.common.validations.basic.Sexagesimal;
import com.ias.training.two.time.serializers.contracts.IntegerSerializable;
import lombok.Value;

/**
 * Define seconds like sexagesimal valida values.
 */
@Value(staticConstructor = "of")
public class Second extends Sexagesimal implements IntegerSerializable {

    Integer value;

    /**
     * Initialize integer values between 0 and 59.
     *
     * @param value
     * @see AbstractNotNull
     */
    protected Second(Integer value) {
        super(value);
        this.value = value;
    }

    @Override
    public Integer valueOf() {
        return this.value;
    }
}
