package co.edu.ff.orders.product.domain.fields;

import co.edu.ff.orders.common.serialization.AbstractStringField;
import co.edu.ff.orders.common.validations.Preconditions;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value(staticConstructor = "of")
public class Name extends AbstractStringField {

    String value;

    private Name(String value) {
        super(value);
        Preconditions.checkArgument(StringUtils.isNoneBlank(value));
        Preconditions.checkArgument(value.length() <= 100);
        this.value = value;
    }

    @Override
    public String valueOf() {
        return value;
    }

}
