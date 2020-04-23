package co.edu.ff.orders.product.domain.fields;

import co.edu.ff.orders.common.serialization.AbstractBigDecimalField;
import co.edu.ff.orders.common.serialization.AbstractNotNullField;
import co.edu.ff.orders.common.serialization.IPrimitiveSerializable;
import co.edu.ff.orders.common.validations.Preconditions;
import lombok.Value;

import java.math.BigDecimal;

@Value(staticConstructor = "of")
public class TaxRate extends AbstractBigDecimalField {

    BigDecimal value;

    private TaxRate(BigDecimal value) {
        super(value);
        Preconditions.checkArgument(
                value.compareTo(new BigDecimal(0)) != -1 &&
                value.compareTo(new BigDecimal(1)) != 1
        );
        this.value = value;
    }

    @Override
    public BigDecimal valueOf() {
        return value;
    }

}
