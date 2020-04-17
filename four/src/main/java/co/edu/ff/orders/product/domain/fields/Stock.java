package co.edu.ff.orders.product.domain.fields;

import co.edu.ff.orders.common.serialization.AbstractIntegerField;
import co.edu.ff.orders.common.validations.Preconditions;
import lombok.Value;

@Value(staticConstructor = "of")
public class Stock extends AbstractIntegerField {

    Integer value;

    private Stock(Integer value) {
        super(value);
        Preconditions.checkArgument(value >= 0);
        this.value = value;
    }

}
