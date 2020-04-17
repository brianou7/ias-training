package co.edu.ff.orders.product.domain;

import co.edu.ff.orders.product.domain.contracts.ProductOperation;
import co.edu.ff.orders.product.exceptions.ProductException;
import lombok.Value;

@Value(staticConstructor = "of")
public class ProductOperationSuccess implements ProductOperation {

    ProductCreated product;

    @Override
    public ProductCreated value() { return product; }

    @Override
    public String failure() { return null; }

    @Override
    public Boolean isValid() { return null; }
}
