package co.edu.ff.orders.product.domain;

import co.edu.ff.orders.product.domain.contracts.ProductOperation;
import co.edu.ff.orders.product.domain.fields.*;
import lombok.Value;

@Value(staticConstructor = "from")
public class ProductCreated {

    Id id;
    Name name;
    Description description;
    Price price;
    TaxRate taxRate;
    Status status;
    Stock stock;

    public static ProductCreated from(ProductOperationRequest product, Id id) {
        return new ProductCreated(
                id,
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getTaxRate(),
                product.getStatus(),
                product.getStock()
        );
    }

}
