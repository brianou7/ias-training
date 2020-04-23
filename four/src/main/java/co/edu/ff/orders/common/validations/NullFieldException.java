package co.edu.ff.orders.common.validations;

import co.edu.ff.orders.product.domain.fields.Id;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value(staticConstructor = "of")
public class NullFieldException extends RuntimeException {

    String fieldName;

    private NullFieldException(String fieldName) {
        super(String.format("%s field cannot be null", fieldName));
        this.fieldName = fieldName;
    }

}