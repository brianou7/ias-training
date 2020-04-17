package co.edu.ff.orders.product.domain;

import co.edu.ff.orders.product.domain.fields.*;
import lombok.Value;

@Value(staticConstructor = "from")
public class ProductOperationRequest {

    Name name;
    Description description;
    Price price;
    TaxRate taxRate;
    Status status;
    Stock stock;
}
