package co.edu.ff.orders.product.domain.fields;

import co.edu.ff.orders.common.serialization.AbstractLongField;
import co.edu.ff.orders.common.validations.Preconditions;
import lombok.Value;

@Value(staticConstructor = "of")
public class Id extends AbstractLongField {

    Long value;

    private Id(Long value){
        super(value);
        Preconditions.checkArgument(value > 0);
        this.value = value;
    }

    @Override
    public Long valueOf() {
        return value;
    }

}
