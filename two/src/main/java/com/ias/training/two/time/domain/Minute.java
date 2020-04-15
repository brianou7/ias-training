package com.ias.training.two.time.domain;

import com.ias.training.two.common.validations.basic.Sexagesimal;
import com.ias.training.two.time.serializers.contracts.IntegerSerializable;
import lombok.Value;

/**
 * Define minutes like sexagesimal valid values.
 */
@Value(staticConstructor = "of")
public class Minute extends Sexagesimal implements IntegerSerializable {

    Integer value;

    private Minute(Integer value) {
        super(value);
        this.value = value;
    }

    @Override
    public Integer valueOf() {
        return this.value;
    }
}
