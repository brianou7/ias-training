package com.ias.training.two.time.domain;

import com.ias.training.two.common.Preconditions;
import com.ias.training.two.common.validations.basic.AbstractNotNull;
import com.ias.training.two.time.serializers.contracts.IntegerSerializable;
import lombok.Value;

/**
 * Define a valid military hour like an integer value between
 * 0 and 23.
 */
@Value(staticConstructor = "of")
public class Hour extends AbstractNotNull implements IntegerSerializable {

    Integer value;

    /**
     * @param value any integer value.
     * @see AbstractNotNull
     * @see Preconditions
     */
    private Hour(Integer value) {
        super(value);
        Preconditions.checkMilitaryHour(value);
        this.value = value;
    }

    @Override
    public Integer valueOf() {
        return this.value;
    }
}
