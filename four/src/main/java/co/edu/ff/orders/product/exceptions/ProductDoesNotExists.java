package co.edu.ff.orders.product.exceptions;

import co.edu.ff.orders.product.domain.fields.Id;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value(staticConstructor = "of")
public class ProductDoesNotExists extends ProductException {

    Id id;

    private ProductDoesNotExists(Id id) {
        super(String.format("Product %s does not exists", id));
        this.id = id;
    }

}
