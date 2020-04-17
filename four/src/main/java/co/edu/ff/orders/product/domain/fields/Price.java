package co.edu.ff.orders.product.domain.fields;

import co.edu.ff.orders.common.serialization.AbstractBigDecimalField;
import co.edu.ff.orders.common.serialization.AbstractNotNullField;
import co.edu.ff.orders.common.validations.Preconditions;
import lombok.Value;

import java.math.BigDecimal;

@Value(staticConstructor = "of")
public class Price extends AbstractBigDecimalField {

    BigDecimal value;

    private Price(BigDecimal value) {
        super(value);
        Preconditions.checkArgument(value.compareTo(new BigDecimal(0)) != -1);
        this.value = value;
    }

}
