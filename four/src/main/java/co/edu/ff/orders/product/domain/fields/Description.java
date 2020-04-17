package co.edu.ff.orders.product.domain.fields;

import co.edu.ff.orders.common.serialization.AbstractStringField;
import co.edu.ff.orders.common.validations.Preconditions;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value(staticConstructor = "of")
public class Description extends AbstractStringField {

    String value;

    private Description(String value) {
        super(value);
        Preconditions.checkArgument(StringUtils.isNoneBlank(value));
        Preconditions.checkArgument(value.length() <= 280);
        this.value = value;
    }

}
